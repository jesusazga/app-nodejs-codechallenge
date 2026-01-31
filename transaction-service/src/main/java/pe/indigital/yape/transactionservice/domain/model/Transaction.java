package pe.indigital.yape.transactionservice.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Transaction(
        UUID id,
        UUID transactionExternalId,
        UUID accountExternalIdDebit,
        UUID accountExternalIdCredit,
        Integer transferTypeId,
        BigDecimal value,
        TransactionStatus status,
        Instant createdAt
) {
}
