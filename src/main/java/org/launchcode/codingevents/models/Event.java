package org.launchcode.codingevents.models;


import javax.persistence.*;
import javax.validation.Valid;
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

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;



    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;
    public Event(String name, String description, String contactEmail, String location, int numberOfAttendees, EventCategory eventCategory, boolean mustRegister) {
        this.name = name;
        this.eventCategory = eventCategory;

    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
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
