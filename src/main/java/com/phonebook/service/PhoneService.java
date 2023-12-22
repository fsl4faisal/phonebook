package com.phonebook.service;

import com.phonebook.model.Contact;
import com.phonebook.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Contact createContact(Contact contact) {
        return phoneRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        return phoneRepository.updateContact(contact);
    }

    public void deleteContact(UUID uuid) {
        phoneRepository.deleteContact(uuid);
    }

    public List<Contact> getAllContacts() {
        return phoneRepository.getAllContacts();
    }

    public Contact getContact(UUID id) {
        return phoneRepository.getContact(id);
    }
}
