package dev.renamed.financasback.finantialMovement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinantialMovementRepository extends CrudRepository<FinantialMovement, UUID> {

}
