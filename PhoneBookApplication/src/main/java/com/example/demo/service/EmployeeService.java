package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ContactRepo;
import com.example.demo.model.Contact;

@Service
public class EmployeeService {

	@Autowired
	private ContactRepo repo;

	@Transactional
	public Contact saveContact(Contact contact) {
		return repo.save(contact);
	}

	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Transactional
	public void deleteContact(int id) {
		repo.deleteById(id);
	}

	public Contact editContact(int id) {
		Contact contact = getContactById(id);
		/*
		 * contact.setId(id); contact.setName(con.getName());
		 * contact.setEmail(con.getEmail());
		 * contact.setPhoneNumber(con.getPhoneNumber());
		 */
		return contact;

	}

	public Contact getContactById(int id) {
		return repo.findById(id).get();
	}
}
