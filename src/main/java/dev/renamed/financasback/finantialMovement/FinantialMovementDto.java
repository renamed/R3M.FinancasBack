package dev.renamed.financasback.finantialMovement;

public class FinantialMovementDto {
    private String error;

    public FinantialMovement getFinantialMovement() {
        return finantialMovement;
    }

    public void setFinantialMovement(FinantialMovement finantialMovement) {
        this.finantialMovement = finantialMovement;
    }

    private FinantialMovement finantialMovement;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
