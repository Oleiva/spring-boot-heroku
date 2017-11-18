package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Ivasoft on 25.09.2017.
 */

@Entity
@Table(name = "Subjects")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    @Column(name = "SUBJECT")
    private String subject;


    public SubjectEntity() {

    }

    public SubjectEntity(String subject) {
        this.subject = subject;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}


