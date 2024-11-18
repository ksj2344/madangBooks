package com.green.madang.manager.book.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetReq {
    @Schema(description = "선택된 페이지값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page; //실제 받는값
    @Schema(description="한 페이지마다 보여질 아이템 수", example ="30", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size; //실제 받는값
    @Schema(description = "도서 제목에서 검색을 한다.", example = "검색 텍스트", requiredMode = Schema.RequiredMode.REQUIRED)
    private String searchText;

    @JsonIgnore //Swagger문서에서 이 멤버필드는 안나오게 하기
    private int startIdx; //(page -1)*size
}
