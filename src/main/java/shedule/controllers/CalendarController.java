package shedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


/*

    @GetMapping()
    public String eventSave() {
        System.out.println(" OK111");
        return "calendar";
    }
*/
    @ResponseBody
    @PostMapping(value="/add", consumes = "application/json")
    public void testCel(@RequestBody Event eventCalendar) {
        System.out.println("in json");
        EventCalendar event = new EventCalendar();
        event.setDate(eventCalendar.getData());
        event.setTypeEvent(eventCalendar.getTypeEvent());

        MyUser pation = userRepo.findByUsername(eventCalendar.getDoctor());
        MyUser doctor = userRepo.findByUsername(eventCalendar.getPatient());
        System.out.println(doctor.getUsername());

        event.setPation(pation);
        event.setDoctor(doctor);

        eventRepo.save(event);
    }


    @RequestMapping(value = "/calendarTypes", method = RequestMethod.GET)
    @ResponseBody
    public String getTypes() {
        return TypeEvent.getEnum();
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("userList", userRepo.findAll());
        return "calendar";
    }

}
