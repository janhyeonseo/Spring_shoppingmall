package com.maju.biz.board;

import java.util.List;

public interface BoardDao {
	
   void  insert(BoardVO  vo);
   void  update(BoardVO  vo);
   void  delete(BoardVO  vo);
   BoardVO  getSelectOne(BoardVO  vo);
   List<BoardVO>  getSelectAll(BoardVO  vo);
   BoardVO  totalCount(String ch1, String Ch2);
   
   void  bigInsert(BoardVO  vo);
   List<BoardVO>  selectTop(BoardVO  vo);
   List<BoardVO>  selectTop2(BoardVO  vo);
}
