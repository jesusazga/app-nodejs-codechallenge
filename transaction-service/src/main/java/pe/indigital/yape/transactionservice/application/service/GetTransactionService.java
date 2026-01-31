package pe.indigital.yape.transactionservice.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.indigital.yape.transactionservice.application.dto.TransactionResult;
import pe.indigital.yape.transactionservice.application.mapper.TransactionMappers;
import pe.indigital.yape.transactionservice.domain.ports.in.GetTransactionUseCase;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionRepositoryPort;
import pe.indigital.yape.transactionservice.infrastructure.errors.NotFoundException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTransactionService implements GetTransactionUseCase {

    private final TransactionRepositoryPort repository;

    @Override
    public TransactionResult get(UUID transactionExternalId) {
        return repository.findByExternalId(transactionExternalId)
                .map(TransactionMappers.toResult)
                .orElseThrow(() -> new NotFoundException("Transaction not found: " + transactionExternalId));
    }
}
