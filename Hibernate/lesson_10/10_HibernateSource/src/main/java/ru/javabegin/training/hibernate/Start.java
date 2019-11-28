package ru.javabegin.training.hibernate;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import ru.javabegin.training.hibernate.entity.Author;

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        for (Author author:new AuthorHelper().getAuthorList()
             ) {
            LOG.debug(author.getName());

        }

        HibernateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"


    }

}
