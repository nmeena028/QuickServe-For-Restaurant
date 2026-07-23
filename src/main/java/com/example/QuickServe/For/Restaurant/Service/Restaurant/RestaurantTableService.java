package com.example.QuickServe.For.Restaurant.Service.Restaurant;

import com.example.QuickServe.For.Restaurant.Dto.RestaurantTable.TableRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.RestaurantTable.TableResponseDto;
import com.example.QuickServe.For.Restaurant.Repo.TableRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {

    private final TableRepo tableRepo;


//    public List<TableResponseDto> getAllTables() {
//    }
//
//    public TableResponseDto getTableByID(Long id) {
//    }
//
//    public TableResponseDto updateTableByID(Long id) {
//    }
//
//    public String deleteTableByID(Long id) {
//    }
//
//    public TableResponseDto addTable(TableRequestDto tableRequestDto) {
//    }
}
