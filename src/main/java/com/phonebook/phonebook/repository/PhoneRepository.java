package com.phonebook.phonebook.repository;

import com.phonebook.phonebook.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class PhoneRepository {
    private final Map<UUID, Contact> contactMap = new HashMap<>();

    public Contact save(Contact contact) {
        var uuid = UUID.randomUUID();
        contact.
        contactMap.put(uuid, new Contact(uuid, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber()));
        return contact;
    }

    public Contact updateContact(Contact contact) {
        var uuid = contactMap.keySet().stream().filter(i -> contact.getUuid().equals(i)).findFirst().orElseThrow();
        contactMap.put(uuid, contact);
        return contact;
    }

    public void deleteContact(UUID uuid) {
        contactMap.remove(uuid);
    }

    public List<Contact> getAllContacts() {
        return contactMap.values().stream().toList();
    }

    public Contact getContact(UUID id) {
        return contactMap.get(id);
    }
}
