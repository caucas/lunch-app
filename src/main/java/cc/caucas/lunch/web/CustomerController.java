package cc.caucas.lunch.web;

import cc.caucas.lunch.domain.Customer;
import cc.caucas.lunch.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
