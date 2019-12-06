package ru.javabegin.training.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of="id")
@ToString(of = "name", includeFieldNames = false)
public class Author implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    private String name;

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Book.class, mappedBy="author")// может быть автором нескольких книг (Book)
    private List<Book> books = new ArrayList<>();


    public Author(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Author(String name){
        this.name = name;
    }



}
