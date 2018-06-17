package kg.timur.ebean.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Builder
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person extends BaseModel {

    @Id
    @GeneratedValue
    private Long personId;

    private String name;

    private Date birthDate;

}
