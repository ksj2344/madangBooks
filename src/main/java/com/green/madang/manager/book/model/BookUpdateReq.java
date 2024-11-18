package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateReq {
    private String bookName;
    private String publisher;
    private Integer price;
    private int bookId;
    /*
        ※ int price였을 때,
        실제 책 가격을 0으로 수정하고 싶었음. 쿼리스트링에 추가함 price=0
        책 가격을 수정하고 싶지 않았음(현상 유지). 쿼리스트링에 추가 안함 price=0

        ※ Integer price였을 때,
        실제 책 가격을 0으로 수정하고 싶었음. 쿼리스트링에 추가함 price=0
        책 가격을 수정하고 싶지 않았음(현상 유지). 쿼리스트링에 추가 안함 price=null
    */
}
