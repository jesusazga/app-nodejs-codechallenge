package pe.indigital.yape.transactionservice.application.dto;

import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionResult(
        UUID transactionExternalId,
        Integer transferTypeId,
        TransactionStatus status,
        BigDecimal value,
        Instant createdAt
) {
}
