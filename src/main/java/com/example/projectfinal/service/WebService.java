package com.example.projectfinal.service;

import com.example.projectfinal.model.entity.Item;
import com.example.projectfinal.model.entity.Orders;
import com.example.projectfinal.model.entity.Purchase;
import com.example.projectfinal.repository.*;
import com.example.projectfinal.vo.OderVOList;
import com.example.projectfinal.vo.OrderVO;
import com.example.projectfinal.vo.Sale_RateVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class WebService {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private PurchaseRepository purchaseRepository;

    public WebService(
                      OrderRepository orderRepository,
                      ItemRepository itemRepository,PurchaseRepository purchaseRepository){
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.purchaseRepository = purchaseRepository;
    }


    public Page<Purchase> Purchases(Pageable pageable){
        Page<Purchase> result = purchaseRepository.findAll(pageable);


        return result;
    }

    public OderVOList Orders(Pageable pageable){
        Page<Orders> result = orderRepository.findAll(pageable);



        //판매량 예측보다 현재 재고가 적으면
        List<OrderVO> orders = result.stream().map(
                orderEntity -> OrderVO.builder()
                        .date(orderEntity.getDate())
                        .i_name(orderEntity.getItem().getItem_Name())
                        .quantity(orderEntity.getOrder_Quantity())
                        .State(orderEntity.getOrder_State())
                        .build()
        ).collect(Collectors.toList());

        OderVOList oderVOList = OderVOList.builder()
                .orderVOList(orders)
                .totalPage(result.getTotalPages())
                .build();
        return oderVOList;
    }

    public Page<Item> Items(Pageable pageable){
        Page<Item> items = itemRepository.findAll(pageable);

        return items;
    }

    public Item Item(int id){
        Item item = itemRepository.findById(id).get();

        return item;
    }
}
