package shedule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import shedule.domain.TypeEvent;

import java.util.Date;

public class Event {

    private String doctor;
    private String patient;

    private TypeEvent typeEvent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }
}
