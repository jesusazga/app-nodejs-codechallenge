package pe.indigital.yape.antifraud.adapters.in.messaging.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pe.indigital.yape.antifraud.adapters.in.messaging.kafka.dto.TransactionCreatedEvent;
import pe.indigital.yape.antifraud.application.dto.ValidateTransactionCommand;
import pe.indigital.yape.antifraud.domain.ports.in.ValidateTransactionUseCase;

@Component
@RequiredArgsConstructor
public class TransactionCreatedListener {

    private final ValidateTransactionUseCase validateUC;

    @KafkaListener(topics = "${app.kafka.topics.transaction-created}")
    public void onMessage(TransactionCreatedEvent event) {
        validateUC.validate(new ValidateTransactionCommand(
                event.transactionExternalId(),
                event.accountExternalIdDebit(),
                event.accountExternalIdCredit(),
                event.transferTypeId(),
                event.value(),
                event.createdAt()
        ));
    }
}
