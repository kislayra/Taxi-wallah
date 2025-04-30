
 package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.BookingForm;
import com.example.model.ContactForm;
import com.example.service.BookingFormService;
import com.example.service.ContactFormService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {

	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;
	
    @Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@GetMapping(path = {"/", "", "home", "welcome", "index"})
	public String welcomeView(HttpServletRequest req, Model m) {
		String reqURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", reqURI);
		m.addAttribute("bookingForm", new BookingForm());
		return "index";
	}

	@GetMapping("about")
	public String aboutView(HttpServletRequest req, Model m) {
		String reqURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", reqURI);
		return "about";
	}

	@GetMapping("cars")
	public String carsView(HttpServletRequest req, Model m) {
		String reqURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", reqURI);
		return "cars";
	}

	@GetMapping("services")
	public String servicesView(HttpServletRequest req, Model m) {
		String reqURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", reqURI);
		return "services";
	}

	@GetMapping("contacts")
	public String contactsView(HttpServletRequest req, Model m) {
		String reqURI = req.getRequestURI();
		m.addAttribute("mycurrentpage", reqURI);
		m.addAttribute("contactForm", new ContactForm());
		return "contacts";
	}
	@GetMapping("/login")
	public String adminLoginView()
	{
		return "adminlogin";
	}

	@PostMapping("contactForm")
	public String contactForm(@Valid @ModelAttribute ContactForm contactForm,
							  BindingResult bindingResult,
							  Model m,
							  RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "contacts";
		}

		ContactForm saved = contactFormService.saveContactFormService(contactForm);
		if (saved != null) {
			redirectAttributes.addFlashAttribute("message", "message sent successfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "something went wrong");
		}

		return "redirect:/contacts";
	}

	@PostMapping("bookingForm")
	public String bookingForm(@Valid @ModelAttribute BookingForm bookingForm,
							  BindingResult bindingResult,
							  Model m,
							  RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			m.addAttribute("bindingResult", bindingResult);
			return "index";
		}
		//System.out.println(bookingForm);
	BookingForm saveBookingFormService =	bookingFormService.saveBookingFormService(bookingForm);
	if (saveBookingFormService!= null) {
		redirectAttributes.addFlashAttribute("message", "Booking sent successfully");
	} else {
		redirectAttributes.addFlashAttribute("message", "something went wrong");
	}

		return "redirect:/index";
	}
}
