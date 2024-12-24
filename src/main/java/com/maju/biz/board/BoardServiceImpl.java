package com.maju.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao  dao ;
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);		
	}

	@Override
	public BoardVO getSelectOne(BoardVO vo) {
		return dao.getSelectOne(vo);
	}

	@Override
	public List<BoardVO> getSelectAll(BoardVO  vo) {
		return dao.getSelectAll(vo);
	}

	@Override
	public BoardVO totalCount(String ch1, String Ch2) {

		return dao.totalCount(ch1, Ch2);
	}

	@Override
	public void bigInsert(BoardVO vo) {
		dao.bigInsert(vo);
		
	}

	@Override
	public List<BoardVO> selectTop(BoardVO vo) {
		return dao.selectTop(vo);
	}

	@Override
	public List<BoardVO> selectTop2(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.selectTop2(vo);
	}

}
