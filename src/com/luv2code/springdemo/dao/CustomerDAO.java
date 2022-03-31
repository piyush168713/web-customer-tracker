package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);   // mtd for saving

    public Customer getCustomer(int theId);     // mtd of updating

    void deleteCustomer(int theId);        // mtd for deleting
}
