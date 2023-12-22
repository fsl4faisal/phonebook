package com.phonebook.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class Contact {
    private final UUID uuid;
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

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
    }
}


