package pe.indigital.yape.transactionservice.adapters.in.web.mapper;

import pe.indigital.yape.transactionservice.adapters.in.web.dto.CreateTransactionRequest;
import pe.indigital.yape.transactionservice.application.dto.CreateTransactionCommand;

import java.util.function.Function;

public final class WebMappers {

    private WebMappers(){}

    public static final Function<CreateTransactionRequest, CreateTransactionCommand> toCommand =
            r -> new CreateTransactionCommand(
                    r.accountExternalIdDebit(),
                    r.accountExternalIdCredit(),
                    r.transferTypeId(),
                    r.value()
            );
}
