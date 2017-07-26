package com.jvmhub.tutorial.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Алексей on 26.07.2017.
 */
@Data
@ToString
@Entity
@Table(name = "MARKETING_PROGRAM")
public class MarketingProgram {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*@MapKeyColumn(name = "LOCALE_ID")
    @ElementCollection
    @CollectionTable(name = "MARKETING_PROGRAM_LOCALIZED", joinColumns = @JoinColumn(name = "MARKETING_PROGRAM_ID"))
    private Map<String, String> name;*/

    @MapKeyJoinColumn(name = "LOCALE_ID")
    @ElementCollection
    @CollectionTable(name = "MARKETING_PROGRAM_LOCALIZED", joinColumns = @JoinColumn(name = "MARKETING_PROGRAM_ID"))
    private Map<Locale, String> name;

}
