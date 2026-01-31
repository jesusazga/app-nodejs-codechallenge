package pe.indigital.yape.transactionservice.domain.ports.out;

import pe.indigital.yape.transactionservice.domain.model.Transaction;

public interface TransactionEventPublisherPort {
    void publishTransactionCreated(Transaction tx);
}
