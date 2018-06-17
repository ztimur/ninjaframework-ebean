package kg.timur.ebean.service;

import com.google.inject.Inject;
import ebean.annotation.ReadEbeanServer;
import ebean.annotation.WriteEbeanServer;
import io.ebean.EbeanServer;
import io.ebean.annotation.Transactional;
import kg.timur.ebean.dto.PersonDto;
import kg.timur.ebean.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonService {

    Logger log = LoggerFactory.getLogger(PersonService.class);
    @Inject
    @ReadEbeanServer
    EbeanServer readEbeanServer;

    @Inject
    @WriteEbeanServer
    EbeanServer writeEbeanServer;

    public List<Person> list() {
        return readEbeanServer.find(Person.class).findList();
    }

    public void create(PersonDto dto) {
        writeEbeanServer.insert(Person.builder().name(dto.getName()).birthDate(dto.getBirthDate()).build());
    }

    @Transactional
    public void modify(Long id, PersonDto dto) {
        Person entity = readEbeanServer.find(Person.class).where().idEq(id).findOne();
        if (entity != null) {
            if (dto.getName() != null) {
                entity.setName(dto.getName());
            }

            if (dto.getBirthDate() != null) {
                entity.setBirthDate(dto.getBirthDate());
            }
            writeEbeanServer.save(entity);
        }
    }

    public PersonDto find(Long id) {
        return readEbeanServer.find(Person.class).where().idEq(id).asDto(PersonDto.class).findOne();
    }
}
