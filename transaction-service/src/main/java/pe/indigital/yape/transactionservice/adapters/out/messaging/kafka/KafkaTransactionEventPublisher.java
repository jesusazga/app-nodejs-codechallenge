package pe.indigital.yape.transactionservice.adapters.out.messaging.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pe.indigital.yape.transactionservice.adapters.out.messaging.kafka.dto.TransactionCreatedEvent;
import pe.indigital.yape.transactionservice.domain.model.Transaction;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionEventPublisherPort;

@Component
@RequiredArgsConstructor
public class KafkaTransactionEventPublisher implements TransactionEventPublisherPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topics.transaction-created}")
    private String createdTopic;

    @Override
    public void publishTransactionCreated(Transaction tx) {
        var event = new TransactionCreatedEvent(
                tx.transactionExternalId(),
                tx.accountExternalIdDebit(),
                tx.accountExternalIdCredit(),
                tx.transferTypeId(),
                tx.value(),
                tx.createdAt()
        );
        kafkaTemplate.send(createdTopic, tx.transactionExternalId().toString(), event);
    }
}
