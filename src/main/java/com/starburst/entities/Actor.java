package com.starburst.entities;

import com.starburst.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "actors")
@Data
public class Actor {
    private int id;
    private int version;
    private String name;
    private Date birthday;
    private Gender gender;
//    private Movie movie;
    private Date createdAt;
    private Date updatedAt;

    public Actor() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Version
    public int getVersion() { return version; }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M', 'F')")
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

//    // unidirectional relationship betwee movies and studios - CASCADE DETACH, not CASCADE PERSIST, NOT CASCADE ALL.
//    // Detatch state means dont save the entire object just the ID of the related object
//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "MOVIE_ID")
//    public Movie getMovie() { return movie; }
//    public void setMovie(Studio studio) { this.movie = movie; }

    @Column(name="created_at", nullable=false, updatable = false)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Column(name="updated_at", nullable = false)
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
