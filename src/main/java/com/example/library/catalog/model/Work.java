package com.example.library.catalog.model;

import jakarta.persistence.*;

@Entity
public class Work {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private WorkType workType;
    private String details;
    private String authors;
    private String subjects;



}
