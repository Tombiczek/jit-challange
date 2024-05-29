package internship.java.java_internship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Visit {

    private @Id
    @GeneratedValue Long id;
    private LocalDateTime dateVisit;
    private String owner;
    private String catName;
    private int catAge;
    private String catColor;


    public Visit() {}

    public Visit(LocalDateTime dateVisit, String owner, String catName, int catAge, String catColor) {
        this.dateVisit = dateVisit;
        this.owner = owner;
        this.catName = catName;
        this.catAge = catAge;
        this.catColor = catColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(LocalDateTime dateVisit) {
        this.dateVisit = dateVisit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }
}
