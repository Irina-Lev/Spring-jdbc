package com.product.star.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ContactConfiguration.class);
        var contactDao = applicationContext.getBean(ContactDao.class);
        var contacts = contactDao.getAllContacts();
        System.out.println(contacts);

        var contact = contactDao.getContact(1000l);
        System.out.println(contact);
        var newContact = new Contact("Pit", "Bred", "bred@mail.ru", "1234567");
        contactDao.addContact(newContact);

        contactDao.updateEmail(2000, "fine@mail.ry");
        contactDao.updatePhoneNumber(2000, "5555555");

        contactDao.deleteContact(1000);

        contacts = contactDao.getAllContacts();
        System.out.println(contacts);
    }
}
