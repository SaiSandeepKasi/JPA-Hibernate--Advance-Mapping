package com.AiThinkers.jpaMappings.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="youtubeChannel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    //using bidirectional
   // @OneToOne(mappedBy = "instructorDetails",cascade=CascadeType.ALL)
    //Here we are removing cascading from all to except remove we can use all
    //here the data deleted on instructor will effect or implememted on instructordetails class
    @OneToOne(mappedBy = "instructorDetails",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    //constructor

    public InstructorDetails(String youtubeChannel,String hobby){
        this.youtubeChannel=youtubeChannel;
        this.hobby=hobby;
    }
    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
