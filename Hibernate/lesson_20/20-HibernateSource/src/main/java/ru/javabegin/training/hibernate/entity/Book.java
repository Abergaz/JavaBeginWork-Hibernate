package ru.javabegin.training.hibernate.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@EqualsAndHashCode(of="id")
@ToString(of = "name", includeFieldNames = false)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    @ManyToOne // много книг может принадлежать одному автору
    @JoinColumn
    private Author author;

    private String name;

}
