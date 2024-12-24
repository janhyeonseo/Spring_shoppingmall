package com.maju.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.maju.biz.shoppingmall.CartVO;
import com.maju.biz.shoppingmall.GolfproductVo;
import com.maju.biz.shoppingmall.OrderVO;
import com.maju.biz.shoppingmall.OrderdetailVO;
import com.maju.biz.shoppingmall.ShoppingService;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Controller
public class ShoppingmallController {

	@Autowired
	ShoppingService  service;
	
	@Autowired
	HttpSession  session;
	
	@GetMapping(value="shoppingmall.do")
	String shoppingmall() { 
		System.out.println("===> 수정 shoppingmall.do ");
	return "shoppingmall/shoppingmall";		
	}

	@GetMapping(value="shoppingInsert.do")
	String shoppingInsert() { 
		System.out.println("===> 수정 shoppingInsert.do ");
	return "shoppingmall/shoppinInsert";		
	}	
	
	@PostMapping(value="shoppingInsertOK.do")
	String shoppinInsertOK(HttpServletRequest request, GolfproductVo vo) throws Exception, IOException { 
		System.out.println("===> 수정 shoppinInsertOK.do ");
				
		// 자료실 처리 순서  ( 테이블 처리 / 파일처리 ) 
		// 1. Insert  --> 2. Select --> 3. Delete  --> 4. Edit  --> 5. Update
		
		String path = request.getSession().getServletContext().getRealPath("/shoppingmall/img/");
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		String k = sdf.format(now);
	
		int ran=(int)(Math.random()*100)+101 ;
		
		System.out.println("==> path : " + path );
		MultipartFile uploadFile =vo.getPimg();
		String  fileName = uploadFile.getOriginalFilename();
			
		File f = new File(path+fileName);
		String img = "";
		if (!uploadFile.isEmpty()) {
			if (f.exists()) {
				int lastIndex = fileName.lastIndexOf('.');
				String extension = fileName.substring(lastIndex);
			    img = "img" + k + ran + extension;
			} else {
			   img = fileName;
			}
			
			uploadFile.transferTo(new File(path + img));
			
		} else {
			 img = "space.png";
		}
		        
		vo.setPimgStr(img);
		service.insert(vo);
		
	return "shoppingmall/shoppingmall";		
	}	
	
	@GetMapping(value="shoppingSelect.do")
	String shoppinSelect(Model  model) { 
		System.out.println("===> shoppinSelect.do ");
		model.addAttribute("li", service.select(null));
		
	return "shoppingmall/shoppselect";		
	}	
	
	@GetMapping(value="shoppingEdit.do")
	String shoppingEdit(Model  model , GolfproductVo vo ) { 
		System.out.println("===> shoppingEdit.do ");
		model.addAttribute("m", service.edit(vo));
		
	return "shoppingmall/shoppedit";		
	}	
	
	
		@PostMapping(value="shoppingCart.do")
		String shoppinCart(Model  model , CartVO vo ) { 
			String mid = (String) session.getAttribute("id");
			
			System.out.println("===> shoppinCart.do ");
			vo.setMid(mid);
			service.cartInsert(vo);
		return "redirect:cartList.do?mid="+vo.getMid();		
		}	
	
		@GetMapping(value="cartList.do")
		String cartList(Model  model , CartVO vo ) { 
			
			System.out.println("===> cartList.do (mid) : " + session.getAttribute("id"));
			vo.setMid((String)session.getAttribute("id"));
			model.addAttribute("li", service.cartList(vo));

		return "/shoppingmall/cartList";		
		}	
			
		@GetMapping(value="cartDeleteOne.do")
		String cartDeleteOne( CartVO vo ) { 
			
		    service.cartDeleteOne(vo);
		    
			String mid = (String) session.getAttribute("id");
		
		return "redirect:cartList.do?mid="+mid;	
		}
		
		
		@GetMapping(value="orderInsert.do")
		String orderInsert(Model  model , CartVO  vo  ) { 
						
			vo.setMid((String)session.getAttribute("partner_user_id"));
			String partner_order_id =(String) session.getAttribute("partner_order_id");
					
			OrderVO ovo = new OrderVO();		
			for (CartVO m : service.cartList(vo)) {
				ovo.setOrderG(partner_order_id);
				ovo.setCart_id(String.valueOf(m.getCart_id()));
				ovo.setMid(m.getMid());
				ovo.setPid(m.getPid());
				ovo.setAmount(m.getAmount());
				System.out.println("===> orderInsert.do : " +ovo);
				
				service.orderInsert(ovo);
			}
		
			CartVO m = new CartVO();
			m.setMid((String)session.getAttribute("id"));
			service.cartDelete(m);
		
			return "redirect:orderList.do";
			
		}	
		
		@GetMapping(value="orderList.do")
		String orderList(Model  model , OrderVO vo ) { 
			
			model.addAttribute("li", service.orderList(vo));
			
		return "/shoppingmall/orderList";		
		}	
				
		@GetMapping(value="orderListDetail.do")
		String orderListDetail(Model  model , OrderVO vo ) { 
			
			List<OrderdetailVO> mm = service.orderListdetail(vo);
				 
			 model.addAttribute("name", mm.get(0).getTeacher_name());
			 model.addAttribute("code", mm.get(0).getTeacher_code());
			 model.addAttribute("className",  mm.get(0).getClass_name());
			 
			model.addAttribute("li", service.orderListdetail(vo));
			
		return "/shoppingmall/orderListDetail";		
		}	
		
		
		@PostMapping(value="cartUpdate.do" )
		String cartUpdate(String [] cart_id ,  int [] amount , CartVO vo) { 
		  System.out.println("==> cartUpdate.do : " + cart_id[0] + amount[0]);	
		  for (int i=0 ; i < cart_id.length ; i++) {
			  vo.setCart_id(Integer.parseInt(cart_id[i]));
			  vo.setAmount(amount[i]);
			  
			  service.cartUpdate(vo);			  
		  }	
			
		return "redirect:cartList.do";		
		}
		
		@GetMapping(value="shopTeacherMoney.do")
		String shopTeacherMoney(Model  model) { 
						 
			model.addAttribute("li", service.shopTeacherMoney());
			
		return "/shoppingmall/shopTeacherMoney";		
		}	
		
		
}
