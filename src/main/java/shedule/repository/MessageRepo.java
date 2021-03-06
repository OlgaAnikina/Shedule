package shedule.repository;

import org.springframework.data.repository.CrudRepository;
import shedule.domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
