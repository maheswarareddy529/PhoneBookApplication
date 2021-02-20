package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contact;
import com.example.demo.service.EmployeeService;

@RestController
public class ContactController {

	@Autowired
	private EmployeeService service;

	/*
	 * @RequestMapping("/showContactPage") public String showEmployeePage(Model
	 * model) { return "contact"; }
	 * 
	 * @RequestMapping(value = "/saveContact", method = RequestMethod.POST) public
	 * ModelAndView saveEmployee(@ModelAttribute Contact contact) { ModelAndView mav
	 * = new ModelAndView("viewContacts"); mav.addObject("contact",
	 * service.saveContact(contact)); return mav; }
	 * 
	 * @RequestMapping("/viewContacts") public ModelAndView viewContacts() {
	 * ModelAndView mav = new ModelAndView("viewContacts");
	 * mav.addObject("contacts", service.getAllContacts()); return mav; }
	 * 
	 * @RequestMapping("/editContact/{id}") public String editContact(@PathVariable
	 * int id, Model model) { service.editContact(id); //ModelAndView mav = new
	 * ModelAndView("viewContacts"); model.addAttribute("contact",
	 * service.getContactById(id)); model.addAttribute("contacts",
	 * service.getAllContacts()); return "contact"; }
	 * 
	 * @RequestMapping("/deleteContact/{id}") public ModelAndView
	 * deleteContact(@PathVariable int id) { service.deleteContact(id); ModelAndView
	 * mav = new ModelAndView("viewContacts"); mav.addObject("contacts",
	 * service.getAllContacts()); return mav; }
	 */

	@GetMapping("/getContacts")
	public ResponseEntity<List<Contact>> getContacts() {
		return new ResponseEntity<List<Contact>>(service.getAllContacts(), HttpStatus.OK);
	}

	@GetMapping("/getContacts/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable int id) {
		return new ResponseEntity<Contact>(service.getContactById(id), HttpStatus.OK);
	}
	
	@PostMapping("/saveContact")
	public ResponseEntity<Void> saveContact(@RequestBody Contact contact){
		service.saveContact(contact);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable int id){
		service.deleteContact(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
