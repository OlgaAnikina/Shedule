package shedule.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum TypeEvent {
    @JsonProperty("consultation")
    CONSULTATION("CONSULTATION"),
    @JsonProperty("inspection")
    INSPECTION("INSPECTION"),
    @JsonProperty("operation")
    OPERATION("OPERATION"),
    @JsonProperty("procedure")
    PROCEDURE("PROCEDURE");

    private static String CONSULTATIONS_EMUM = "CONSULTATION, INSPECTION, OPERATION, PROCEDURE";

    private String name;

    TypeEvent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getEnum() {
        return TypeEvent.CONSULTATIONS_EMUM;
    }

    public void setName(String name) {
        this.name = name;
    }
}
