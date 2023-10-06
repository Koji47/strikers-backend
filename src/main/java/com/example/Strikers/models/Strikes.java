package com.example.Strikers.models;

import com.example.Strikers.responses.OptionContract;
import javax.persistence.*;

@Entity
@Table(name = "strikes")
public class Strikes implements OptionContract{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String power;
    private String speed;
    private String strike_type;
    private String video_url_fighter;
    private String video_url_tutorial;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getStrike_type() {
        return strike_type;
    }

    public void setStrike_type(String strike_type) {
        this.strike_type = strike_type;
    }

    public String getVideo_url_fighter() {
        return video_url_fighter;
    }

    public void setVideo_url_fighter(String video_url_fighter) {
        this.video_url_fighter = video_url_fighter;
    }

    public String getVideo_url_tutorial() {
        return video_url_tutorial;
    }

    public void setVideo_url_tutorial(String video_url_tutorial) {
        this.video_url_tutorial = video_url_tutorial;
    }

    @Override
    public String toString() {
        return "Strikes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power='" + power + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
