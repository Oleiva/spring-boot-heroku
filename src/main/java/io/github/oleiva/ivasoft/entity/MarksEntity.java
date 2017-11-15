package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Ivasoft on 25.09.2017.
 */

@Entity
@Table(name = "MARKS")
public class MarksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    private long STUD_ID;

    @NotNull
    private String SUBJECT;

    @NotNull
    private int MARKS;


    public MarksEntity(){

    }

    public MarksEntity(long STUD_ID, String SUBJECT, int MARKS) {
        this.STUD_ID = STUD_ID;
        this.SUBJECT = SUBJECT;
        this.MARKS = MARKS;
    }

    public long getSTUD_ID() {
        return STUD_ID;
    }

    public void setSTUD_ID(long STUD_ID) {
        this.STUD_ID = STUD_ID;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

//    public String getMARKS() {
//        return MARKS;
//    }
//
//    public void setMARKS(String MARKS) {
//        this.MARKS = MARKS;
//    }
}