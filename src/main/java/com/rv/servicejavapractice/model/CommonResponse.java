package com.rv.servicejavapractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private String status;
    private Integer statusId;
    private Date date;
    private Double amount;
}
