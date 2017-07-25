package com.xyz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyz.domain.XyzCollection;
import com.xyz.domain.XyzGoods;
import com.xyz.service.XyzGoodsService;
import com.xyz.service.XyzUserService;

public class XyzGoodsAction extends ActionSupport implements ModelDriven<XyzGoods>{
	private XyzGoods goods = new XyzGoods();
	private XyzGoodsService goodsService;
	private XyzUserService userService;
	private String goodsType;
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserService(XyzUserService userService) {
		this.userService = userService;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setGoodsService(XyzGoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	public String findGoodsById(){
		List<XyzGoods> goodsList = goodsService.findGoodsById(goods.getGoodsId());
		ServletActionContext.getRequest().setAttribute("goodsList", goodsList);
		
		List<XyzGoods> allGoodsList = goodsService.findAllGoods();
		ServletActionContext.getRequest().setAttribute("allGoodsList", allGoodsList);
		
		List<XyzGoods> sellerGoodsList = goodsService.findSellerGoodsById(goods.getGoodsId());
		ServletActionContext.getRequest().setAttribute("sellerGoodsList", sellerGoodsList);
		
		return "goodsbyidfound";
	}
	
	public String findGoodsByName(){
		List<XyzGoods> goodsList = goodsService.findGoodsByName(goods.getGoodsName());
		ServletActionContext.getRequest().setAttribute("goodsList", goodsList);
		return "findgoodsbyname";
	}
	
	public String findAllGoods(){
		List<XyzGoods> goodsList = goodsService.findAllGoods();
		ServletActionContext.getRequest().setAttribute("goodsList", goodsList);
		return "findallgoods";
	}
	
	public String findGoodsByType(){
		String type= new String();
		if("1".equals(goodsType)){
			type="母婴用品";
		}else if("2".equals(goodsType)){
			type="影音家电";
		}else if("3".equals(goodsType)){
			type="家居日用";
		}
		else if("4".equals(goodsType)){
			type="闲置数码";
		}
		else if("5".equals(goodsType)){
			type="图书资料";
		}
		else if("6".equals(goodsType)){
			type="动漫周边";
		}
		else if("7".equals(goodsType)){
			type="珠宝收藏";
		}
		else if("8".equals(goodsType)){
			type="鞋服配饰";
		}
		List<XyzGoods> goodsList = goodsService.findGoodsByType(type);
		ServletActionContext.getRequest().setAttribute("goodsList", goodsList);
		return "findgoodsbytype";
	}
	
	public String findCollection(){
		XyzCollection[]  collection = new XyzCollection[3];
		collection[0]=new XyzCollection(1,userService.findUserById(1).getUserName(),goodsService.findGoodsByUser(1).get(0).getGoodsPicture1());
		collection[1]=new XyzCollection(2,userService.findUserById(2).getUserName(),goodsService.findGoodsByUser(2).get(0).getGoodsPicture1());
		collection[2]=new XyzCollection(3,userService.findUserById(3).getUserName(),goodsService.findGoodsByUser(3).get(0).getGoodsPicture1());
		ServletActionContext.getRequest().setAttribute("collection1", collection[0]);
		ServletActionContext.getRequest().setAttribute("collection2", collection[1]);
		ServletActionContext.getRequest().setAttribute("collection3", collection[2]);
		return "findcollection";
	}
	
	public String findGoodsByUser(){
		List<XyzGoods> goodsList = goodsService.findGoodsByUser(userId);
		ServletActionContext.getRequest().setAttribute("goodsList", goodsList);
		return "findgoodsbyuser";
	}
	
	@Override
	public XyzGoods getModel() {
		// TODO Auto-generated method stub
		return goods;
	}

}
