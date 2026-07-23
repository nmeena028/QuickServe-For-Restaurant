package com.example.QuickServe.For.Restaurant.Controller.Restaurant;


import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder.OrderRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder.OrderResponseDto;
import com.example.QuickServe.For.Restaurant.Service.Restaurant.RestaurantOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class RestaurantOrderController {

    private final RestaurantOrderService restaurantOrderService;

    //Get All Orders
    @GetMapping()
    public ResponseEntity<List<OrderResponseDto>> getAllOrder(){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantOrderService.getAllOrder());
    }

    //Create order
    @PostMapping()
    public ResponseEntity<OrderResponseDto> addOrder(@RequestBody OrderRequestDto orderRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantOrderService.addOrder(orderRequestDto));
    }

    //Get Order By ID
    @GetMapping("{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantOrderService.getOrderByID(id));
    }


    //Update Order By ID
    @PutMapping("{id}")
    public ResponseEntity<OrderResponseDto> updateOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantOrderService.updateOrderByID(id));
    }

    //Delete Order By ID
    @DeleteMapping("{id}")
    public ResponseEntity<OrderResponseDto> deleteOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantOrderService.deleteOrderByID(id));
    }

}
