package com.poscodx.mysite.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;

public class BoardActionFactory implements ActionFactory{

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("delete".equals(actionName)) {
			action = new DeleteAction(); // o
		} else if("write".equals(actionName)){
			action = new WriteAction(); // 계층형
		} else if("writeform".equals(actionName)) {
			action = new WriteFormAction(); // o 
		} else if("modify".equals(actionName)){
			action = new ModifyAction(); // o
		} else if("modifyform".equals(actionName)){
			action = new ModifyFormAction(); // o
		} else if("viewform".equals(actionName)){
			action = new ViewFormAction(); // o
		} else {
			action = new ListAction(); // 페이징
		}
		
		return action;
	}
	
}
