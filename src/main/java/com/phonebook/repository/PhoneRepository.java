package com.phonebook.repository;

import com.phonebook.model.Contact;
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
        contact = Contact.builder().from(contact).setUuid(uuid).build();
        contactMap.put(uuid, contact);
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
