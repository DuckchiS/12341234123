package com.example.projectfinal.vo;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Sale_RateVO {
    private int i_id;
    private String i_name;
    private String s_name;
    private int s_id;
    private int sale;

    @Temporal(TemporalType.DATE)
    private Date date;

    private double sale_predict;

    public Sale_RateVO(){

    }
}
