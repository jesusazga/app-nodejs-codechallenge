package pe.indigital.yape.transactionservice.adapters.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;
import pe.indigital.yape.transactionservice.domain.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transactions", indexes = {
        @Index(name = "idx_tx_external_id", columnList = "transactionExternalId", unique = true),
        @Index(name = "idx_tx_status", columnList = "status")
})
public class TransactionEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private UUID transactionExternalId;

    @Column(nullable = false)
    private UUID accountExternalIdDebit;

    @Column(nullable = false)
    private UUID accountExternalIdCredit;

    @Column(nullable = false)
    private Integer transferTypeId;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(nullable = false)
    private Instant createdAt;
}
