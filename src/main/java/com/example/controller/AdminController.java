package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.BookingForm;
import com.example.model.ContactForm;
import com.example.service.BookingFormService;
import com.example.service.ContactFormService;

@Controller
@RequestMapping("admin")
public class AdminController 
{
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
	
	@GetMapping("dashboard")
	public String adminDashboard()
	{
		return "admin/dashboard";
	}
	
	@GetMapping("readAllContacts")
	public String readAllContacts(Model model)
	{
		
		model.addAttribute("allcontacts",contactFormService.readAllContactService());

		return "admin/readallcontacts";
	}
	@GetMapping("deleteContact/{id}")
	public String deleteContact(@PathVariable int id,RedirectAttributes redirectAttributes)
	{
		contactFormService.deleteContactService(id);
		 redirectAttributes.addFlashAttribute("message","contact Deleted successfully");
		return "redirect:/admin/readAllContacts";
	}
	
	@GetMapping("readAllBookings")
	public String readAllBookings(Model model)
	{
		List<BookingForm> allBookingService= bookingFormService.readAllBookingService();
		System.out.println(allBookingService);
		model.addAttribute("allbookings",bookingFormService.readAllBookingService());

		return "admin/readallbookings";
	}
	@GetMapping(path = {"#", "deleteBooking/{id}"})
	public String deleteBooking(@PathVariable int id,RedirectAttributes redirectAttributes)
	{
		bookingFormService.deleteBookingService(id);
		 redirectAttributes.addFlashAttribute("message","Booking Deleted successfully");
		return "redirect:/admin/readAllBookings";
	}
}
