<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>上架新商品</title>

<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Old+Standard+TT:400,400italic' rel='stylesheet' type='text/css'>


<!-- font awesome -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />


<!-- animate.css -->
<link rel="stylesheet" href="assets/animate.css" />



<!-- Owl Carousel Assets -->
<link href="assets/owl-carousel/owl.carousel.css" rel="stylesheet">

<link  href="assets/style.css" rel="stylesheet">

<!-- favicon -->
<link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
<link rel="icon" href="images/favicon.png" type="image/x-icon">


</head>

<body id="home">






<div class="header">
<nav class="navbar  navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <h1><a class="navbar-brand logo" href="index.jsp">夏衣族旧货市场</a></h1>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav">        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="goodsSearchByType?goodsType=1">母婴用品</a></li>
            <li><a href="goodsSearchByType?goodsType=2">影音家电</a></li>
            <li><a href="goodsSearchByType?goodsType=3">家居日用</a></li> 
            <li><a href="goodsSearchByType?goodsType=4">闲置数码</a></li>
            <li><a href="goodsSearchByType?goodsType=5">图书资料</a></li>
            <li><a href="goodsSearchByType?goodsType=6">动漫周边</a></li>
            <li><a href="goodsSearchByType?goodsType=7">珠宝收藏</a></li>
            <li><a href="goodsSearchByType?goodsType=8">鞋服配饰</a></li>         
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="showMyGoodsAction">我上传的商品</a></li>
            <li><a href="showMyBoughtAction">我买到的商品</a></li>
            <li><a href="showMySoldAction">我卖出的商品</a></li>            
          </ul>
        </li>
      </ul>
      
      <form class="navbar-form navbar-left searchbar" role="search" action="goodsSearchByName" method="post">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="搜索商品" name="goodsName">
          <input type="submit" value="搜索" style="color: #333;font-weight: 700;background-color: transparent;border-style: none;line-height: 50px;font-size:1em;text-transform: uppercase;letter-spacing: 1px;">
        </div>
      </form>
      <ul class="nav navbar-nav">
      	<c:if test="${empty sessionScope.user }">
	        <li><a href="login.jsp" data-target="#login"><span class="glyphicon glyphicon-user"></span>登录</a>
	        <li><a href="register.jsp" data-target="#login"><span class="glyphicon glyphicon-user"></span>注册</a></li>
        </c:if>
        <c:if test="${!empty sessionScope.user }">
        	<li><a href="infochange.jsp" data-target="#login"><span class="glyphicon glyphicon-user"></span>${sessionScope.user.userName }</a>
        	<li><a href="quit" ><span class="glyphicon glyphicon-user"></span>注销</a>
        </c:if>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle cart" data-toggle="dropdown"><span class="glyphicon glyphicon-shopping-cart"></span> 购物车<span class="caret"></span></a>
          <div class="dropdown-menu mini-cart">
          	<c:forEach items="${sessionScope.cart }" var="goods">
		       	<div class="row product-list">
					<div class="col-xs-3"><a href="showGoodsByIdAction?goodsId=${goods.goodsId}"><img src="${goods.goodsPicture1 }" class="img-responsive" alt="product"></a></div>
				    <div class="col-xs-7"><a href="showGoodsByIdAction?goodsId=${goods.goodsId}">${goods.goodsName}</a></div>
					<div class="col-xs-1"><a href="deleteMyCartAction?goodsId=${goods.goodsId}"><i class="fa fa-close"></i></a></div>
		        </div>
          	</c:forEach>

          <div class="clearfix">
          <a href="index.jsp" class="btn btn-primary">继续购物</a> 
          <a href="showMyCartAction" class="btn btn-primary">现在结账</a>
          </div>
          </div>
        </li>
      </ul>
    </div><!-- Wnavbar-collapse -->
  </div><!-- container-fluid -->
</nav>
</div>


<div class="container">

<!-- checkout -->
<div class="content inside-page register" id="registerdiv">
       <h2 class="title">上架新商品</h2>
		<div class="breadcrumb"><a href="index.jsp">首页</a> 
		/
		<a href="showMyGoodsAction">我上传的商品</a>/上架新商品 </div>
		 <fieldset>
		<div class="form-horizontal content-center">
		<form action="addMyGoodsAction" class="com.xyz.action.PersonAction" method="post" 
		onsubmit="return myfun_submit()">
		        <input type="hidden" class="form-control" name="xyzUser"  value=${sessionScope.user} }><br>
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label">商品名称</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsName">
				</div>				
				</div>

				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label">商品价格</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsPrice">
				</div>				
				</div>
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label" >商品描述</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsDescription">
				</div>				
				</div>
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label" >上传图片1</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsPicture1">
				</div>				
				</div>		
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label" >上传图片2</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsPicture2">
				</div>				
				</div>	
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label" >上传图片3</label>
				<div class="col-sm-8">
				<input type="text" class="form-control" name="goodsPicture3">
				</div>				
				</div>	
				<div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label">商品分类</label>
				<div class="col-sm-8">
					<select class="form-control" >
					<option>影音家电</option>
					<option>家居日用</option>
					<option>闲置数码</option>
					<option>图书资料</option>
					<option>动漫周边</option>
					<option>珠宝收藏</option>
					<option>鞋服配饰</option>
					<option>母婴用品</option>
					</select>
				</div>
				</div>	
				<input type="submit"  value="提交" name="submit" class="btn btn-primary"/>
 </form></div>
<script type="text/javascript">
function myfun_submit(){
	var ipt = document.getElementById("registerdiv").getElementsByTagName("input");
	for(var i = 0; i < ipt.length; i++){ 
        if(ipt[i].value.length == 0){ 
            alert("所有信息都需要填写"); 
            ipt[i].focus(); 
            return false; 
        }
    }
    return true;
}
function myfun_reset(){
	document.getElementById("userName").value = "";
	document.getElementById("userPassword").value = "";
	document.getElementById("userCelphone").value = "";
	document.getElementById("userAddress").value = "";
}
</script> 	
	</fieldset>	
</div>
</div>
<footer>
   <div class="container">
            <div class="row">
                <div class="col-sm-3 sitemap">
                    <h4>Sitemap</h4>
                    <ul class="list-unstyled">
                        <li><a href="#">主页</a></li>
                        <li><a href="#">Return Policy</a></li>
                        <li><a href="#">Terms and Condition</a></li>
                        <li><a href="#">Contact</a></li>                      
                    </ul>
                </div>                        
                <div class="col-sm-3 subscribe">
                    <h4>Enquiries</h4>
                    <p> 3488 Oak Avenue <br>
                    Lockport, NY 14094</p>

                    <i class="fa fa-envelope"></i> hello@bbbcc.com<br>
                    <i class="fa fa-phone"></i> 0000 000 000<br>
                </div>
                <div class="col-sm-3 joinus">
                    <h4>Subscribe</h4>
                    <div class="input-group"><input type="text" class="form-control" placeholder="Your Name"></div>
                    <div class="input-group"><input type="text" class="form-control email" placeholder="Your Email Address..."></div>
                    <button class="btn btn-primary"><i class="fa fa-paper-plane"></i> Subscribe</button>                   
                </div>
                <div class="col-sm-3">
                    <h4>Like and follow us</h4>
                    <span class="social"><a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i> <a href="#"><i class="fa fa-youtube"></i></a> <a href="#"><i class="fa fa-pinterest"></i></a></span>
                </div>

                
            </div>
            <!--/.row--> 
 
    
    <!--/.footer-bottom--> 
</div>
</footer>
<div class="copyright">
    <div class="container">
        
        Â© Copyright SHOPS 2015   
        <a href="http://thebootstrapthemes.com" class="pull-right">The Bootstrap Themes</a>

    </div>
</div>
</div>


<script src="assets/jquery.js"></script>



<!-- owlcarousel -->
<script src="assets/owl-carousel/owl.carousel.min.js"></script>

<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>





<!-- custom script -->
<script src="assets/script.js"></script>

</body>
</html>