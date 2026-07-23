package com.example.QuickServe.For.Restaurant.Service.Restaurant;


import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder.OrderRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder.OrderResponseDto;
import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrderItem.OrderItemResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Enum.OrderStatus;
import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.OrderItem;
import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.Orders;
import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.Table;
import com.example.QuickServe.For.Restaurant.Entity.Product;
import com.example.QuickServe.For.Restaurant.Repo.OrderRepo;
import com.example.QuickServe.For.Restaurant.Repo.ProductRepo;
import com.example.QuickServe.For.Restaurant.Repo.TableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantOrderService {

    private final OrderRepo orderRepo;

    private final TableRepo tableRepo;

    private final ProductRepo productRepo;


    public List<OrderResponseDto> getAllOrder() {

        List<Orders> orders = orderRepo.findAll();

        return orders.stream().map((order) -> new OrderResponseDto(order.getId(), order.getCustomerName(), order.getPhoneNumber(), order.getTableRestaurant().getTableNumber(), order.getStatus(), order.getTotalAmount(), order.getOrderItems().stream().map((item) -> new OrderItemResponseDto(item.getProduct().getId(), item.getProduct().getName(), item.getQuantity(), item.getPriceAtOrder(), item.getPriceAtOrder() * item.getQuantity())).toList()

        )).toList();
    }

    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto) {
        Table tableRestaurant = tableRepo.findById(orderRequestDto.getTableId()).orElseThrow(() ->
                new RuntimeException("Table id is wrong"));

        Orders orders = new Orders();


        orders.setCustomerName(orderRequestDto.getCustomerName());
        orders.setPhoneNumber(orderRequestDto.getPhoneNumber());
        orders.setStatus(OrderStatus.PENDING);
        orders.setCreatedAt(LocalDateTime.now());
        orders.setTableRestaurant(tableRestaurant);
        orders.setOrderItems(orderRequestDto.getItems().stream().map(items -> {

            Product product = productRepo.findById(items.getProductId()).orElseThrow(() ->
                    new RuntimeException("Product id is wrong"));

            OrderItem orderItem = new OrderItem();

            orderItem.setProduct(product);
            orderItem.setQuantity(items.getQuantity());
            orderItem.setPriceAtOrder(product.getPrice());
            orderItem.setOrders(orders);
            return orderItem;
        }).toList());

        Long totalAmount = orders.getOrderItems()
                .stream()
                .mapToLong(item -> item.getPriceAtOrder() * item.getQuantity())
                .sum();

        orders.setTotalAmount(totalAmount);

        OrderResponseDto orderResponseDto=new OrderResponseDto(
                orders.getId(),
                orders.getCustomerName(),
                orders.getPhoneNumber(),
                orders.getTableRestaurant().getTableNumber(),
                orders.getStatus(),
                orders.getTotalAmount(),
                orders.getOrderItems().stream().map((item)->new OrderItemResponseDto(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getPriceAtOrder(),
                        item.getPriceAtOrder() * item.getQuantity())).toList()
        );

        orderRepo.save(orders);

      return orderResponseDto;
    }

//    public OrderResponseDto getOrderByID(Long id) {
//    }
//
//    public OrderResponseDto updateOrderByID(Long id) {
//    }
//
//    public OrderResponseDto deleteOrderByID(Long id) {
//    }
}
