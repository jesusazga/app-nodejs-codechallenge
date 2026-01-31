package pe.indigital.yape.antifraud.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionToValidate(
        UUID transactionExternalId,
        UUID accountExternalIdDebit,
        UUID accountExternalIdCredit,
        Integer transferTypeId,
        BigDecimal value,
        Instant createdAt
) {
}
