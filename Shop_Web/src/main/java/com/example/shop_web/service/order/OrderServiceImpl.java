package com.example.shop_web.service.order;

import com.example.shop_web.domain.Order;
import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.domain.dto.OrderResDTO;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.repository.OrderDetailRepository;
import com.example.shop_web.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return null;
    }


    @Override
    public void update(Order order) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<OrderResDTO> findAllOrderByStatus(EStatus status) {
        return orderRepository.findAllOrderResDTO(status);
    }

    @Override
    public OrderResDTO findOrderResDTOByOrderId(Long orderId) {
        return orderRepository.findOrderResDTOByOrderId(orderId);
    }

    @Override
    public List<OrderResDTO> findAllOrderResDTOByUserAndStatus(EStatus status, Long userId) {
        return orderRepository.findAllOrderResDTOByUserAndStatus(status,userId);
    }


}
