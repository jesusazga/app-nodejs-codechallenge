package pe.indigital.yape.transactionservice.adapters.out.persistence.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.indigital.yape.transactionservice.adapters.out.persistence.jpa.mapper.JpaMappers;
import pe.indigital.yape.transactionservice.domain.model.Transaction;
import pe.indigital.yape.transactionservice.domain.ports.out.TransactionRepositoryPort;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TransactionJpaAdapter implements TransactionRepositoryPort {

    private final SpringDataTransactionRepository repository;

    @Override
    public Transaction save(Transaction tx) {
        var saved = repository.save(JpaMappers.toEntity.apply(tx));
        return JpaMappers.toDomain.apply(saved);
    }

    @Override
    public Optional<Transaction> findByExternalId(UUID externalId) {
        return repository.findByTransactionExternalId(externalId)
                .map(JpaMappers.toDomain);
    }
}
