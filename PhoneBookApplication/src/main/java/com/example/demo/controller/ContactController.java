package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contact;
import com.example.demo.service.EmployeeService;

@Controller
public class ContactController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/showContactPage")
	public String showEmployeePage(Model model) {
		return "contact";
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Contact contact) {
		ModelAndView mav = new ModelAndView("viewContacts");
		mav.addObject("contact", service.saveContact(contact));
		return mav;
	}
	
	@RequestMapping("/viewContacts")
	public ModelAndView viewContacts() {
		ModelAndView mav = new ModelAndView("viewContacts");
		mav.addObject("contacts", service.getAllContacts());
		return mav;
	}
	
	@RequestMapping("/editContact/{id}")
	public String editContact(@PathVariable int id, Model model) {
		service.editContact(id);
		//ModelAndView mav = new ModelAndView("viewContacts");
		model.addAttribute("contact", service.getContactById(id));
		model.addAttribute("contacts", service.getAllContacts());
		return "contact";
	}
	
	@RequestMapping("/deleteContact/{id}")
	public ModelAndView deleteContact(@PathVariable int id) {
		service.deleteContact(id);
		ModelAndView mav = new ModelAndView("viewContacts");
		mav.addObject("contacts", service.getAllContacts());
		return mav;
	}
}
