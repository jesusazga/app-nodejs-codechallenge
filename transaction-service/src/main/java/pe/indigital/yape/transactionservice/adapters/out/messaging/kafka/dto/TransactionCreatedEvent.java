package pe.indigital.yape.transactionservice.adapters.out.messaging.kafka.dto;

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
