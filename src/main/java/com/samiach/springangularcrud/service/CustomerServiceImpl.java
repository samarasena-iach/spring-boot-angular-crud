package com.samiach.springangularcrud.service;

import com.samiach.springangularcrud.dto.CustomerDTO;
import com.samiach.springangularcrud.dto.CustomerSaveDTO;
import com.samiach.springangularcrud.entity.Customer;
import com.samiach.springangularcrud.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = new Customer(
                customerSaveDTO.getCustomerName(),
                customerSaveDTO.getCustomerAddress(),
                customerSaveDTO.getMobile()
        );

        customerRepository.save(customer);
        return customer.getCustomerName();
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer c : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    c.getCustomerId(), c.getCustomerName(), c.getCustomerAddress(), c.getMobile()
            );

            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }
}
