package ru.javabegin.training.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of="id")
@ToString(of = "name", includeFieldNames = false)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    @Column(name = "second_name")
    private String secondName;


    @OneToMany(targetEntity = Book.class, mappedBy="author")// может быть автором нескольких книг (Book)
    private List<Book> books = new ArrayList<>();

    private String name;

}
