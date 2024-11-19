package com.green.madang.client;

import com.green.madang.client.model.*;
import com.green.madang.common.model.MyResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController // @Controller 쓰면 쿼리스트링이나 JSON 둘다 반환가능.
// @Controller 쓸거면 매핑 메서드에 @ResponsBody를 써야함
@RequiredArgsConstructor
@RequestMapping("client")
@Tag(name="클라이언트", description = "주문 관리")
public class ClientController {
    private final ClientService service;

    @PostMapping("order")
    public MyResponse<Integer> postOrder(@RequestBody OrderPostReq p){
        return new MyResponse<>("주문등록완료", service.postOrder(p));
    }

    //본인이 주문한 책 리스트 확인
    @GetMapping("order")
    @Operation(summary = "책 주문 리스트")
    public MyResponse<List<OrderGetRes>> getOrderList(@ParameterObject OrderGetReq p){
        List<OrderGetRes> list=service.getOrders(p);
        return new MyResponse<>(list.size()+"개의 검색결과",list);
    }
}
