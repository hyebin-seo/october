package com.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAO;
import com.member.model.MemberDTO;

public class MemberListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse res) {
		// member ���̺��� ȸ�� ��ü ����Ʈ�� ��ȸ�Ͽ� view page�� �̵���Ű�� �۾�
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberDTO> list = dao.getMemberList();
		
		request.setAttribute("list", list);
		
		//�̵��� �������� �ּҰ� ����
		return "view/member_list.jsp";
	}

}
