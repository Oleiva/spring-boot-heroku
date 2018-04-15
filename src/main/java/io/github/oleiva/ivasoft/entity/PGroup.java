package io.github.oleiva.ivasoft.entity;


import javax.persistence.*;

@Entity
@Table(name = "PGroup")
public class PGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String groupName;


    public PGroup(){

    }

    public PGroup(String groupName) {
        this.groupName = groupName;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
