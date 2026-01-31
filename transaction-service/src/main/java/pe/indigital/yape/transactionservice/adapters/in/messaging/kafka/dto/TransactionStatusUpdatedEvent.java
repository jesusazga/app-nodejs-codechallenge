package pe.indigital.yape.transactionservice.adapters.in.messaging.kafka.dto;

import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.time.Instant;
import java.util.UUID;

public record TransactionStatusUpdatedEvent(
        UUID transactionExternalId,
        String status,
        String reason,
        Instant evaluatedAt
) {
}
