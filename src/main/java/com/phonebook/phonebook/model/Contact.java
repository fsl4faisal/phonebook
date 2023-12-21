package com.phonebook.phonebook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Builder(buildMethodName = "build")
@AllArgsConstructor
public class Contact {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(UUID uuid, String firstName, String lastName, String phoneNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UUID getUuid() {
        return uuid;
    }
}
