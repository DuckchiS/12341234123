package com.example.projectfinal.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OderVOList {
    List<OrderVO> orderVOList = new ArrayList<>();
    int totalPage;
}
