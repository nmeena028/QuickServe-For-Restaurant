package com.example.QuickServe.For.Restaurant.Controller.Restaurant;


import com.example.QuickServe.For.Restaurant.Dto.RestaurantTable.TableRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.RestaurantTable.TableResponseDto;
import com.example.QuickServe.For.Restaurant.Service.Restaurant.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("table")
@RequiredArgsConstructor
public class RestaurantTableController{

    private final RestaurantTableService restaurantTableService;

    //Get All Tables
    @GetMapping()
    public ResponseEntity<List<TableResponseDto>> getAllTable(){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantTableService.getAllTables());
    }
     @PostMapping
     public ResponseEntity<TableResponseDto> AddTable(@RequestBody TableRequestDto tableRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantTableService.addTable(tableRequestDto));
     }

    //Get Table By ID
    @GetMapping("{id}")
    public ResponseEntity<TableResponseDto> getTableById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantTableService.getTableByID(id));
    }


    //Update Table By ID
    @PutMapping("{id}")
    public ResponseEntity<TableResponseDto> updateTableById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantTableService.updateTableByID(id));
    }

    //Delete Table By ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTableById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantTableService.deleteTableByID(id));
    }

}
