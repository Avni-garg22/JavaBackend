package com.practice_hibernate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.product.Person;
import com.product.PersonDoa;

public class PersonDoaTest {

    PersonDoa dao;

    @BeforeEach
    public void cleanDB() {
        dao = new PersonDoa();

        for (int i = 1; i <= 200; i++) {
            dao.deletePerson(i);
        }
    }


    @Test
    public void testInsertPerson() {
        Person p = new Person();
        p.setId(1);
        p.setName("Avni");
        p.setDob("22/11/2002");
        p.setAddress("Haryana");
        p.setPincode(136026);

        String res = dao.insertPerson(p);
        assertEquals("Data inserted", res);
    }

    @Test
    public void testInsertNullPerson() {
        String res = dao.insertPerson(null);
        assertEquals("Illegal Argument", res);
    }

    @Test
    public void testFindPerson() {
        Person p = new Person();
        p.setId(2);
        p.setName("Krish");
        p.setDob("10/10/2004");
        p.setAddress("Delhi");
        p.setPincode(110001);
        dao.insertPerson(p);

        Person found = dao.findPerson(2);
        assertNotNull(found);
    }

    @Test
    public void testFindPersonException() {
        assertThrows(IllegalArgumentException.class,
                     () -> dao.findPerson(999));
    }

    @Test
    public void testDeletePerson() {
        Person p = new Person();
        p.setId(3);
        p.setName("Test");
        dao.insertPerson(p);

        String res = dao.deletePerson(3);
        assertEquals("Data deleted", res);
    }

    @Test
    public void testDeletePersonNotFound() {
        String res = dao.deletePerson(999);
        assertEquals("Data not found", res);
    }

  
    @Test
    public void testUpdatePerson() {
        Person p = new Person();
        p.setId(4);
        p.setName("Old Name");
        dao.insertPerson(p);

        p.setName("New Name");
        String res = dao.updatePerson(p);

        assertEquals("Data updated", res);
    }

    @Test
    public void testUpdateNullPerson() {
        String res = dao.updatePerson(null);
        assertEquals("Data not found", res);
    }

    @Test
    public void testFindAllPersons() {
        Person p1 = new Person();
        p1.setId(10);
        p1.setName("A");
        dao.insertPerson(p1);

        Person p2 = new Person();
        p2.setId(11);
        p2.setName("B");
        dao.insertPerson(p2);

        List<Person> list = dao.findAllPersons();
        assertNotNull(list);
        assertTrue(list.size() >= 2);
    }
}