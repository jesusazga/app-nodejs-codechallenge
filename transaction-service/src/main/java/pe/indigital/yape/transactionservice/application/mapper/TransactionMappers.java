package pe.indigital.yape.transactionservice.application.mapper;

import pe.indigital.yape.transactionservice.application.dto.TransactionResult;
import pe.indigital.yape.transactionservice.domain.model.Transaction;

import java.util.function.Function;

public final class TransactionMappers {

    private TransactionMappers(){}

    public static final Function<Transaction, TransactionResult> toResult =
            tx -> new TransactionResult(
                    tx.transactionExternalId(),
                    tx.transferTypeId(),
                    tx.status(),
                    tx.value(),
                    tx.createdAt()
            );
}
