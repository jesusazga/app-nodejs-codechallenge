package pe.indigital.yape.transactionservice.domain.ports.out;

import pe.indigital.yape.transactionservice.domain.model.Transaction;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepositoryPort {
    Transaction save(Transaction tx);
    Optional<Transaction> findByExternalId(UUID externalId);
}
