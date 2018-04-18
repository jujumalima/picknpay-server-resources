/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.customer;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private RoleRepository roleRepository;
  
    public void saveCustomer(Customer customer){
        
        Role role = roleRepository.getOne(4);
        String roleName = role.getName();
        role.setName(roleName);
        
        //Add customer role to set
        Set<Role> roles = new HashSet<Role>(){{
        
            add(role);
        }};
        
        //Set customer role to customer object
        customer.setRoles(roles);
        
        customerRepository.save(customer);
    }
    
    public List<Customer> getAllCustomers(){
        
        return customerRepository.findAll();
    }
    
    
    public Customer getCustomer(int id){
        
        
        return customerRepository.getOne(id);
    }
    
    public void deleteCustomer(int id){
        
        customerRepository.deleteById(id);
    } 
    
    
    public Customer updateCustomer(Customer customer){
    
        Customer c = customerRepository.getOne(customer.getUserID());
        
        if( c == null){
        
            return null;
        }
        
        return customerRepository.save(customer);
    }
    
    public Optional<Customer> getCustomerByUsername(String username){
    
        return customerRepository.findByUserName(username);
    }
     
}
