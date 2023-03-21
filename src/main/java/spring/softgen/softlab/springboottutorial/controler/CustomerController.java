package spring.softgen.softlab.springboottutorial.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import spring.softgen.softlab.springboottutorial.entity.Customer;
import spring.softgen.softlab.springboottutorial.entity.CustomerSearchParams;
import spring.softgen.softlab.springboottutorial.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
//    public List<Customer> getAll(@RequestParam(required = false) String firstName,
//                                 @RequestParam(required = false) String lastName)
//     იმ შემთხვევაში თუ მინდა ბევრი პარამეტრით ერთად მოვძებნო
    public List<Customer> getAll(CustomerSearchParams searchParams) {
        return customerService.getAll(searchParams);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        customerService.add(customer);
        var location = UriComponentsBuilder.fromPath("/customer/" + customer.getId()).build().toUri();
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable int id) {
        return customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}