package com.rv.servicejavapractice.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonProxy {
    private Object data;
    private String message;
    private Boolean flag;
    private Integer status;
}
