package pe.indigital.yape.antifraud.domain.ports.in;

import pe.indigital.yape.antifraud.FraudDecisionResult;
import pe.indigital.yape.antifraud.application.dto.ValidateTransactionCommand;

public interface ValidateTransactionUseCase {
    FraudDecisionResult validate(ValidateTransactionCommand command);
}
