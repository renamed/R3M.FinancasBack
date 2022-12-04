package dev.renamed.financasback.finantialMovement;

import dev.renamed.financasback.category.Category;
import dev.renamed.financasback.category.Restriction;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/movement")
public class FinantialMovementController {
    @Autowired
    private FinantialMovementRepository finantialMovementRepository;

    @GetMapping
    Iterable<FinantialMovement> all() {
        return finantialMovementRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<FinantialMovement> findMovement(@PathParam("id")UUID id) {
        Optional<FinantialMovement> movement = finantialMovementRepository.findById(id);

        return movement.isPresent()
                ? ResponseEntity.ok(movement.get())
                : ResponseEntity.notFound().build();
    }
//
//    @PostMapping("/")
//    public ResponseEntity<FinantialMovement> saveMovement(@RequestBody FinantialMovement finantialMovement) {
//        return ResponseEntity.ok(finantialMovementRepository.save(finantialMovement));
//    }
//
//    @PatchMapping
//    @RequestMapping("/{id}")
//    public ResponseEntity<FinantialMovementDto> updateMovement(@PathVariable("id") UUID id, @Validated @RequestBody FinantialMovement finantialMovement) {
//        Optional<FinantialMovement> dbMov = finantialMovementRepository
//                .findById(id);
//
//        if (!dbMov.isPresent())
//            return ResponseEntity.notFound().build();
//
//        if (finantialMovement.getCategory().getRestriction() == Restriction.CREDIT && finantialMovement.getInvoiceValue() < 0) {
//            FinantialMovementBadRequestDtoBuilder builder = new FinantialMovementBadRequestDtoBuilder();
//            return ResponseEntity.badRequest().body(builder.withError("CREDIT values may not have negative invoices").build());
//        }
//
//        if (finantialMovement.getCategory().getRestriction() == Restriction.DEBT && finantialMovement.getInvoiceValue() > 0) {
//            FinantialMovementBadRequestDtoBuilder builder = new FinantialMovementBadRequestDtoBuilder();
//            return ResponseEntity.badRequest().body(builder.withError("DEBT values may not have positive invoices").build());
//        }
//
//        FinantialMovement existingMov = dbMov.get();
//        existingMov.setDescription(finantialMovement.getDescription());
//        existingMov.setAvailableValue(finantialMovement.getAvailableValue());
//        existingMov.setExpectedDate(finantialMovement.getExpectedDate());
//        existingMov.setInvoiceDate(finantialMovement.getInvoiceDate());
//        existingMov.setInvoiceValue(finantialMovement.getInvoiceValue());
//        finantialMovementRepository.save(existingMov);
//
//        FinantialMovementBadRequestDtoBuilder builder = new FinantialMovementBadRequestDtoBuilder();
//        builder.withFinantialMovement(existingMov);
//
//        return ResponseEntity.ok(builder.build());
//    }

}
