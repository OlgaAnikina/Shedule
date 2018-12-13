package shedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shedule.domain.EventCalendar;
import shedule.domain.MyUser;
import shedule.domain.TypeEvent;
import shedule.model.Event;
import shedule.repository.EventRepo;
import shedule.repository.UserRepository;

@Controller
@RequestMapping(value="calendar", produces = "application/json")
public class CalendarController {
    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepository userRepo;

    @ResponseBody
    @PostMapping(value="/add", consumes = "application/json")
    public void testCel(@RequestBody Event eventCalendar) {
        System.out.println("in json");
        EventCalendar event = new EventCalendar();
        event.setDate(eventCalendar.getData());
        event.setTypeEvent(eventCalendar.getTypeEvent());

        MyUser doctor= userRepo.findByUsername(eventCalendar.getDoctor());
        MyUser pation = userRepo.findByUsername(eventCalendar.getPatient());

        event.setPation(pation);
        event.setDoctor(doctor);

        eventRepo.save(event);
    }

/*
    @RequestMapping(value = "/calendar", method = RequestMethod.GET)
    @ResponseBody
    public String getT() {
        return TypeEvent.getEnum();
    }*/

    @GetMapping(value = "/event", produces = "application/json")
    public String eventList(Model model) {
        model.addAttribute("eventList", eventRepo.findAll());
        return "calendar";
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("userList", userRepo.findAll());
        return "calendar";
    }



}
