package com.viniciusfinger.perfect.model;

import com.viniciusfinger.perfect.enums.Priority;
import com.viniciusfinger.perfect.enums.Status;
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
public class Task extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer points;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

}
