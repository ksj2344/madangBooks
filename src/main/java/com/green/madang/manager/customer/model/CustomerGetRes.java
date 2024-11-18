package com.green.madang.manager.customer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerGetRes {
    private int custId;
    private String name;
    private String address;
    private String phone;
}

// 보통 쿼리문 관련해서 이런식으로 request용과 response용 객체를 둘 다 만듬
// 그러나 우리는 select를 제외하면 튜플 하나만을 받고있기 때문에 현재는 get문에서만 필요.
