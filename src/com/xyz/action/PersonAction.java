package com.xyz.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyz.service.PersonService;
import com.xyz.service.XyzGoodsService;
import com.xyz.service.XyzOrderService;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzCartId;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzOrder;
import com.xyz.domain.XyzType;
import com.xyz.domain.XyzUser;

public class PersonAction extends ActionSupport implements ModelDriven<XyzGoods>{
	private PersonService personService;
	private XyzGoodsService goodsService;
	private XyzOrderService orderService;
	public XyzOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(XyzOrderService orderService) {
		this.orderService = orderService;
	}
	private String address;
	private String celphone;
	private XyzGoods mygoods = new XyzGoods();
	public String findUserById(int userid) {
	XyzUser user = personService.findUserById(userid);
	ServletActionContext.getRequest().setAttribute("user",user);

	return "loaded";
	}
	public String showMyCart() {
		XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<XyzGoods> list = personService.findCartById(user.getUserId());
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setAttribute("goodslist", list);
		request.setAttribute("title", "我的购物车");
		request.setAttribute("load", "loaded");
		return "showMyCartloaded";
		}
public String showMyGoods() {
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		List<XyzGoods> list = personService.findGoodsById(user.getUserId());
		HttpServletRequest request =ServletActionContext.getRequest();
		request.setAttribute("goodslist", list);
		request.setAttribute("title", "我的商品");

		return "showMyGoodsloaded";
		}
public String showMyBought() {
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
	List<XyzGoods> list = personService.findBoughtById(user.getUserId());
	HttpServletRequest request =ServletActionContext.getRequest();
	request.setAttribute("goodslist", list);
	request.setAttribute("title", "我的购物记录");

	return "showMyBoughtloaded";
	}
public String showMySold() {
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
	List<XyzGoods> list = personService.findSoldById(user.getUserId());
	HttpServletRequest request =ServletActionContext.getRequest();
	request.setAttribute("goodslist", list);
	request.setAttribute("title", "我的出售记录");

	return "showMySoldloaded";
	}	
public String deleteMyGoods() {
	personService.deleteGoodsById(mygoods.getGoodsId());
	return "mygoodsdeleted";
	}
public String addMyGoods() {
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
	mygoods.setXyzUser(personService.findUserById(user.getUserId()));
	XyzType type = new XyzType();
	type.setTypeName("家居日用");
	mygoods.setXyzType(type);
	personService.addgoods(mygoods);
	return "mygoodsadded";
	}
public String deleteMyCart() {
	XyzCart cart = new XyzCart();
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
	List<XyzGoods> templist = goodsService.findGoodsById(mygoods.getGoodsId());
	XyzGoods goods = templist.get(0);
	XyzCartId cartId = new XyzCartId();
	cartId.setCartBuyerId(user.getUserId());
	cartId.setCartGoodsId(goods.getGoodsId());
	cart.setId(cartId);
	cart.setXyzGoods(goods);
	cart.setXyzUser(user);
	personService.deleteCart(cart);
	List<XyzGoods> goodsList = personService.findCartById(user.getUserId());
	ServletActionContext.getRequest().getSession().setAttribute("cart", goodsList);
	return "mycartdeleted";
	}

public String checkout() {
	XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
	List<XyzGoods> list = personService.findCartById(user.getUserId());
	int I=0;
	
	while(I<list.size())
	{
		personService.deleteGoodsById(list.get(I).getGoodsId());
		XyzOrder order = new XyzOrder();
		order.setOrderAddress(address);
		order.setOrderCelphone(celphone);
		order.setOrderIscomplete(1);
		order.setOrderShow(1);
		order.setXyzGoods(list.get(I));
		order.setXyzUserByOrderBuyerId(user);
		order.setXyzUserByOrderSellerId(list.get(I).getXyzUser());
		Date ordertime = new Date();
		order.setOrderTime(ordertime);
		orderService.add(order);
		I++;
	}
	List<XyzGoods> list1 = personService.findCartById(user.getUserId());
	ServletActionContext.getRequest().getSession().setAttribute("cart", list1);
	return "checkedout";
	}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCelphone() {
	return celphone;
}
public void setCelphone(String celphone) {
	this.celphone = celphone;
}
public XyzGoodsService getGoodsService() {
	return goodsService;
}
public void setGoodsService(XyzGoodsService goodsService) {
	this.goodsService = goodsService;
}


public void setPersonService(PersonService personService) {
	this.personService = personService;
}
@Override
public XyzGoods getModel() {
	
	return mygoods;
}	
}
