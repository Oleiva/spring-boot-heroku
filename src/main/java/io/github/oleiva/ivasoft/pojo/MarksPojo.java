package io.github.oleiva.ivasoft.pojo;

public class MarksPojo {
    private String fio;
    private String subject;
    private double mark;
    private String grup;
    private String grup_index;


//    public MarksPojo(){
//
//    }


    public MarksPojo(String fio, String subject, double mark, String grup, String grup_index) {
        this.fio = fio;
        this.subject = subject;
        this.mark = mark;
        this.grup = grup;
        this.grup_index = grup_index;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public String getGrup_index() {
        return grup_index;
    }

    public void setGrup_index(String grup_index) {
        this.grup_index = grup_index;
    }

    @Override
    public String toString() {
        return "MarksPojo{" +
                "fio='" + fio + '\'' +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                ", grup='" + grup + '\'' +
                ", grup_index='" + grup_index + '\'' +
                '}';
    }
}
