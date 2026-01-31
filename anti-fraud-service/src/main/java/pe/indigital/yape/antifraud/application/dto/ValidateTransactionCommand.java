package pe.indigital.yape.antifraud.application.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ValidateTransactionCommand(
        UUID transactionExternalId,
        UUID accountExternalIdDebit,
        UUID accountExternalIdCredit,
        Integer transferTypeId,
        BigDecimal value,
        Instant createdAt
) {
}
