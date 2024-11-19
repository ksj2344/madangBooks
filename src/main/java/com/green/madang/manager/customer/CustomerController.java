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
    @Operation(summary = "고객 열람")
    //@ParameterObject - Swagger용 에노테이션. RequestParam으로 설정했을 때 나오는 FORM처럼 된다.
    public MyResponse<List<CustomerGetRes>> getCustomerlist(@ParameterObject CustomerGetReq p){
        log.info("get-req: {}",p);
        return new MyResponse<>(p.getPage()+"페이지 데이터",service.getCustomerList(p));
    }

    //@ModelAttribute는 null값을 제한할 수 있는게 없지만 @RequestParam은 required = true를 통해 제한 할 수 있음(에러날 수 있음)

    //RequestParam을 이용한 GetMapping
    @GetMapping("/param")
    @Operation(summary = "고객열람2")  //String이나 int 같은 타입의 변수 앞에만 @RequestParam 붙일 수 도있다
    public MyResponse<List<CustomerGetRes>> getCustomerlist2(@RequestParam int page
                                                            , @RequestParam int size
                                                            , @RequestParam(name="search_type", required = false) String searchType
                                                            , @RequestParam(name="search_text", required = false) String searchText)
    {
        CustomerGetReq p = new CustomerGetReq(page, size, searchType, searchText);
        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.getCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    @PutMapping
    @Operation(summary = "고객 수정")
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq p){
        return new MyResponse<>(p.getCustId()+"번 고객 수정",service.putCustomer(p));
    }

    @DeleteMapping
    @Operation(summary = "고객삭제")
    public MyResponse<Integer> delCustomer(@ParameterObject CustomerDelete p){  //@ModelAttribute 쓸 때는 쿼리스트링으로 받음.
        return new MyResponse<>(p.getCustId()+"번 고객 삭제",service.delCustomer(p));
    }
    //MyResponse로 받는 이유: 프론트랑 주고받는 타입을 통일시키려고. 배려임
}
