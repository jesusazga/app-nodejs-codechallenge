package pe.indigital.yape.antifraud.domain.service;

import pe.indigital.yape.antifraud.domain.model.Decision;

import java.math.BigDecimal;

public class FraudRulesEngine {

    private static final BigDecimal LIMIT = new BigDecimal("1000");

    public Decision evaluate(BigDecimal value) {
        return value.compareTo(LIMIT) > 0 ? Decision.REJECTED : Decision.APPROVED;
    }

    public String reason(Decision decision) {
        return decision == Decision.REJECTED
                ? "Amount exceeds allowed limit (1000)"
                : "OK";
    }
}
