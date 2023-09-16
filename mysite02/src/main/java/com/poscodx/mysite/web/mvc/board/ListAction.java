package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ListAction implements Action{
	static int postCntPerPage = 8;
	static int pagingCnt = 5;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int curPageNo = Integer.parseInt(request.getParameter("pageNo"));
		int maxPageNo = new BoardDao().getTotalPostNo() / postCntPerPage + 1;
		int startPostNo = (curPageNo - 1) * postCntPerPage;
		PageInfo pageInfo = new PageInfo(curPageNo, maxPageNo, pagingCnt);
		List<BoardVo> list = new BoardDao().findCurPost(startPostNo, postCntPerPage);
		
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", pageInfo);
		WebUtil.forward("board/list", request, response);
	}
	
	// 게시글 띄움
	// 페이징
}
