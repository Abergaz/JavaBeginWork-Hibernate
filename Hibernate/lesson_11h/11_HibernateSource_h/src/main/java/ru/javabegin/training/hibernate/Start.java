package ru.javabegin.training.hibernate;

import org.jboss.logging.Logger;
import ru.javabegin.training.hibernate.entity.Author;

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {

        // здесь не нужно открывать сессию - осталось от старого кода
        //Session session = HibernateUtil.getSessionFactory().openSession();

        Author author = new Author("тест3");
//
//
       new AuthorHelper().addAuthor(author);

       HibernateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"



    }

}
