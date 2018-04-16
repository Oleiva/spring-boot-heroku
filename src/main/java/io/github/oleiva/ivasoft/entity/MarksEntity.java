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

    private long studid;

    @NotNull
    private long SUBJECTID;

    @NotNull
    private long MARKS;

//    @NotNull
    private long groupid;

    @NotNull
    private String GROUP_INDEX;


    public MarksEntity(){

    }


    public MarksEntity(long studid, long SUBJECTID, long MARKS, long groupid, String GROUP_INDEX) {
        this.studid = studid;
        this.SUBJECTID = SUBJECTID;
        this.MARKS = MARKS;
        this.groupid = groupid;
        this.GROUP_INDEX = GROUP_INDEX;
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


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getMARKS() {
        return MARKS;
    }

    public void setMARKS(long MARKS) {
        this.MARKS = MARKS;
    }

    public long getGroupid() {
        return groupid;
    }

    public void setGroupid(long groupid) {
        this.groupid = groupid;
    }

    public String getGROUP_INDEX() {
        return GROUP_INDEX;
    }

    public void setGROUP_INDEX(String GROUP_INDEX) {
        this.GROUP_INDEX = GROUP_INDEX;
    }

    public long getStudid() {
        return studid;
    }

    public void setStudid(long studid) {
        this.studid = studid;
    }

    @Override
    public String toString() {
        return "MarksEntity{" +
                "ID=" + ID +
                ", studid=" + studid +
                ", SUBJECTID=" + SUBJECTID +
                ", MARKS=" + MARKS +
                ", groupid=" + groupid +
                ", GROUP_INDEX='" + GROUP_INDEX + '\'' +
                '}';
    }
}
