package com.samiach.springangularcrud.service;

import com.samiach.springangularcrud.dto.CustomerDTO;
import com.samiach.springangularcrud.dto.CustomerSaveDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveDTO customerSaveDTO);

    List<CustomerDTO> getAllCustomers();
}
