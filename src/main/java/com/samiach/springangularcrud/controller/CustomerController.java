package com.samiach.springangularcrud.controller;

import com.samiach.springangularcrud.dto.CustomerDTO;
import com.samiach.springangularcrud.dto.CustomerSaveDTO;
import com.samiach.springangularcrud.dto.CustomerUpdateDTO;
import com.samiach.springangularcrud.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) {
        String id = customerService.addCustomer(customerSaveDTO);
        return "Saved Customer Successfully!";
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable("customerId") Integer customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return customer;
    }

    @PutMapping("/{customerId}")
    public String updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String id = customerService.updateCustomer(customerUpdateDTO, customerId);
        return "Updated Customer Successfully!";
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Integer customerId) {
        String id = customerService.deleteCustomer(customerId);
        return "Deleted Customer Successfully!";
    }

}
