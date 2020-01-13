package com.example.demo.service;

import com.example.demo.model.Coffee;
import com.example.demo.model.CoffeeOrder;
import com.example.demo.model.OrderState;
import com.example.demo.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author nblilili@163.com
 * @date 2020/1/13 10:35
 */

@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository orderRepository;

    /**
     * 创建一个订单
     * @param customer
     * @param coffee
     * @return
     */
    public CoffeeOrder createOrder(String customer, Coffee...coffee){
        CoffeeOrder order = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList()))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("New Order:{}", saved);
        return saved;
    }

    /**
     * 更新状态,状态不能逆向更新
     * @param order
     * @param state
     * @return
     */
    public boolean updateState(CoffeeOrder order, OrderState state){
        if(state.compareTo(order.getState()) <= 0){
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Update Order: {}", order);
        return true;
    }
}
