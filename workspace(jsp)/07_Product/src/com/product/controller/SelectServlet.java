package com.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.ProductDAO;
import com.product.model.ProductDTO;


@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// products 테이블의 전체 제품 목록을 조회하여
		// view page로 이동시켜서 웹 브라우저에 보여주는 작업
		ProductDAO dao = ProductDAO.getInstance();
		
		// 전체 리스트를 가져오는 메서드 호출
		List<ProductDTO> productList = dao.getProductList();
		
		// view page로 해당 데이터를 이동시켜야 함.
		request.setAttribute("List", productList);
		
		RequestDispatcher rd = 
			request.getRequestDispatcher("view/product_list.jsp");
		
		rd.forward(request, response);
		
	}

}
