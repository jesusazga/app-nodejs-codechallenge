package pe.indigital.yape.transactionservice.adapters.in.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.indigital.yape.transactionservice.adapters.in.web.dto.CreateTransactionRequest;
import pe.indigital.yape.transactionservice.adapters.in.web.dto.TransactionResponse;
import pe.indigital.yape.transactionservice.adapters.in.web.mapper.WebMappers;
import pe.indigital.yape.transactionservice.domain.ports.in.CreateTransactionUseCase;
import pe.indigital.yape.transactionservice.domain.ports.in.GetTransactionUseCase;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final CreateTransactionUseCase createUC;
    private final GetTransactionUseCase getUC;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTransactionRequest request) {
        UUID externalId = createUC.create(WebMappers.toCommand.apply(request));
        return ResponseEntity.created(URI.create("/transactions/" + externalId)).build();
    }

    @GetMapping("/{transactionExternalId}")
    public TransactionResponse get(@PathVariable UUID transactionExternalId) {
        var result = getUC.get(transactionExternalId);
        return new TransactionResponse(
                result.transactionExternalId(),
                result.transferTypeId(),
                result.status(),
                result.value(),
                result.createdAt()
        );
    }
}
