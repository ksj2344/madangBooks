package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j //SpringLog4j, system.out 대용품
@RestController
@RequestMapping("manager/book")
@RequiredArgsConstructor //final이 붙은 멤버필드만 생성자 만들어줌.
@Tag(name="도서", description="도서 API")  // Swagger 카테고리 변경 에노테이션
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서입고", description = "도서입고처리 API")
    public MyResponse<Integer> postBook(@RequestBody BookPostReq p){
        log.info("BookPostReq : {}",p); //@Slf4j 정보출력, 출력상 { }로 변수 넣기 가능
//        log.warn("warn"); //@Slf4j 경고출력
//        log.error("error"); //@Slf4j 에러출력

        int result=service.postBook(p);
        MyResponse<Integer> response=new MyResponse<>("책 등록 완료",result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서리스트", description = "도서정보 리스트보기 API")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p){ //@ParameterObject swagger 파라미터 편하게 기입하게 하기
        List<BookGetRes> list = service.getBooklist(p);
        return new MyResponse<>(p.getPage()+"페이지 데이터",list);
    }

    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> putBook(@RequestBody BookUpdateReq p){
        return  new MyResponse<>(p.getBookId()+"번 도서 수정",service.putBook(p));
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> delBook(@ParameterObject @ModelAttribute BookDelete p){
        return new MyResponse<>(p.getBookId()+"번 도서 삭제",service.delBook(p));
    }
}
