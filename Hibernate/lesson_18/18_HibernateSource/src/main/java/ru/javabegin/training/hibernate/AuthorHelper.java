package ru.javabegin.training.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.javabegin.training.hibernate.entity.Author;
import ru.javabegin.training.hibernate.entity.Author_;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class AuthorHelper {



    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(){

        // открыть сессию - для манипуляции с персист. объектами
        Session session = sessionFactory.openSession();

        // этап подготовки запроса

        // объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaQuery cq = cb.createQuery(Author.class);

        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        Selection[] selection = {root.get(Author_.id), root.get(Author_.name)}; // выборка полей, в классе Author должен быть конструктор с этими параметрами

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        cq.select(cb.construct(Author.class, selection));
              //  .where(cb.like(root.get(Author_.name), nameParam));



        // этап выполнения запроса
        Query query = session.createQuery(cq);
//        query.setParameter("name", "%имя%");


        List<Author> authorList = query.getResultList();

        session.close();

        return authorList;

    }



    // добавляют нового автора в таблица Author
    public Author addAuthor(Author author){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for (int i=1; i<=200; i++){
            Author a = new Author("name"+i);
            a.setSecondName("sec_name"+i);
            if (i % 20==0){
                session.flush();
            }
            session.save(a); // сгенерит ID и вставит в объект
        }

        session.getTransaction().commit();

        session.close();

        return author;

    }

    public void delete(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaDelete<Author> criteriaDelete = cb.createCriteriaDelete(Author.class);

        Root<Author> root = criteriaDelete.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");
        ParameterExpression<String> secondNameParam = cb.parameter(String.class, "secondName");

        // нет select, сразу where
        criteriaDelete.where(cb.or(
                cb.and(
                        cb.like(root.get(Author_.name), nameParam),
                        cb.like(root.get(Author_.secondName), secondNameParam)
                ),
                cb.equal(root.get(Author_.name), "sec_name83")
                )
        );

        // этап выполнения запроса
        Query query = session.createQuery(criteriaDelete);
        query.setParameter("name", "%2%");
        query.setParameter("secondName", "%t%");

        query.executeUpdate();


//        session.getTransaction().commit();

        session.close();
    }

    public void update(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated

        CriteriaUpdate<Author> criteriaUpdate = cb.createCriteriaUpdate(Author.class);

        Root<Author> root = criteriaUpdate.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)

        ParameterExpression<String> nameParam = cb.parameter(String.class, "name");

        Expression<Integer> length = cb.length(root.get(Author_.secondName));

        criteriaUpdate.set(root.get(Author_.name), nameParam).
                where(cb.equal(length, 9)
        );



        // этап выполнения запроса
        Query query = session.createQuery(criteriaUpdate);
        query.setParameter("name", "1111");

        query.executeUpdate();// вместо возврата результата - используется метод обновления


        session.getTransaction().commit();

        session.close();
    }

    public Author getAuthor(long id){
        Session session = sessionFactory.openSession();

        Author author = session.get(Author.class, id);

        author.getBooks().get(0).getName();

        return author;
    }


    
}
