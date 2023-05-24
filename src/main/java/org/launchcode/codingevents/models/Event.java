package org.launchcode.codingevents.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.Objects;
/**
 * Created by Chris Bay
 */

@Entity
public class Event extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;
////    private static int nextId = 1;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    @NotBlank(message="Description Required")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location required.")
    @NotNull(message = "Location cannot be blank.")
    private String location;

    private boolean mustRegister = true;

    @Positive(message = "Number of attendees must be greater than zero.")
    private int numberOfAttendees;

    private EventCategory eventCategory;
    public Event(String name, String description, String contactEmail, String location, int numberOfAttendees, EventCategory eventCategory, boolean mustRegister) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister= mustRegister;
        this.numberOfAttendees = numberOfAttendees;
        this.eventCategory = eventCategory;

    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

//    public int getId() {
//        return id;
//    }

    public String getLocation() {
        return location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    @ManyToOne
    @NotNull(message="Category is required")
    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Event event = (Event) o;
//        return id == event.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
