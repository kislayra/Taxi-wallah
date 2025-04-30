package com.example.service;

import java.util.List;

import com.example.model.ContactForm;

import jakarta.validation.Valid;

public interface ContactFormService 
{
	public ContactForm saveContactFormService(ContactForm contactForm);
	public List<ContactForm> readAllContactService();

	public void deleteContactService(int id);

}
