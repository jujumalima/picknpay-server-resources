/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.order;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order) {

        orderRepository.save(order);
    }

    public Order getOrder(int id) {

        return orderRepository.getOne(id);
    }

    public void deleteOrder(int id) {

        orderRepository.deleteById(id);
    }

    public List<Order> getOrders() {

        return this.orderRepository.findAll();
    }
    
    public Order updateOrder(Order order){
    
        Order ordered = orderRepository.getOne(order.getOrderID());
        
        if(ordered == null){
        
            return null;
        }
        
        return orderRepository.save(order);
    }

    /*
    public Order getOrderByEmail(String email) {

        List<Order> orders = this.getOrders();
        Order order = null;

        if (!orders.isEmpty()) {

            for (int i = 0; i < orders.size(); i++) {

                if (orders.get(i).getUser().getUserName().equals(email)) {

                    order = orders.get(i);
                }
            }
        }

        return order;
    }
*/
}
