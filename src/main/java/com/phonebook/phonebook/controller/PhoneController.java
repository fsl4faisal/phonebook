package com.phonebook.phonebook.controller;

import com.phonebook.phonebook.model.Contact;
import com.phonebook.phonebook.service.PhoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contacts")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/health/check")
    public String health() {
        return "true";
    }


    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        var savedContact = phoneService.createContact(contact);
        return ResponseEntity.ok(savedContact);
    }

    @PutMapping
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
        var updatedContact = phoneService.updateContact(contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{uuid}")
    public void deleteContact(UUID uuid) {
        phoneService.deleteContact(uuid);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        var contacts = phoneService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(UUID id) {
        var contact=phoneService.getContact(id);
        return ResponseEntity.ok(contact);
    }

}
