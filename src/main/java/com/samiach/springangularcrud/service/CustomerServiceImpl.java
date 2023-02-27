package com.samiach.springangularcrud.service;

import com.samiach.springangularcrud.dto.CustomerDTO;
import com.samiach.springangularcrud.dto.CustomerSaveDTO;
import com.samiach.springangularcrud.dto.CustomerUpdateDTO;
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

    @Override
    public CustomerDTO getCustomerById(Integer customerId) {
        boolean isExistingCustomer = customerRepository.existsById(customerId);
        CustomerDTO customerDTO = new CustomerDTO();

        if (isExistingCustomer) {
            Customer customer = customerRepository.findById(customerId).get();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCustomerName(customer.getCustomerName());
            customerDTO.setCustomerAddress(customer.getCustomerAddress());
            customerDTO.setMobile(customer.getMobile());
            return customerDTO;
        }

        return null;
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO, Integer customerId) {
        boolean isExistingCustomer = customerRepository.existsById(customerId);

        if (isExistingCustomer) {
            Customer customer = customerRepository.findById(customerId).get();
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setMobile(customerUpdateDTO.getMobile());
            customerRepository.save(customer);
        } else {
            System.out.println("No Record found for Customer [ID = " + customerId + "]");
        }
        return null;
    }

    @Override
    public String deleteCustomer(Integer customerId) {
        boolean isExistingCustomer = customerRepository.existsById(customerId);
        if (isExistingCustomer) {
            customerRepository.deleteById(customerId);
        }
        return null;
    }
}
