package pe.indigital.yape.antifraud.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.indigital.yape.antifraud.FraudDecisionResult;
import pe.indigital.yape.antifraud.application.dto.ValidateTransactionCommand;
import pe.indigital.yape.antifraud.domain.model.Decision;
import pe.indigital.yape.antifraud.domain.ports.in.ValidateTransactionUseCase;
import pe.indigital.yape.antifraud.domain.ports.out.FraudDecisionPublisherPort;
import pe.indigital.yape.antifraud.domain.service.FraudRulesEngine;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ValidateTransactionService implements ValidateTransactionUseCase {

    private final FraudDecisionPublisherPort publisher;
    private final FraudRulesEngine rules = new FraudRulesEngine();

    @Override
    public FraudDecisionResult validate(ValidateTransactionCommand command) {
        Decision decision = rules.evaluate(command.value());
        var result = new FraudDecisionResult(
                command.transactionExternalId(),
                decision,
                rules.reason(decision),
                Instant.now()
        );
        publisher.publish(result);
        return result;
    }
}
