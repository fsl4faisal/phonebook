package com.phonebook.model;

import java.util.UUID;

//@Builder
//@Getter
public class Contact {
    private final UUID uuid;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

    public Contact(UUID uuid, String firstName, String lastName, String phoneNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


    public UUID getUuid() {
        return uuid;
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

    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    public static class ContactBuilder {
        private UUID uuid;
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public ContactBuilder from(Contact contact) {
            this.uuid = contact.uuid;
            this.firstName = contact.firstName;
            this.lastName = contact.lastName;
            this.phoneNumber = contact.phoneNumber;
            return this;
        }

        public ContactBuilder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public ContactBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Contact build() {
            return new Contact(uuid, firstName, lastName, phoneNumber);
        }
    }

}


