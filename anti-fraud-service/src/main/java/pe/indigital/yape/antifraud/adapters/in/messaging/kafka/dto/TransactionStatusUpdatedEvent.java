package pe.indigital.yape.antifraud.adapters.in.messaging.kafka.dto;

import java.time.Instant;
import java.util.UUID;

public record TransactionStatusUpdatedEvent(
        UUID transactionExternalId,
        String status,   // "APPROVED" | "REJECTED"
        String reason,
        Instant evaluatedAt
) {
}
