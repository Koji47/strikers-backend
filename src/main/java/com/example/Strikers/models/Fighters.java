package com.example.Strikers.models;

import com.example.Strikers.responses.OptionContract;
import javax.persistence.*;

@Entity
@Table(name = "fighters")
public class Fighters implements OptionContract{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String first_name;
    private String last_name;
    private int age;
    private String gym;
    private String discipline;
    private String location;
    private String profile_picture;

    @Column(name="strike1_id")
    private long strike1Id;
    @Column(name="strike2_id")
    private long strike2Id;
    @Column(name="strike3_id")
    private long strike3Id;

    @Column(name="strike4_id")
    private long strike4Id;
    public long getStrike1Id() {
        return strike1Id;
    }

    public void setStrike1Id(long strike1Id) {
        this.strike1Id = strike1Id;
    }

    public long getStrike2Id() {
        return strike2Id;
    }

    public void setStrike2Id(long strike2Id) {
        this.strike2Id = strike2Id;
    }

    public long getStrike3Id() {
        return strike3Id;
    }

    public void setStrike3Id(long strike3Id) {
        this.strike3Id = strike3Id;
    }

    public long getStrike4Id() {
        return strike4Id;
    }

    public void setStrike4Id(long strike4Id) {
        this.strike4Id = strike4Id;
    }

    public long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "strike1_id", insertable = false, updatable = false)
    private Strikes strike1;

    @ManyToOne
    @JoinColumn(name = "strike2_id", insertable = false, updatable = false)
    private Strikes strike2;

    @ManyToOne
    @JoinColumn(name = "strike3_id", insertable = false, updatable = false)
    private Strikes strike3;

    @ManyToOne
    @JoinColumn(name = "strike4_id", insertable = false, updatable = false)
    private Strikes strike4;

    public Strikes getStrike1() {
        return strike1;
    }

    public void setStrike1(Strikes strike1) {
        this.strike1 = strike1;
    }

    public Strikes getStrike2() {
        return strike2;
    }

    public void setStrike2(Strikes strike2) {
        this.strike2 = strike2;
    }

    public Strikes getStrike3() {
        return strike3;
    }

    public void setStrike3(Strikes strike3) {
        this.strike3 = strike3;
    }

    public Strikes getStrike4() {
        return strike4;
    }

    public void setStrike4(Strikes strike4) {
        this.strike4 = strike4;
    }



    @Override
    public String getName() {
        return first_name + " " + last_name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGym() {
        return gym;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public String toString() {
        return "Fighters{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", gym='" + gym + '\'' +
                ", discipline='" + discipline + '\'' +
                ", location='" + location + '\'' +
                ", strike1Id=" + strike1Id +
                ", strike2Id=" + strike2Id +
                ", strike3Id=" + strike3Id +
                ", strike4Id=" + strike4Id +
                '}';
    }
}
