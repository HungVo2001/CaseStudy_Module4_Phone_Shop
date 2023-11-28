    package com.example.shop_web.controller.api;

    import com.example.shop_web.domain.*;
    import com.example.shop_web.domain.dto.*;
    import com.example.shop_web.domain.enumaration.EStatus;
    import com.example.shop_web.exception.DataInputException;
    import com.example.shop_web.repository.*;
    import com.example.shop_web.service.branch.IBranchService;
    import com.example.shop_web.service.order.IOrderService;
    import com.example.shop_web.service.orderDetail.IOrderDetailService;
    import com.example.shop_web.service.user.IUserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;
    import java.util.List;

    @RestController
    @RequestMapping("/api/orders")
    public class OrderRestController {
        @Autowired
        private IOrderService orderService;
        @Autowired
        private IOrderDetailService orderDetailService;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private LocationRegionRepository locationRegionRepository;
        @Autowired
        private OrderRepository orderRepository;
        @Autowired
        private CartDetailRepository cartDetailRepository;
        @Autowired
        private OrderDetailRepository orderDetailRepository;
        @Autowired
        private ProductRepository productRepository;

        @GetMapping("/confirming/user")
        public ResponseEntity<?> getAllOrderConfirmingByUser(Authentication authentication) {
    //        User user= userService.getCurrentUser().get();

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User userSession = userRepository.findByUsername(username).get();
            Long id  = userSession.getId();




            List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CONFIRMING,id);
            for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
            return new ResponseEntity<>(orders, HttpStatus.OK);
    }

        @GetMapping("/canceled/user")
        public ResponseEntity<?> getAllOrderCanceledByUser(Authentication authentication) {


    //        User user= userService.getCurrentUser().get();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User userSession = userRepository.findByUsername(username).get();
            Long id  = userSession.getId();

            List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CANCELED,id);
            for (OrderResDTO ord : orders) {
                List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
                ord.setOrderDetails(orderDetails);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }

        @GetMapping("/confirmed/user")
        public ResponseEntity<?> getAllOrderConfirmedByUser(Authentication authentication) {

    //        User user= userService.getCurrentUser().get();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User userSession = userRepository.findByUsername(username).get();
            Long id  = userSession.getId();


            List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CONFIRMED,id);
            for (OrderResDTO ord : orders) {
                List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
                ord.setOrderDetails(orderDetails);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }

        @GetMapping("/confirming")
        public ResponseEntity<?> getAllOrderConfirming() {
            List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMING);
            for (OrderResDTO ord : orders) {
                List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
                ord.setOrderDetails(orderDetails);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }

        @GetMapping("/confirmed")
        public ResponseEntity<?> getAllOrderConfirmed() {
            List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMED);
            for (OrderResDTO ord : orders) {
                List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
                ord.setOrderDetails(orderDetails);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }

        @GetMapping("/canceled")
        public ResponseEntity<?> getAllOrderCanceled() {
            List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CANCELED);
            for (OrderResDTO ord : orders) {
                List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
                ord.setOrderDetails(orderDetails);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }

        @GetMapping("/{idOrder}")
        public ResponseEntity<?> findById(@PathVariable Long idOrder) {
            OrderResDTO order = orderService.findOrderResDTOByOrderId(idOrder);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }

        @GetMapping("/orderDetails/{idOrder}")
        public ResponseEntity<?> findOrderDetailsById(@PathVariable Long idOrder) {
            List<OrderDetailResDTO> orderdetails = orderDetailService.findAllOrderDetailByOrderId(idOrder);
            return new ResponseEntity<>(orderdetails, HttpStatus.OK);
        }

        @PatchMapping("/confirmOrder/{idOrder}")
        public ResponseEntity<?> confirm(@RequestBody OrderReqDTO orderReqDTO, @PathVariable Long idOrder) {
            Order order = orderService.findById(idOrder).get();
            order.setStatus(EStatus.CONFIRMED);
            orderService.save(order);
            return new ResponseEntity<>(orderReqDTO, HttpStatus.OK);
        }

        @PatchMapping("/cancelOrder/{idOrder}")
        public ResponseEntity<?> cancel(@RequestBody OrderReqDTO orderReqDTO, @PathVariable Long idOrder) {
            Order order = orderService.findById(idOrder).get();
            order.setStatus(EStatus.CANCELED);
            orderService.save(order);
            return new ResponseEntity<>(orderReqDTO, HttpStatus.OK);
        }
        @PostMapping("/create")
        public ResponseEntity<?> createOrder(@RequestBody OderCreDTO oderCreDTO, Authentication authentication){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User user = userRepository.getByUsername(username);
            LocationRegion locationRegion = oderCreDTO.getLocationRegionCreDTO().toLocationRegion();
            locationRegionRepository.save(locationRegion);
            String strCode = user.getId().toString() + "SHIPPING";
            Order order = new Order().setUser(user).setEmail(user.getUsername()).setPhone(oderCreDTO.getPhone())
                    .setOrderDate(LocalDateTime.now()).setReceiverName(oderCreDTO.getReceiverName()).setShippingCode(strCode)
                    .setTotalAmount(oderCreDTO.getTotalAmount()).setStatus(EStatus.CONFIRMING).setLocationRegion(locationRegion);
            orderRepository.save(order);
            List<CartDetail> cartDetails = cartDetailRepository.getAllByUser_Id(user.getId());
            for (CartDetail cD: cartDetails) {
                int quantity = cD.getQuantity();
                Product productOld = cD.getProduct();
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(cD.getProduct()).setOrder(order).setQuantity(quantity).setTotalAmount(cD.getTotalAmount());
                orderDetailRepository.save(orderDetail);
                cartDetailRepository.delete(cD);
                Product productNew = productOld.setQuantity(productOld.getQuantity() - quantity);
                if(productNew.getQuantity() < 0) {
                    throw new DataInputException("Sản phầm hết hàng, vui lòng đặt lại!!");
                }else productRepository.save(productNew);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }
