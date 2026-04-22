package com.library.LibraryMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 50,nullable = false)
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "publishers",cascade = CascadeType.ALL)
    private Set<Book> books=new HashSet<>();


}
