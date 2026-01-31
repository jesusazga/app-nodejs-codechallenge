package pe.indigital.yape.transactionservice.adapters.out.persistence.jpa.mapper;

import pe.indigital.yape.transactionservice.adapters.out.persistence.jpa.TransactionEntity;
import pe.indigital.yape.transactionservice.domain.model.Transaction;

import java.util.function.Function;

public final class JpaMappers {
    private JpaMappers(){}

    public static final Function<Transaction, TransactionEntity> toEntity = tx ->
            TransactionEntity.builder()
                    .id(tx.id())
                    .transactionExternalId(tx.transactionExternalId())
                    .accountExternalIdDebit(tx.accountExternalIdDebit())
                    .accountExternalIdCredit(tx.accountExternalIdCredit())
                    .transferTypeId(tx.transferTypeId())
                    .value(tx.value())
                    .status(tx.status())
                    .createdAt(tx.createdAt())
                    .build();

    public static final Function<TransactionEntity, Transaction> toDomain = e ->
            new Transaction(
                    e.getId(),
                    e.getTransactionExternalId(),
                    e.getAccountExternalIdDebit(),
                    e.getAccountExternalIdCredit(),
                    e.getTransferTypeId(),
                    e.getValue(),
                    e.getStatus(),
                    e.getCreatedAt()
            );
}
