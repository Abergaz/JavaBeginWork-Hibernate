package ru.javabegin.training.fastjava2.javafx.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.javabegin.training.fastjava2.javafx.interfaces.AddressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.util.List;

public class HibernateAddressBook implements AddressBook{

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;


    public HibernateAddressBook() {
        sessionFactory = getSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean update(Person person) {
        return false;
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }

    @Override
    public ObservableList<Person> findAll() {
        Session session = sessionFactory.openSession();
        List<ru.javabegin.training.fastjava2.javafx.hibernate.Person> list = session.createCriteria(ru.javabegin.training.fastjava2.javafx.hibernate.Person.class).list();
        session.close();
        return null;
    }

    @Override
    public ObservableList<Person> find(String text) {
        return null;
    }


    public ObservableList<Person> getPersonList() {
        return personList;
    }
}
