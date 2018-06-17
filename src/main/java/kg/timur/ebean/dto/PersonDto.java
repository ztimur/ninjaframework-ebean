package kg.timur.ebean.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonDto {
    String name;
    Date birthDate;
    Date created;
    Date updated;
}
