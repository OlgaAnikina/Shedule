package shedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shedule.domain.EventCalendar;
import shedule.domain.MyUser;
import shedule.domain.Role;
import shedule.domain.TypeEvent;
import shedule.model.Event;
import shedule.repository.EventRepo;
import shedule.repository.UserRepository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="calendar", produces = "application/json")
public class CalendarController {
    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepository userRepo;


    @GetMapping()
    public String eventSave() {
        System.out.println(" OK111");
        return "calendar";
    }

    @ResponseBody
    @PostMapping(value="/add", consumes = "application/json")
    public void testCel(@RequestBody Event eventCalendar) {
        EventCalendar event = new EventCalendar();
        event.setDate(eventCalendar.getDate());
        event.setTypeEvent(eventCalendar.getTypeEvent());

        MyUser pation = userRepo.findByUsername(eventCalendar.getFirstUserName());
        MyUser doctor = userRepo.findByUsername(eventCalendar.getSecondUserName());

        event.setPation(pation);
        event.setDoctor(doctor);

        eventRepo.save(event);
    }


    @RequestMapping(value = "/calendarTypes", method = RequestMethod.GET)
    @ResponseBody
    public String getTypes() {


        return TypeEvent.getEnum();
    }

}
