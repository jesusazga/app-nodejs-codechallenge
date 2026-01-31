package pe.indigital.yape.antifraud.adapters.in.messaging.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.indigital.yape.antifraud.FraudDecisionResult;
import pe.indigital.yape.antifraud.adapters.in.messaging.kafka.dto.TransactionStatusUpdatedEvent;
import pe.indigital.yape.antifraud.domain.ports.out.FraudDecisionPublisherPort;

@Component
@RequiredArgsConstructor
public class KafkaFraudDecisionPublisher implements FraudDecisionPublisherPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topics.transaction-status-updated}")
    private String statusTopic;

    @Override
    public void publish(FraudDecisionResult result) {
        var event = new TransactionStatusUpdatedEvent(
                result.transactionExternalId(),
                result.decision().name(), // "APPROVED" or "REJECTED"
                result.reason(),
                result.evaluatedAt()
        );
        kafkaTemplate.send(statusTopic, result.transactionExternalId().toString(), event);
    }
}
