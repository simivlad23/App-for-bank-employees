package service;

import model.Account;
import model.Person;
import repository.PersonRepository;

import java.util.List;

public interface PersonSercive {

    Person save(Person person);

    void delete(String id);

    List<Account> getAccountList(Person p);

    public PersonRepository getPersonRepository();



}
