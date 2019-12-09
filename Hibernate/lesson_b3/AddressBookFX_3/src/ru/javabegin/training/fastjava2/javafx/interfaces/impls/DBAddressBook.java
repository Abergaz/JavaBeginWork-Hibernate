package ru.javabegin.training.fastjava2.javafx.interfaces.impls;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.javabegin.training.fastjava2.javafx.db.SQLiteConnection;
import ru.javabegin.training.fastjava2.javafx.interfaces.AddressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public boolean add(Person person) {
        throw new UnsupportedOperationException("Not implemented, yet");
    }

    @Override
    public boolean delete(Person person) {
        throw new UnsupportedOperationException("Not implemented, yet");
    }

    @Override
    public ObservableList<Person> findAll() {

        try (Connection con = SQLiteConnection.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("select * from person");) {
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFio(rs.getString("fio"));
                person.setPhone(rs.getString("phone"));
                personList.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAddressBook.class.getName()).log(Level.SEVERE, null, ex);
        }

        return personList;
    }

    @Override
    public boolean update(Person person) {
        throw new UnsupportedOperationException("Not implemented, yet");
    }

    @Override
    public ObservableList<Person> find(String text) {
        throw new UnsupportedOperationException("Not implemented, yet");
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }
}
