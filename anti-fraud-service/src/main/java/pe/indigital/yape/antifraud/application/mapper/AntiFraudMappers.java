package pe.indigital.yape.antifraud.application.mapper;

import pe.indigital.yape.antifraud.application.dto.ValidateTransactionCommand;
import pe.indigital.yape.antifraud.domain.model.TransactionToValidate;

import java.util.function.Function;

public final class AntiFraudMappers {
    private AntiFraudMappers(){}

    public static final Function<TransactionToValidate, ValidateTransactionCommand> toCommand =
            tx -> new ValidateTransactionCommand(
                    tx.transactionExternalId(),
                    tx.accountExternalIdDebit(),
                    tx.accountExternalIdCredit(),
                    tx.transferTypeId(),
                    tx.value(),
                    tx.createdAt()
            );
}
