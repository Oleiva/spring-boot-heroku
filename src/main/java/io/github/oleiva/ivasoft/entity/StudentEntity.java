package io.github.oleiva.ivasoft.entity;//package io.github.Oleiva.entity;
// https://dba.stackexchange.com/questions/116580/student-who-got-max-marks-in-subject

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studid;

//    @NotNull
//    @Column(name = "studname")
//    private String studname;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;


    @Column(name = "fiohash",unique=true)
    private String fiohash;

    public StudentEntity(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.fiohash = makeFioHash(name, surname, patronymic);
    }

    public StudentEntity() {

    }


    public long getStudid() {
        return studid;
    }

    public void setStudid(long studid) {
        this.studid = studid;
    }

    public String getFiohash() {
        return fiohash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String makeFioHash(String name, String surname, String patronymic) {
        String text = surname+name.substring(0,1)+patronymic.substring(0,1);
        System.out.println("## "+text);
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(text);
        return sha256hex;
    }

    public void setFiohash(String fiohash) {
        this.fiohash = fiohash;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studid=" + studid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", fiohash='" + fiohash + '\'' +
                '}';
    }
}
