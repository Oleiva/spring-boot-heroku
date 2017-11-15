package io.github.oleiva.ivasoft.pojo;

public class Student {
    private String name;
    private String subject;
    private double mark;
    private String grup;

//    public Student(){
//
//    }


    public Student(String name, String subject, double mark, String grup) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
        this.grup = grup;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                ", grup='" + grup + '\'' +
                '}';
    }


}
