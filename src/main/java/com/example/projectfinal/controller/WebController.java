package com.example.projectfinal.controller;

import com.example.projectfinal.model.entity.Item;
import com.example.projectfinal.model.entity.Purchase;
import com.example.projectfinal.service.WebService;
import com.example.projectfinal.vo.OderVOList;
import com.example.projectfinal.vo.OrderVO;
import com.example.projectfinal.vo.Sale_RateVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class WebController {
    private WebService webService;

    public WebController(WebService webService){
        this.webService = webService;
    }
//
//    @GetMapping("/test")
//    public ResponseEntity<Object> test(){
//        Map<String, Object> result = new HashMap<>();
//
//        Map<String, Double> totalSales = detailWebService.totalSales();
//        result.put("today_total_sales", totalSales);
//
//        List<Map<String, Object>> productMarketShare = detailWebService.MarketShare();
//        result.put("marketShare", productMarketShare);
//
//        Map<String, Double> weeklySale = detailWebService.weeklySale();
//        result.put("Weekly_sale", weeklySale);
//
//        Map<String, Double> productShare = detailWebService.productShare();
//        result.put("product_share", productShare);
//
////       List<Map<String, Object>> weeklyShop = webService.getWeeklyShop();
////       result.put("weekShop", weeklyShop);
//
//        return ResponseEntity.ok().body(result);
//    }

//    @GetMapping("/")
//    public ResponseEntity<Object> Main(){
//        Map<String, Object> result = new HashMap<>();
//
//        // Top 3 상품 점유율
//        List<Sale_RateVO> top3ShareList = new ArrayList<>();
//        Map<String, Double> productShares = webService.getTop3Share();
//        for (Map.Entry<String, Double> entry : productShares.entrySet()) {
//            Sale_RateVO saleRateVO = new Sale_RateVO();
//            saleRateVO.setI_name(entry.getKey());
//            saleRateVO.setSale_predict(entry.getValue());
//            top3ShareList.add(saleRateVO);
//        }
//        result.put("top3Share", top3ShareList);
//
//        // Top 3 상점 매출
//        List<Map<String, Object>> top3ShopList = webService.getTop3Shop();
//        result.put("top3Shop", top3ShopList);
//
//        List<Map<String, Object>> top5Item = webService.totalTop5();
//        result.put("totalTop5", top5Item);
//
////        List<Map<String, Object>> weeklyShop = webService.getWeeklyShop();
////        result.put("weekShop", weeklyShop);
//
////        List<Map<String, Object>> weeklyCategory = webService.getWeeklyCategory();
////        result.put("weekCategory", weeklyCategory);
//
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/purchases")
    public ResponseEntity<Object> Purchases(Pageable pageable){
        Page<Purchase> result = webService.Purchases(pageable);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/orders")
    public ResponseEntity<Object> Order(Pageable pageable){
        OderVOList orderVOList = webService.Orders(pageable);

        return ResponseEntity.ok().body(orderVOList);
    }
//
//    @GetMapping("/detail")
//    public ResponseEntity<Object> Detail(){
//        List<Sale_RateVO> saleRateVOList = new ArrayList<>();
//
//        List<Sale_RateVO> detailList = webService.Detail();
//        saleRateVOList.addAll(detailList);
//
//
////        List<Sale_RateVO> salesForLast7Days = webService.getSalesForLast7Days();
////        saleRateVOList.addAll(salesForLast7Days);
//
//        return ResponseEntity.ok().body(saleRateVOList);
//    }

    @GetMapping("/items")
    public ResponseEntity<Object> Items(Pageable pageable){

        Page<Item> detailList = webService.Items(pageable);


        return ResponseEntity.ok().body(detailList);
    }

    @GetMapping("/item")
    public ResponseEntity<Object> Item(int id){

        Item item = webService.Item(id);


        return ResponseEntity.ok().body(item);
    }


}
