package pe.indigital.yape.transactionservice.domain.service;

import pe.indigital.yape.transactionservice.domain.model.Transaction;
import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.time.Instant;
import java.util.UUID;

public class TransactionDomainService {

    public Transaction createNew(Transaction draft) {
        return new Transaction(
                null,
                UUID.randomUUID(),
                draft.accountExternalIdDebit(),
                draft.accountExternalIdCredit(),
                draft.transferTypeId(),
                draft.value(),
                TransactionStatus.PENDING,
                Instant.now()
        );
    }
}
