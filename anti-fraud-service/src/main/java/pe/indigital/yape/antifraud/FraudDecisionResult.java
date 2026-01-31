package pe.indigital.yape.antifraud;

import pe.indigital.yape.antifraud.domain.model.Decision;

import java.time.Instant;
import java.util.UUID;

public record FraudDecisionResult(
        UUID transactionExternalId,
        Decision decision,
        String reason,
        Instant evaluatedAt
) {
}
