package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer dao
    // @Autowired                          // I'm no longer use the CustomerDAO directly. Instead I gonna use that service layer or the Customer service.
    // private CustomerDAO customerDAO;

    // need to inject our customer service
    @Autowired
    private CustomerService customerService;

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model theModel){

        // get the customers from the service
        List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);     // ("name", value)

        return "list-customers";
    }


    @GetMapping("/showFormForAdd")
    private String showFormForAdd(Model theModel){

        // create model attribute to bind our form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);     // name=customer  value=theCustomer

        return "customer-form";           // now create your customer-form.jsp file (HTML file)
    }

    // Set up a @PostMapping for "saveCustomer", it is based on the information that we received from the HTML form(customer-form.jsp Line 26)
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        // save the customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    private String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){

        // get the customer from service
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public  String deleteCustomer(@RequestParam("customerId") int theId){

        // delete the customer
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }


}
