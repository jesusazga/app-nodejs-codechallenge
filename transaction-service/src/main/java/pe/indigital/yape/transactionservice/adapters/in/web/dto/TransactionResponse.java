package pe.indigital.yape.transactionservice.adapters.in.web.dto;

import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionResponse(
        UUID transactionExternalId,
        Integer transferTypeId,
        TransactionStatus status,
        BigDecimal value,
        Instant createdAt
) {
}
