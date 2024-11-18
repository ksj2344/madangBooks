package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerGetReq {
    @Schema(description="몇번째 페이지", example = "1",requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;
    @Schema(description="몇개씩 보기", example = "15",requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;
    @Schema(description="검색어", example = "ani")
    private String searchText;
    @Schema(description="검색타입: name, address,phone 중 한 값을 보낸다. default:name ", example = "name")
    private String searchType;
    @JsonIgnore
    private int startIdx; //(page-1)*size
}
