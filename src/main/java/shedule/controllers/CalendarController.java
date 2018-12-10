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
import shedule.repository.EventRepo;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("calendar")
public class CalendarController {
    @Autowired
    private EventRepo eventRepo;

 /*   @PostMapping
    public void create(@RequestBody EventCalendar eventCalendar) {

        message.put("id", String.valueOf(counter++));

        messages.add(message);

        return message;
    }

*/



    @GetMapping()
    public String eventSave() {
        System.out.println(" OK111");
        return "calendar";
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public void testCel(@RequestBody EventCalendar eventCalendar) {
        String name = eventCalendar.getDoctor().getUsername();
        System.out.println(" OK");
        System.out.println( name);
    }


    @RequestMapping(value = "/calendarTypes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getTypes() {


        return TypeEvent.getEnum();
    }

}
