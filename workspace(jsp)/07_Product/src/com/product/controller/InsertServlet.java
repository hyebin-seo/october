package com.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.CategoryDAO;
import com.product.model.CategoryDTO;


@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 카테고리 리스트를 조회하여 제품 등록 폼 페이지로 이동시키는 작업.
		CategoryDAO dao = CategoryDAO.getInstance();
		
		// 카테고리 전체 리스트를 가져오는 메서드 호출
		List<CategoryDTO> categoryList = dao.getCategoryList();
		
		request.setAttribute("List", categoryList);
		
		RequestDispatcher rd =
			request.getRequestDispatcher("view/product_write.jsp");
		
		rd.forward(request, response);
	}

}
