package com.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.ProductDAO;
import com.product.model.ProductDTO;


@WebServlet("/content.do")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식으로 받은 제품번호에 해당하는 제품 정보를 조회하는 작업.
		int product_num =
			Integer.parseInt(request.getParameter("num"));
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO dto = dao.getContentProduct(product_num);
		
		request.setAttribute("cont", dto);
		
		RequestDispatcher rd = 
			request.getRequestDispatcher("view/product_content.jsp");
		
		rd.forward(request, response);
		
		
	}

}
