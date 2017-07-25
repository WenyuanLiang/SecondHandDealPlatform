package com.xyz.interceptor;

import org.apache.struts2.ServletActionContext;





import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.xyz.action.PersonAction;
import com.xyz.action.XyzCartAction;
import com.xyz.domain.XyzUser;

public class showInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		XyzUser user=(XyzUser)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user==null){
			System.out.println("interceptor!!!!");
			PersonAction action =(PersonAction)invocation.getAction();
			action.addActionError("权限不足，请先登录");
			return "loginfirst";
		}
		return invocation.invoke();
	}
		
}
