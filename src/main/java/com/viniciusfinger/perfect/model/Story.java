package com.viniciusfinger.perfect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Audited @AuditOverride(forClass = Auditable.class)
public class Story extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    //to-do: review this mapping
    @OneToMany
    private List<Task> tasks;

}
