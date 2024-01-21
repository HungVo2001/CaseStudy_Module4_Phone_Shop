package com.example.shop_web.service.orderDetail;

import com.example.shop_web.domain.OrderDetail;
import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OrderDetailServiceImpl  implements IOrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return null;
    }

    @Override
    public void update(OrderDetail orderDetail) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<OrderDetailResDTO> findAllOrderDetailByOrderId(Long orderId) {
        return orderDetailRepository.findAllOrderDetailByOrderId(orderId);
    }

}
