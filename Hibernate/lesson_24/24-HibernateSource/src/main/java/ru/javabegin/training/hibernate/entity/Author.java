package ru.javabegin.training.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of = "id")
@ToString(of = "name", includeFieldNames = false)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "ru.javabegin.training.hibernate.entity.Author")

@NamedEntityGraphs({

        @NamedEntityGraph(name = "author.books", attributeNodes = {
                @NamedAttributeNode(value = "books")
        }),


        @NamedEntityGraph(name = "author.books.readers", attributeNodes = {
                @NamedAttributeNode(value = "books", subgraph = "book.readers")
        }, subgraphs = {
                @NamedSubgraph(name = "book.readers", attributeNodes = {
                        @NamedAttributeNode(value = "readers")
                })
        })
})

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
// может быть автором нескольких книг (Book)
    private Set<Book> books = new TreeSet<>();

    private String name;

}
