/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bankdetail;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class BankDetailService {
    
    @Autowired
    private BankDetailRepository bankDetailRepository;
    
    public void createBankAccount(BankDetail bankDetail){
        
        bankDetailRepository.save(bankDetail);
        
    }
    
    public List<BankDetail> accounts(){
    
        return bankDetailRepository.findAll();
    }
    
    public BankDetail getAccount(int  id){
        
        
        return bankDetailRepository.getOne(id);
    
    }
    
    public void deleteAccount(int id){
    
        bankDetailRepository.deleteById(id);
    }
    
    public BankDetail updateAccount(BankDetail bankDetail){
        
        
        BankDetail bd = this.getAccount(bankDetail.getBankDetailID());
        
        if( bd == null){
            
            return null;
        }
    
        return bankDetailRepository.save(bankDetail);
    }
}
