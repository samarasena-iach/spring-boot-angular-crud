package com.samiach.springangularcrud.service;

import com.samiach.springangularcrud.dto.CustomerDTO;
import com.samiach.springangularcrud.dto.CustomerSaveDTO;
import com.samiach.springangularcrud.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Integer customerId);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO, Integer customerId);

    String deleteCustomer(Integer customerId);
}
