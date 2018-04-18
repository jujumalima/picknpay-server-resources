/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class JwtAuthenticationResponse implements Serializable{
    
    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        
        this.token = token;
        
    }

    public String getToken() {
        
        return this.token;
        
    }
    
}
