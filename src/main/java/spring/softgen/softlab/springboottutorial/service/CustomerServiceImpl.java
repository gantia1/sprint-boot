package spring.softgen.softlab.springboottutorial.service;

import org.springframework.stereotype.Service;
import spring.softgen.softlab.springboottutorial.entity.Customer;
import spring.softgen.softlab.springboottutorial.entity.CustomerSearchParams;
import spring.softgen.softlab.springboottutorial.exception.NotFoundException;
import spring.softgen.softlab.springboottutorial.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll(CustomerSearchParams searchParams) {
        return customerRepository.findAll();
    }

    public Customer add(Customer customer) {
        customer.setDeleted(false);
        return customerRepository.save(customer);
    }

    public Customer update(int id, Customer customer) {
        var foundCustomer = getCustomer(id);
        foundCustomer.setFirstName(customer.getFirstName());
        foundCustomer.setLastName(customer.getLastName());
        foundCustomer.setBirthDate(customer.getBirthDate());
        return customerRepository.save(foundCustomer);
    }

    public void delete(int id) {
        var foundCustomer = getCustomer(id);
        foundCustomer.setDeleted(true);
        customerRepository.save(foundCustomer);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
