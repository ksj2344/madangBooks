package com.green.madang.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//응답할 때 사용하는 객체
@Getter
@Setter
@AllArgsConstructor //모든 멤버필드를 초기화 할 수 있는 생성자 부여(static제외, 어차피 필요없음)
public class MyResponse<T> {
    private String resultMessage;
    private T resultData;
}

// Mybatis Binding exeption 오류
// 1. yami에 mapper 기입 오타났거나 경로상 오타났거나
// 2. mapper.xml에서 namespace 혹은 id에서 오류 났거나