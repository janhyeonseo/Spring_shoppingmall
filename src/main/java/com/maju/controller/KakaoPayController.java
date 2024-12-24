package com.maju.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class KakaoPayController {
	private static final long serialVersionUID = 1L;
    private static final String KAKAO_API_KEY = "5832b3c34f0547288c5570bd08ec4454";  //  발급받은 Admin 키
    private static final String CID = "TC0ONETIME"; // 테스트 CID
    
	@PostMapping(value="PaymentServlet.do")
	  String PaymentServlet(HttpServletRequest request) throws Exception { 
		
		// String path = request.getContextPath();
        String path = "http://localhost:8888/biz";   // 필히 문자열로 넘겨주어야 한다.  (중요)
		
        String apiUrl = "https://kapi.kakao.com/v1/payment/ready";
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "KakaoAK " + KAKAO_API_KEY);
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        conn.setDoOutput(true);
        
        System.out.println("conn:" + conn);
        
        String Ordercode = UUID.randomUUID().toString();
        String order_id =Ordercode.substring(1, 7);
        
        String partner_order_id=order_id;
        String partner_user_id=request.getParameter("mid");
        String total_amount=request.getParameter("total_amount");
        
        String item_name ="임시상품";
        String quantity ="00";
        
        System.out.println("partner_order_id:" + partner_order_id );
        System.out.println("partner_user_id:" + partner_user_id );
        System.out.println("total_amount:" + total_amount );
   
        
        request.getSession().setAttribute("partner_order_id", partner_order_id);
        request.getSession().setAttribute("partner_user_id", partner_user_id);
        request.getSession().setAttribute("total_amount", total_amount);
        
        String params = "cid=" + CID +
                        "&partner_order_id="+ partner_order_id  +       //  order_id (상품 id)
                        "&partner_user_id=" + partner_user_id +    //  user_id  (사용자 id)
                        "&item_name="+ item_name +            //  item_name ( 상품명 ) 
                        "&quantity="+ quantity +                  //  quantity ( 수량 )
                        "&total_amount=" + total_amount +    //  total_amount ( 가격 )
                        "&vat_amount=1" +                //  vat_amount ( 부가가치세 : 세금 )
                        "&tax_free_amount=0" +           //  tax_free_amount ( 면세 )
                        "&approval_url=" + path + "/ApproveServlet.do" +
                        "&cancel_url=" + path + "/cancel" +
                        "&fail_url="+ path +"/fail";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = params.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        Scanner sc;
        if (code == 200) {
            sc = new Scanner(conn.getInputStream());
            System.out.println("conn1:" + sc);
        } else {
            sc = new Scanner(conn.getErrorStream());
            System.out.println("conn2:" + sc);
        }
        
        StringBuilder result = new StringBuilder();
        while (sc.hasNext()) {
            result.append(sc.nextLine());
        }
        System.out.println("result:" + result);
        sc.close();
        
        // JSON 파싱 후, next_redirect_pc_url 값으로 리다이렉트
        
        // tid 는 결제 준비 단계에서 카카오페이로 부터 받은 거래 고유 번호 이다. 
        // 이 tid 는 결제 승인 단계에서 필수로 사용되며 세션 또는 다늘 방법으로 관리해야 한다. 
        // 준비 단계에서 받은 tid를 결제 승인 요청 시 함께 전송하여 결제를 완료 해 야 한다. 
        String tid = result.toString().split("\"tid\":\"")[1].split("\"")[0];
        
        // 방법1.
        request.getSession().setAttribute("tid", tid);
        
        // 방법2.
        // HttpSession session = request.getSession();
        // session.setAttribute("tid", tid);
        
        String redirectUrl = result.toString().split("\"next_redirect_pc_url\":\"")[1].split("\"")[0];
        System.out.println("===>redirectUrl 확인:" + redirectUrl);
        		


     return "redirect:"+ redirectUrl;	
        
	}   
    
	@GetMapping(value="ApproveServlet.do")
	  String ApproveServlet(HttpServletRequest request, HttpServletResponse response) throws Exception { 
   
				
			String path = request.getContextPath();
			System.out.println("===> ApproveServlet 넘어옴 !!" );
			
	        String pgToken = request.getParameter("pg_token");
	        
	        String tid = (String) request.getSession().getAttribute("tid");
	        String partner_order_id = (String) request.getSession().getAttribute("partner_order_id");
	        String partner_user_id = (String) request.getSession().getAttribute("partner_user_id");
	        
	        System.out.println("===> ApproveServlet pgToken 확인" +  pgToken);
	        System.out.println("===> ApproveServlet tid 확인:" + tid );
	        
	        
	        String apiUrl = "https://kapi.kakao.com/v1/payment/approve";
	        URL url = new URL(apiUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "KakaoAK " + KAKAO_API_KEY);
	        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setDoOutput(true);

	        System.out.println("===>ApproveServlet conn 확인: " + conn );
	        
	        String params = "cid=" + CID +
	                        "&tid=" + tid +
	                        "&partner_order_id=" + partner_order_id +
	                        "&partner_user_id=" + partner_user_id +
	                        "&pg_token=" + pgToken;

	        try (OutputStream os = conn.getOutputStream()) {
	            byte[] input = params.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }

	        int code = conn.getResponseCode();
	        Scanner sc;
	        if (code == 200) {
	            sc = new Scanner(conn.getInputStream());
	            System.out.println("===>ApproveServlet sc 성공 확인: " + sc );
	        } else {
	            sc = new Scanner(conn.getErrorStream());
	            System.out.println("===>ApproveServlet sc 실패 확인: " + sc );
	        }
	        
	        StringBuilder result = new StringBuilder();
	        while (sc.hasNext()) {
	            result.append(sc.nextLine());
	        }
	        

	        System.out.println("===>ApproveServlet result 확인: " + result );
	        
	        System.out.println("===>partner_order_id 확인: " + request.getSession().getAttribute("partner_order_id")  );
	        System.out.println("===>partner_user_id 확인: " + request.getSession().getAttribute("partner_user_id") );
	        System.out.println("===>total_amount 확인: " + request.getSession().getAttribute("total_amount") );
	        
	        sc.close();
	        
	        response.setContentType("application/json;charset=UTF-8");
	        response.getWriter().print(result.toString());

	       
	 return "redirect:orderInsert.do" ;		
	}
	
	
	
}
