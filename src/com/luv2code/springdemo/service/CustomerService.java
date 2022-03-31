package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);     // mtd for saving

    Customer getCustomer(int theId);        // mtd for updating

    void deleteCustomer(int theId);         // mtd for deleting
}
