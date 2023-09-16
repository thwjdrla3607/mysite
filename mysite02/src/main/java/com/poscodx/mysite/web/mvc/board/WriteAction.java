package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class WriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String no = request.getParameter("no");
		BoardVo vo = null;
				
		if (no == null) { // 게시글 작성
			int maxGroupNo = new BoardDao().findMaxGroupNo();			
			vo = new BoardVo(maxGroupNo + 1, 1, 1);
			vo.setUserNo(authUser.getNo().intValue());
		} else { // 게시글 답글
			vo = new BoardDao().findByNo(Integer.parseInt(no));			
			vo.setHit(0);
			vo.setOrderNo(vo.getOrderNo() + 1);
			vo.setDepth(vo.getDepth() + 1);
			vo.setUserNo(authUser.getNo().intValue());
			
			new BoardDao().updateOrderNo(no);
		}

		vo.setTitle(title);
		vo.setContents(contents);
		new BoardDao().insert(vo);
		
		response.sendRedirect(request.getContextPath() + "/board?pageNo=1");
	}
}
