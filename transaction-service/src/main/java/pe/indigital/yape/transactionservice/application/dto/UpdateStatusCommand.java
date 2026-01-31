package pe.indigital.yape.transactionservice.application.dto;

import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.util.UUID;

public record UpdateStatusCommand(
        UUID transactionExternalId,
        TransactionStatus status,
        String reason
) {
}
