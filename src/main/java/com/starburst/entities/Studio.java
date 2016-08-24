package com.starburst.entities;

import lombok.Data; // See the Structure panel on the left side of idea.  click on the P icon at the top of the panel.
// the @Data is needed (see line 12)

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studios")
@Data
public class Studio {
    private int id;
    private int version;
    private String name;
    private Date est;
    private Date createdAt;
    private Date updatedAt;


    public Studio() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Studio(int id) {
        this(); // call constructor
        this.id = id;
    }

    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Version
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    @Column( nullable = false)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Temporal(TemporalType.DATE)
    public Date getEst() { return est; }
    public void setEst(Date est) { this.est = est; }

    // @Temporal annotation is not needed if it is both date and time
    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Column(name = "updated_at", nullable = false)
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    @PreUpdate // This is for JPA, jpa also takes care of the versioning
    protected void onUpdate() { this.updatedAt = new Date(); }
}
