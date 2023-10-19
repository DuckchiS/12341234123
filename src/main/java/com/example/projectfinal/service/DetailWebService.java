//package com.example.projectfinal.service;
//
//import com.example.projectfinal.repository.OrderRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Service
//public class DetailWebService {
//    private Sale_RateRepository saleRateRepository;
//    private OrderRepository orderRepository;
//
//    public DetailWebService(Sale_RateRepository saleRateRepository,
//                            OrderRepository orderRepository){
//        this.orderRepository = orderRepository;
//        this.saleRateRepository = saleRateRepository;
//    }
//
//
//
//    public Map<String, Double> productShare(){
//        // 전체 판매량 계산
//        double totalSales = saleRateRepository.getTotalSales();
//
//        // 각 상품의 판매량을 가져옵니다.
//        List<Sale_Rate> allSales = saleRateRepository.getAllSales();
//        Map<String, Double> productSalesMap = allSales.stream()
//                .collect(Collectors.groupingBy(
//                        saleRate -> saleRate.getItem().getItem_Name(),
//                        Collectors.summingDouble(Sale_Rate::getSame_Day_Sale_Rate)
//                ));
//
//        // 상품 점유율을 계산합니다.
//        Map<String, Double> productMarketShare = productSalesMap.entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        entry -> (entry.getValue() / totalSales) * 100
//                ));
//
//        // 상품 점유율을 내림차순으로 정렬합니다.
//        return productMarketShare.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));
//    }
//
//    public Map<String, Double> weeklySale(){
//        double totalSale = saleRateRepository.getTotalItemPrice();
//
//        List<Sale_Rate> allSale = saleRateRepository.getAllSales();
//        Map<String, Double> totalSaleMap = allSale.stream()
//                .collect(Collectors.groupingBy(
//                        saleRate -> saleRate.getItem().getItem_Name(),
//                        Collectors.summingDouble(Sale_Rate::getItem_Price)
//                ));
//
//        Map<String, Double> totalShopSale = totalSaleMap.entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        entry -> (totalSale)
//                ));
//
//        return totalShopSale;
//    }
//
//    public Map<String, Double> totalSales(){
//        double totalSale = saleRateRepository.getTotalItemPrice();
//
//        List<Sale_Rate> allSale = saleRateRepository.getAllSales();
//        Map<String, Double> totalSaleMap = allSale.stream()
//                .collect(Collectors.groupingBy(
//                        saleRate -> saleRate.getItem().getItem_Name(),
//                        Collectors.summingDouble(Sale_Rate::getItem_Price)
//                ));
//
//        Map<String, Double> totalShopSale = totalSaleMap.entrySet().stream()
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        entry -> (totalSale)
//                ));
//
//        return totalShopSale;
//    }
//
//    public List<Map<String, Object>> MarketShare() {
//        // 전체 판매량 계산
//        // 각 상품의 판매량을 가져옵니다.
//        List<Sale_Rate> allSales = saleRateRepository.getAllSales();
//
//        // 각 상품의 판매량을 합산합니다.
//        Map<String, Double> itemSalesMap = allSales.stream()
//                .collect(Collectors.groupingBy(
//                        saleRate -> saleRate.getItem().getItem_Name(),
//                        Collectors.summingDouble(Sale_Rate::getSame_Day_Sale_Rate)
//                ));
//
//        // 판매량을 기준으로 내림차순으로 정렬하고 상품 이름도 함께 유지한 후 반환
//        List<Map<String, Object>> sortedSales = itemSalesMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
//                .map(entry -> {
//                    Map<String, Object> saleInfo = new HashMap<>();
//                    saleInfo.put("item_name", entry.getKey());
//                    saleInfo.put("salesQuantity", entry.getValue());
//                    return saleInfo;
//                })
//                .collect(Collectors.toList());
//
//        return sortedSales;
//    }
//
//}
