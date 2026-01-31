package pe.indigital.yape.transactionservice.adapters.in.messaging.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.indigital.yape.transactionservice.adapters.in.messaging.kafka.dto.TransactionStatusUpdatedEvent;
import pe.indigital.yape.transactionservice.application.dto.UpdateStatusCommand;
import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;
import pe.indigital.yape.transactionservice.domain.ports.in.UpdateTransactionStatusUseCase;

@Component
@RequiredArgsConstructor
public class TransactionStatusUpdatedListener {

    private final UpdateTransactionStatusUseCase updateUC;

    @KafkaListener(topics = "${app.kafka.topics.transaction-status-updated}")
    public void onMessage(TransactionStatusUpdatedEvent event) {
        updateUC.updateStatus(new UpdateStatusCommand(
                event.transactionExternalId(),
                TransactionStatus.valueOf(event.status()),
                event.reason()
        ));
    }
}
