package ru.javabegin.training.hibernate.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SetAttribute<Book, Reader> readers;
	public static volatile SingularAttribute<Book, Author> author;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, Long> id;

	public static final String READERS = "readers";
	public static final String AUTHOR = "author";
	public static final String NAME = "name";
	public static final String ID = "id";

}

