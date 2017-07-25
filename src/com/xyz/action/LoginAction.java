package com.xyz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzUser;
import com.xyz.service.PersonService;
import com.xyz.service.XyzUserService;

public class LoginAction extends ActionSupport implements ModelDriven<XyzUser>{
	
	private XyzUser user=new XyzUser();
	private XyzUserService userService;
	private PersonService personService;
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public void setUserService(XyzUserService userService) {
		this.userService = userService;
	}

	public String login(){
		List<XyzUser> userList = userService.login(user.getUserName(), user.getUserPassword());
		if(!userList.isEmpty()){
			ServletActionContext.getRequest().getSession().setAttribute("user", userList.get(0));
			List<XyzGoods> goodsList = personService.findCartById(userList.get(0).getUserId());
			ServletActionContext.getRequest().getSession().setAttribute("cart", goodsList);
			return "login";
		}
		else{
			this.addActionError("用户名或密码错误！");
			return "loginfail";
		}
	}
	
	public String register(){
		int x=userService.register(user,user.getUserName());
		if(x==0)
		{
		return "register";}
		else{
			this.addActionError("登录名已存在！");
			return "registerfail";
		}
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "quit";
	}
	
	@Override
	public XyzUser getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String infochange()
	{
		XyzUser user1 = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		user.setUserId(user1.getUserId());
		userService.infochange(user);
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "infochange";
	}
}
