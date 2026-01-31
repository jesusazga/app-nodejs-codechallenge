package pe.indigital.yape.antifraud.adapters.in.messaging.kafka.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionCreatedEvent(
        UUID transactionExternalId,
        UUID accountExternalIdDebit,
        UUID accountExternalIdCredit,
        Integer transferTypeId,
        BigDecimal value,
        Instant createdAt
) {
}
