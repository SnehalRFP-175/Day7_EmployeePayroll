package com.bridgelabz.employeepayrollapp.DTO;


import jdk.jfr.DataAmount;
import lombok.Data;
/*
Using Lombok insted of getter setter
 */
@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
