package cc.caucas.lunch.api.controller;

import cc.caucas.lunch.domain.model.Customer;
import cc.caucas.lunch.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Georgy Davityan.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping
    public Iterable<Customer> getCustomers() {
//        return customerRepository.query(new CustomerSpecificationAll());
        return null;
    }

}
