package com.jvmhub.tutorial.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Table(name = "MARKETING_PROGRAM_LOCALIZED")
@IdClass(MarketingProgramLocalized.CompositeId.class)
@EqualsAndHashCode(of = {"marketingProgram", "locale"})
public class MarketingProgramLocalized {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MARKETING_PROGRAM_ID")
    private MarketingProgram marketingProgram;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCALE_ID")
    private Locale locale;

    @Column(name = "NAME")
    private String name;

    @Getter
    @Setter
    @EqualsAndHashCode
    public static class CompositeId implements Serializable {
        private static final long serialVersionUID = 1L;
        private Long marketingProgram;
        private String locale;
    }


}
