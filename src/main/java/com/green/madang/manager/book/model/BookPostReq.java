package com.green.madang.manager.book.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString //@Slf4j로 출력하려고 에노테이션 붙임
public class BookPostReq {
    //FE가 PK값을 정할 일은 없기 때문에, bookid에 AUTO_INCREMENT 되어있지 않더라도 bookid 멤버필드는 필요없음.
    @Schema(title="도서이름", description = "책의 타이틀",requiredMode = Schema.RequiredMode.REQUIRED) //  Schema.RequiredMode.REQUIRED 필수값
    private String bookName;
    @Schema(title="출판사이름", example = "한빛 출판사", requiredMode = Schema.RequiredMode.REQUIRED)
    private String publisher;
    @Schema(title = "도서 가격", example = "12000", requiredMode = Schema.RequiredMode.REQUIRED)
    private int price;
}
