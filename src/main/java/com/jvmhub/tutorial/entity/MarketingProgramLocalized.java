package com.jvmhub.tutorial.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Алексей on 26.07.2017.
 */
@Data
@Entity
@Table(name = "MARKETING_PROGRAM_LOCALIZED")
public class MarketingProgramLocalized {

    /*@Column(name = "MARKETING_PROGRAM_ID")
    private Integer marketingProgramId;*/

    @EmbeddedId
    private PrimeryKey key;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCALE_ID", referencedColumnName = "CODE", updatable = false, insertable = false)
    private Locale locale;

    @Column(name = "NAME")
    private String name;

    @Embeddable
    public static class PrimeryKey implements Serializable {
        @Column(name = "MARKETING_PROGRAM_ID")
        Integer marketingProgramId;
        @Column(name = "LOCALE_ID")
        String  localeId;
    }


}
