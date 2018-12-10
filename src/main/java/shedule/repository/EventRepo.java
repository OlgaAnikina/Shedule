package shedule.repository;

import org.springframework.data.repository.CrudRepository;
import shedule.domain.EventCalendar;

public interface EventRepo extends CrudRepository<EventCalendar, Long> {
}
