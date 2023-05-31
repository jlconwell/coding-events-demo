package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

@Entity
public class EventDetails extends AbstractEntity{

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

    public EventDetails(String description, String contactEmail, String location, boolean mustRegister, int numberOfAttendees) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister = mustRegister;
        this.numberOfAttendees = numberOfAttendees;
    }

    public EventDetails () {}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }
}
