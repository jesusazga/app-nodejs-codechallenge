package pe.indigital.yape.transactionservice.domain.ports.in;

import pe.indigital.yape.transactionservice.application.dto.TransactionResult;

import java.util.UUID;

public interface GetTransactionUseCase {
    TransactionResult get(UUID transactionExternalId);
}
