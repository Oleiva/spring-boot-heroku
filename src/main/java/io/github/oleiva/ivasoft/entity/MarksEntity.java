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
    private long SUBJECTID;

    @NotNull
    private long MARKS;

    @NotNull
    private long GROUP_ID;

    public MarksEntity(){

    }


    public MarksEntity(long STUD_ID, long SUBJECTID, long MARKS, long GROUP_ID) {
        this.STUD_ID = STUD_ID;
        this.SUBJECTID = SUBJECTID;
        this.MARKS = MARKS;
        this.GROUP_ID = GROUP_ID;
    }

    public long getSTUD_ID() {
        return STUD_ID;
    }

    public void setSTUD_ID(long STUD_ID) {
        this.STUD_ID = STUD_ID;
    }

    public long getSUBJECTID() {
        return SUBJECTID;
    }

    public void setSUBJECTID(long SUBJECTID) {
        this.SUBJECTID = SUBJECTID;
    }

//    public String getMARKS() {
//        return MARKS;
//    }
//
//    public void setMARKS(String MARKS) {
//        this.MARKS = MARKS;
//    }
}
