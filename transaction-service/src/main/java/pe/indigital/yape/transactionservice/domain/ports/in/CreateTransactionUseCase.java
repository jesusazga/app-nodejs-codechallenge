package pe.indigital.yape.transactionservice.domain.ports.in;

import pe.indigital.yape.transactionservice.application.dto.CreateTransactionCommand;

import java.util.UUID;

public interface CreateTransactionUseCase {
    UUID create(CreateTransactionCommand command);
}
