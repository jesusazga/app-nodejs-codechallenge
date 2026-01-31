package pe.indigital.yape.antifraud.domain.ports.out;

import pe.indigital.yape.antifraud.FraudDecisionResult;

public interface FraudDecisionPublisherPort {
    void publish(FraudDecisionResult result);
}
