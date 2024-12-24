package com.maju.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate  mybatis;

	@Override
	public void insert(BoardVO vo) {
		System.out.println("===>mybatis insert(BoardVO vo)");
		mybatis.insert("Board.INSERT", vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		mybatis.update("Board.UPDATE", vo);
		
	}

	@Override
	public void delete(BoardVO vo) {
		mybatis.update("Board.DELETE", vo);
		
	}

	@Override
	public BoardVO getSelectOne(BoardVO vo) {
		return mybatis.selectOne("Board.BoardSelectOne", vo);
	}

	@Override
	public List<BoardVO> getSelectAll(BoardVO  vo) {	
		String SearchKeyword = "";
		if (vo.getSearchKeyword().indexOf("%") == -1) {
			SearchKeyword = vo.getSearchKeyword();
		} else {
			SearchKeyword = "\\" + vo.getSearchKeyword();
		}		
		vo.setSearchCondition(vo.getSearchCondition());
		vo.setSearchKeyword("%" + SearchKeyword +"%");
		return mybatis.selectList("Board.BoardSelect", vo);
	}

	@Override
	public BoardVO totalCount(String ch1, String Ch2) {
		String chStr2 ;
		if (Ch2.indexOf("%") == -1) {
			chStr2  = Ch2;			
		} else {
			chStr2 = "\\" + Ch2;
			System.out.println("% 연산 : "  + chStr2);
		}
		BoardVO vo  =  new BoardVO();
		vo.setSearchCondition(ch1);
		vo.setSearchKeyword("%" + chStr2 +"%");

		return mybatis.selectOne("Board.BoardCount", vo);
	}

	@Override
	public void bigInsert(BoardVO vo) {
		mybatis.insert("Board.bigInsert", vo);
		
	}

	@Override
	public List<BoardVO> selectTop(BoardVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("Board.selectTop", vo);
	}

	@Override
	public List<BoardVO> selectTop2(BoardVO vo) {
		System.out.println("===****>확인:" + vo);
		
		 String keyworld = vo.getSearchKeyword();
		
		 vo.setSearchKeyword("%" +keyworld+ "%");
		 
		// TODO Auto-generated method stub
		return mybatis.selectList("Board.BoardSelect2", vo);
	}  


}
