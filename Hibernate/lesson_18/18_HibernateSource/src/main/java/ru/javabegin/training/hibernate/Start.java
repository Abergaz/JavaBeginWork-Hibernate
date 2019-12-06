package ru.javabegin.training.hibernate;

import org.jboss.logging.Logger;

public class Start {

    private static final Logger LOG = Logger.getLogger( AuthorHelper.class.getName() );


    public static void main(String[] args) {

        // подставляйте тот id, который есть у вас в таблице author
        // по id этого автора обязательно должны быть связанные книги в таблице book (внешний ключ по полю author_id)
        new AuthorHelper().getAuthor(1L);


        HibernateUtil.getSessionFactory().close(); // закрываем фабрику, иначе программа останется в "зависнутом состоянии"

    }

}
