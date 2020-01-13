package com.example.demo.repository;

import com.example.demo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author nblilili@163.com
 * @date 2020/1/9 13:47
 */

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
//    List<CoffeeOrder> findByCustomerOrderById(String customer);
//
//    List<CoffeeOrder> findByItems_Name(String name);
}
