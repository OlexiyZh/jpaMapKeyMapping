package com.jvmhub.tutorial.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by Алексей on 26.07.2017.
 */

@Getter
@Setter
@Entity
@Table(name = "MARKETING_PROGRAM")
public class MarketingProgram {
    @Id
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapKeyJoinColumn(name = "LOCALE_ID")
    @ElementCollection
    @CollectionTable(name = "MARKETING_PROGRAM_LOCALIZED", joinColumns = @JoinColumn(name = "MARKETING_PROGRAM_ID"))
    private Map<Locale, String> name;

    @Column(name="RECEIPT_SUBMISSION_DAYS")
    private Integer receiptSubmissionDays;

}
