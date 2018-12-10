package shedule.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventcalendar")
public class EventCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;

    private Date date;

    public EventCalendar(TypeEvent typeEvent, MyUser doctor, MyUser pation) {
        this.typeEvent = typeEvent;

        this.doctor = doctor;
        this.pation = pation;
    }

    @ElementCollection(targetClass = MyUser.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "my_user", joinColumns = @JoinColumn(name = "user_id"))
    @OneToOne
    private MyUser doctor;

    @ElementCollection(targetClass = MyUser.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "my_user", joinColumns = @JoinColumn(name = "user_id"))
    @OneToOne
    private MyUser pation;

    public EventCalendar() {}

    public EventCalendar(TypeEvent typeEvent, Date date) {
        this.typeEvent = typeEvent;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MyUser getDoctor() {
        return doctor;
    }

    public MyUser getPation() {
        return pation;
    }

    public void setDoctor(MyUser doctor) {
        this.doctor = doctor;
    }

    public void setPation(MyUser pation) {
        this.pation = pation;
    }
}
