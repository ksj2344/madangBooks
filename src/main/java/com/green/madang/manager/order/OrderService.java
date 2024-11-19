package com.green.madang.manager.order;


import com.green.madang.manager.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    //p는 8byte의 용량을 갖는다.
    public List<OrderGetRes> getOrderList(OrderGetReq p) {
        p.setStartIndex((p.getPage()-1)* p.getSize());
        return mapper.selOrderlist(p);
    }
}
