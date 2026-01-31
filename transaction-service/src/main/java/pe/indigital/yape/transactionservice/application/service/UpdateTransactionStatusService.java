package pe.indigital.yape.transactionservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.indigital.yape.transactionservice.application.dto.UpdateStatusCommand;
import pe.indigital.yape.transactionservice.domain.model.Transaction;
import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;
import pe.indigital.yape.transactionservice.domain.ports.in.UpdateTransactionStatusUseCase;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionRepositoryPort;

@Service
@RequiredArgsConstructor
public class UpdateTransactionStatusService implements UpdateTransactionStatusUseCase {

    private final TransactionRepositoryPort repository;

    @Override
    @Transactional
    public void updateStatus(UpdateStatusCommand command) {
        repository.findByExternalId(command.transactionExternalId())
                .filter(tx -> tx.status() == TransactionStatus.PENDING) // idempotencia simple
                .map(tx -> new Transaction(
                        tx.id(),
                        tx.transactionExternalId(),
                        tx.accountExternalIdDebit(),
                        tx.accountExternalIdCredit(),
                        tx.transferTypeId(),
                        tx.value(),
                        command.status(),
                        tx.createdAt()
                ))
                .ifPresent(repository::save);
    }
}
