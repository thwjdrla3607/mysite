package com.poscodx.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if() {
			WebUtil.forward("board/write", request, response);
		}
		else {
			request
			.getRequestDispatcher("/WEB-INF/views/" + path + ".jsp")
			.forward(request, response);
		}
		
	}

}
