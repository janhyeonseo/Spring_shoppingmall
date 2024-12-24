package com.maju.biz.shoppingmall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maju.biz.golf.vo.TeacherVO;

@Service
public class ShoppingServiceImpl implements ShoppingService  {

	@Autowired
	ShoppingDao  dao;
	
	@Override
	public void insert(GolfproductVo vo) {
		dao.insert(vo);
		
	}

	@Override
	public void delete(GolfproductVo vo) {
		dao.delete(vo);
		
	}

	@Override
	public List<GolfproductVo> select(GolfproductVo vo) {
		
		return dao.select(vo);
	}

	@Override
	public GolfproductVo edit(GolfproductVo vo) {
		
		return dao.edit(vo);
	}

	@Override
	public void cartInsert(CartVO vo) {
		dao.cartInsert(vo);
	}

	@Override
	public List<CartVO> cartList(CartVO vo) {
		return dao.cartList(vo);
	}

	@Override
	public void orderInsert(OrderVO vo) {
		dao.orderInsert(vo);		
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {		
		return dao.orderList(vo);
	}

	@Override
	public void cartDelete(CartVO vo) {		
		dao.cartDelete(vo);
	}

	@Override
	public void cartUpdate(CartVO vo) {
		dao.cartUpdate(vo);
		
	}

	@Override
	public void cartDeleteOne(CartVO vo) {
		dao.cartDeleteOne(vo);
		
	}

	@Override
	public List<OrderdetailVO> orderListdetail(OrderVO vo) {

		return dao.orderListdetail(vo);
	}

	@Override
	public List<TeacherVO> shopTeacherMoney() {
		// TODO Auto-generated method stub
		return dao.shopTeacherMoney();
	}

}
