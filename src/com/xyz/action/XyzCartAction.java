package com.xyz.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyz.domain.XyzCart;
import com.xyz.domain.XyzGoods;
import com.xyz.domain.XyzOrder;
import com.xyz.domain.XyzUser;
import com.xyz.service.PersonService;
import com.xyz.service.XyzCartService;
import com.xyz.service.XyzGoodsService;
import com.xyz.service.XyzOrderService;

public class XyzCartAction extends ActionSupport implements ModelDriven<XyzOrder>{

	private XyzOrder order = new XyzOrder();
	private XyzCartService cartService;
	private XyzGoodsService goodsService;
	private PersonService personService;
	private XyzOrderService orderService;
	private int goodsId;

	public void setGoodsService(XyzGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setOrderService(XyzOrderService orderService) {
		this.orderService = orderService;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setCartService(XyzCartService cartService) {
		this.cartService = cartService;
	}
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String addToCartByCart(){
		XyzCart cart = new XyzCart();
		cartService.add(cart);
		List<XyzGoods> goodsList = personService.findCartById(cart.getXyzUser().getUserId());
		ServletActionContext.getRequest().getSession().setAttribute("cart", goodsList);
		return "addtocartbycart";
	}
	
	public String addToCartByUserAndGoods(){
		XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		int x=cartService.check(user.getUserId(), goodsId);
		
		if(x==0){
		cartService.add(user.getUserId(),goodsId);
		
		ServletActionContext.getRequest().setAttribute("addtocart", "success");
		List<XyzGoods> goodsList = personService.findCartById(user.getUserId());
		ServletActionContext.getRequest().getSession().setAttribute("cart", goodsList);
		return "addtocartbyuserandgoods";}
		else{
			ServletActionContext.getRequest().setAttribute("addtocart", "false");
			
			return "addtocartbyuserandgoodsfail";
		}
	}
	
	public String deleteFromCart(){
		
		return "deletefromcart";
	}
	
	public String buyNowById(){
		XyzUser user = (XyzUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		XyzOrder order1 = new XyzOrder(goodsService.findGoodsById(goodsId).get(0), goodsService.findSeller(goodsId),user, new Date(), 1,1, order.getOrderAddress(), order.getOrderCelphone());
		orderService.add(order1);
		List<XyzGoods> goodsList = personService.findCartById(user.getUserId());
		ServletActionContext.getRequest().getSession().setAttribute("cart", goodsList);
		return SUCCESS;
		
	}

	@Override
	public XyzOrder getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
}
