package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@Tag(name = "고객", description = "고객 관리")
public class CustomerController {
    private final CustomerService service;
    @PostMapping
    @Operation(summary = "고객 등록")
    public MyResponse<Integer> postCustomer(@RequestBody CustomerPostReq p){
        //RequestBody 타입이 spring타입인지 확인. swagger타입일 수 있음
        return new MyResponse<>("고객이 등록되었습니다.",service.postCustomer(p));
    }
    @GetMapping
    public MyResponse<List<CustomerGetRes>> getCustomerlist(@ParameterObject CustomerGetReq p){
        return new MyResponse<>(p.getPage()+"페이지 데이터",service.getCustomerList(p));
    }
    //MyResponse로 받는 이유: 프론트랑 주고받는 타입을 통일시키려고. 배려임
}
