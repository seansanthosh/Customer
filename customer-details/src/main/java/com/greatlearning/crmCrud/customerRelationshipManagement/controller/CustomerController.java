package com.greatlearning.crmCrud.customerRelationshipManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer;
import com.greatlearning.crmCrud.customerRelationshipManagement.service.CustomerService;
import com.greatlearning.crmCrud.customerRelationshipManagement.service.CustomerServiceImpl;

import com.greatlearning.crmCrud.customerRelationshipManagement.dao.ICustomerDao;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, path = "/show-form")
	public String showFormToUser() {
		return "newRegi";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/new")
	public String newRegistration() {
		return "newRegi";
	}
	@RequestMapping(method = RequestMethod.GET, path = "/show")
	public String customerDetailsDisplay() {
		return "redirect:show-customers";
	}
	//@RequestMapping(method = RequestMethod.GET,path="/update-customer")
    //public String editsave(@ModelAttribute("customer") Customer customer){
    //    customerService.update(customer.getId());
    //    System.out.println("to :"+customer.toString());
     //   return ("redirect:show-customers");
   // }

	@RequestMapping(method = RequestMethod.GET, path = "/delete-customer")
	public String deletecustomerDetails(@RequestParam("id") Integer id) {
		System.out.println("method called with id is: "+id);
		if (customerService.deleteCustomer(id)) {
			System.out.println("customer deleted");
		} else {
			System.out.println("customer not deleted");
		}

		return "redirect:show-customers";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/new-customer")
	public String addcustomerDetails(@RequestParam("id") Integer id,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = new Customer(id,firstName,lastName,email);
		customerService.add(customer);

		return "redirect:show-customers";
	}
	 @RequestMapping(path="/update",method = RequestMethod.POST)
	    public String editsave(@ModelAttribute("customer") Customer customer){
	
	        customerService.updateCustomerDetails(customer.getId(), customer);
	        System.out.println("to :"+ customer.toString());
	        return ("redirect:show-customers");
	    }
	
	 @RequestMapping(method = RequestMethod.GET,path="/updateForm")
	    public String updateStudent(@RequestParam("id") int theId, Model theModel) {
	        Customer theCustomer = customerService.getCustomer(theId);
	        System.out.println("The details of customer with id "+theId+" are updated from ");
	        System.out.println(theCustomer.toString());
	        theModel.addAttribute("command", theCustomer);
	        return "updateDetails";
	    }


	@RequestMapping(method = RequestMethod.GET, path = "/show-customers")
	public ModelAndView getcustomersDetails(ModelAndView mav) {

		List<Customer> customers = customerService.getAllCustomers();
		mav.setViewName("customerInfo");
		mav.addObject("customerInfo", customers);

		return mav;
	}

}
