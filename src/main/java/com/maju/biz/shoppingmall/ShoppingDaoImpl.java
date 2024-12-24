package com.maju.biz.shoppingmall;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maju.biz.golf.vo.TeacherVO;

@Repository
public class ShoppingDaoImpl implements ShoppingDao{
	
	@Autowired
	private SqlSessionTemplate  mybatis;
	
	@Override
	public void insert(GolfproductVo vo) {
		
		System.out.println("==> insert(GolfproductVo vo) :" + vo);
		mybatis.insert("SHOPPING.GolfproductInsert", vo);
		
	}

	@Override
	public void delete(GolfproductVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GolfproductVo> select(GolfproductVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("SHOPPING.Select");
	}

	@Override
	public GolfproductVo edit(GolfproductVo vo) {
		return mybatis.selectOne("SHOPPING.SelectOne", vo);
	}

	@Override
	public void cartInsert(CartVO vo) {
		System.out.println("cartInsert(CartVO vo) vo :" + vo);
		
		mybatis.insert("SHOPPING.cartInsert", vo);
		
	}

	@Override
	public List<CartVO> cartList(CartVO vo) {
		
		return mybatis.selectList("SHOPPING.cartList", vo);
	}

	@Override
	public void orderInsert(OrderVO vo) {
		mybatis.insert("SHOPPING.orderInsert", vo);
		
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		
		return mybatis.selectList("SHOPPING.orderList", vo);
	}

	@Override
	public void cartDelete(CartVO vo) {
		mybatis.delete("SHOPPING.cartDelete", vo);		
	}

	@Override
	public void cartUpdate(CartVO vo) {
		mybatis.update("SHOPPING.cartUpdate", vo);		
	}

	@Override
	public void cartDeleteOne(CartVO vo) {
		mybatis.delete("SHOPPING.cartDeleteOne", vo);		
		
	}

	@Override
	public List<OrderdetailVO> orderListdetail(OrderVO vo) {
		System.out.println("===> vo.getOrderG():"+ vo.getOrderG());
		return mybatis.selectList("SHOPPING.orderListdetail", vo);
	}

	@Override
	public List<TeacherVO> shopTeacherMoney() {
		// TODO Auto-generated method stub
		return mybatis.selectList("SHOPPING.shopTeacherMoney");
	}

}
