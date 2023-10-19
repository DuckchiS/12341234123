package com.example.projectfinal.vo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
public class OrderVO {
    @Temporal(TemporalType.DATE)
    private Date date;

    private String s_name;
    private int s_id;
    private String i_name;
    private int quantity;
    private String State;
    private int Price;
}
