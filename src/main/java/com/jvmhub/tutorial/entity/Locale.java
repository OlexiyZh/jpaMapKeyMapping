package com.jvmhub.tutorial.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Алексей on 26.07.2017.
 */
@Data
@Entity
@Table(name = "LOCALE")
public class Locale {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String ID;
}
