package pe.indigital.yape.transactionservice.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionCommand(
        UUID accountExternalIdDebit,
        UUID accountExternalIdCredit,
        Integer transferTypeId,
        BigDecimal value
) {
}
