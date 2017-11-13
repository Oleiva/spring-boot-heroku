package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;
// https://dba.stackexchange.com/questions/116580/student-who-got-max-marks-in-subject

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long STUD_ID;

//    @NotNull
    @Column(name = "studname")
    private String studname;

    public StudentEntity(String studname) {
        this.studname = studname;
    }

    public StudentEntity() {

    }

    public long getSTUD_ID() {
        return STUD_ID;
    }

    public void setSTUD_ID(long STUD_ID) {
        this.STUD_ID = STUD_ID;
    }

}
