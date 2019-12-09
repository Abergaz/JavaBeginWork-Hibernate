package ru.javabegin.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reader.class)
public abstract class Reader_ {

	public static volatile SingularAttribute<Reader, Book> book;
	public static volatile SingularAttribute<Reader, String> name;
	public static volatile SingularAttribute<Reader, Long> id;

	public static final String BOOK = "book";
	public static final String NAME = "name";
	public static final String ID = "id";

}

