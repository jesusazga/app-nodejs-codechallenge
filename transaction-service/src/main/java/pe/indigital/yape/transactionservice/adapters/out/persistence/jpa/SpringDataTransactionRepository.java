package pe.indigital.yape.transactionservice.adapters.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataTransactionRepository extends JpaRepository<TransactionEntity, UUID> {
    Optional<TransactionEntity> findByTransactionExternalId(UUID transactionExternalId);
}
