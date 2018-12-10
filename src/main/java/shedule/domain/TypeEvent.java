package shedule.domain;


public enum TypeEvent {
    CONSULTATION("CONSULTATION"), INSPECTION("INSPECTION"), OPERATION("OPERATION"), PROCEDURE("PROCEDURE");

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
