package com.maju.biz.shoppingmall;

import java.util.List;

import com.maju.biz.golf.vo.TeacherVO;

public interface ShoppingDao {
	   void  insert(GolfproductVo  vo);
	   
	   void  cartInsert(CartVO  vo);
	   void  cartDeleteOne(CartVO  vo);
	   void  cartUpdate(CartVO  vo);
	   void  cartDelete(CartVO  vo);
	   List<CartVO>  cartList(CartVO  vo);
	   
	   void orderInsert(OrderVO  vo);
	   List<OrderVO> orderList(OrderVO  vo);
	   
	   List<OrderdetailVO> orderListdetail(OrderVO  vo);
	   
	   void  delete(GolfproductVo  vo);
	   List<GolfproductVo>  select(GolfproductVo  vo);
	   GolfproductVo  edit(GolfproductVo  vo);  
	   
	   List<TeacherVO> shopTeacherMoney();
}
