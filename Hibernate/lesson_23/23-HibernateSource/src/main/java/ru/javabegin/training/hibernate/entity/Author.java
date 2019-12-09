package ru.javabegin.training.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import static ru.javabegin.training.hibernate.entity.Author_.secondName;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of="id")
@ToString(of = "name", includeFieldNames = false)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ru.javabegin.training.hibernate.entity.Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    @Column(name = "second_name")
    private String secondName;


    @OneToMany(targetEntity = Book.class, mappedBy="author", fetch = FetchType.EAGER)// может быть автором нескольких книг (Book)
    private List<Book> books = new ArrayList<>();

    private String name;

}
