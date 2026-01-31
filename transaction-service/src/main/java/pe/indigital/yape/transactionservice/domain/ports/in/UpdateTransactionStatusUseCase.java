package pe.indigital.yape.transactionservice.domain.ports.in;

import pe.indigital.yape.transactionservice.application.dto.UpdateStatusCommand;

public interface UpdateTransactionStatusUseCase {
    void updateStatus(UpdateStatusCommand command);
}
