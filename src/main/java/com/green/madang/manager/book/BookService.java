package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈등록, spring이 객체생성해줌.
@RequiredArgsConstructor
public class BookService {
    private final BookMapper mapper;

    public int postBook(BookPostReq p){
        return mapper.insBook(p);
    }

    public List<BookGetRes> getBooklist(BookGetReq p){
        //sIdx값 세팅
//        int page=p.getPage();
//        int size=p.getSize();
//        int sIdx=(page-1)*size;
//        p.setStartIdx(sIdx);
        p.setStartIdx((p.getPage()-1)*p.getSize());
        return mapper.selBooklist(p);
    }

    public int putBook(BookUpdateReq p){
        return mapper.updBook(p);
    }

    public int delBook(BookDelete p){
        return mapper.delBook(p);
    }
}
