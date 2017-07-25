package com.xyz.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.xyz.action.LoginAction;
import com.xyz.action.XyzCartAction;
import com.xyz.domain.XyzUser;

public class loginInterceptor extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		XyzUser user=(XyzUser)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(!(user==null)){
			System.out.println("interceptor!!!!");
			LoginAction action =(LoginAction)invocation.getAction();
			action.addActionError("已经登录，请注销后再登录！");
			return "loginalready";
		}
		return invocation.invoke();
}
}
