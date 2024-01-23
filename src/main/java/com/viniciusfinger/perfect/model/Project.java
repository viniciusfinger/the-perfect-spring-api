package com.viniciusfinger.perfect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Audited @AuditOverride(forClass = Auditable.class)
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Person coordinator;

    private String description;

}
