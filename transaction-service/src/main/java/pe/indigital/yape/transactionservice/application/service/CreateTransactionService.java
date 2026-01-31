package pe.indigital.yape.transactionservice.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.indigital.yape.transactionservice.application.dto.CreateTransactionCommand;
import pe.indigital.yape.transactionservice.domain.model.Transaction;
import pe.indigital.yape.transactionservice.domain.ports.in.CreateTransactionUseCase;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionEventPublisherPort;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionRepositoryPort;
import pe.indigital.yape.transactionservice.domain.service.TransactionDomainService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateTransactionService implements CreateTransactionUseCase {

    private final TransactionRepositoryPort repository;
    private final TransactionEventPublisherPort publisher;
    private final TransactionDomainService domainService = new TransactionDomainService();

    @Override
    @Transactional
    public UUID create(CreateTransactionCommand command) {

        var draft = new Transaction(
                null, null,
                command.accountExternalIdDebit(),
                command.accountExternalIdCredit(),
                command.transferTypeId(),
                command.value(),
                null, null
        );

        var tx = domainService.createNew(draft);
        var saved = repository.save(tx);
        log.info("Created new transaction: {}", saved);
        publisher.publishTransactionCreated(saved);
        return saved.transactionExternalId();

    }
}
