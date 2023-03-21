package spring.softgen.softlab.springboottutorial.service;

import spring.softgen.softlab.springboottutorial.entity.Customer;
import spring.softgen.softlab.springboottutorial.entity.CustomerSearchParams;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll(CustomerSearchParams searchParams);

    Customer add(Customer customer);

    Customer update(int id, Customer customer);

    void delete(int id);

    Customer getCustomer(int id);
}
