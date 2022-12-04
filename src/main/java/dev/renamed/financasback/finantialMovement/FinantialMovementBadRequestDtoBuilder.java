package dev.renamed.financasback.finantialMovement;

public class FinantialMovementBadRequestDtoBuilder {
    private FinantialMovementDto finantialMovementDto = new FinantialMovementDto();

    public FinantialMovementBadRequestDtoBuilder withError(String error){
        finantialMovementDto.setError(error);
        return this;
    }

    public FinantialMovementBadRequestDtoBuilder withFinantialMovement(FinantialMovement finantialMovement){
        finantialMovementDto.setFinantialMovement(finantialMovement);
        return this;
    }

    public FinantialMovementDto build(){
        return finantialMovementDto;
    }
}
