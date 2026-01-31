package pe.indigital.yape.transactionservice.adapters.in.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequest(
        @NotNull UUID accountExternalIdDebit,
        @NotNull UUID accountExternalIdCredit,
        @NotNull Integer transferTypeId,
        @NotNull @Positive BigDecimal value
) {
}
