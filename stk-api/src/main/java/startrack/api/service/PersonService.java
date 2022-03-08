package startrack.api.service;

import startrack.api.entity.PersonEntity;
import startrack.model.Person;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Dependent
public class PersonService extends Service {


    public List<Person> listAll() {
        return em.createQuery("select p from Person p", PersonEntity.class)
                .getResultList()
                .stream()
                .map(PersonEntity::toPerson)
                .toList();
    }

    public Person findByUUID(String uuid) {
        return findByUUID(PersonEntity.class, uuid)
                .map(PersonEntity::toPerson)
                .get();
    }



}
