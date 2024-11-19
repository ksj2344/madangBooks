package com.green.madang.client.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderGetRes {
    //@JsonProperty("order_id")  swagger에서 카멜케이스가 아니라 _로 보려면 이렇게 처리
    private int orderId;
    private int bookId;
    private String bookName;
    private int salePrice;
    private String orderDate;
}
