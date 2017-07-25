<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>夏衣族旧货市场</title>

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
<c:if test="${empty requestScope.goodsList}">
		<jsp:forward page="findAllGoods"></jsp:forward>
</c:if>
<c:if test="${empty requestScope.collection1 }">
	<jsp:forward page="findCollection"></jsp:forward>
</c:if>
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




<!-- hero landing -->
<div class="hero-land clearfix1">
        <div class="landing muying-land">
        <img src="images/muying.jpg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>母婴用品</h1><a href="goodsSearchByType?goodsType=1"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing yingyin-land">
        <img src="images/yingyin.jpg"  class="img-responsive" alt="slide">
        <div class="caption  animated fadeInUp"><h1>影音家电</h1><a href="goodsSearchByType?goodsType=2"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing jiaju-land">
        <img src="images/jiaju.jpg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>家居日用</h1><a href="goodsSearchByType?goodsType=3"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing shuma-land">
        <img src="images/shuma.jpg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>闲置数码</h1><a href="goodsSearchByType?goodsType=4"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing tushu-land">
        <img src="images/tushu.jpg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>图书资料</h1><a href="goodsSearchByType?goodsType=5"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing dongman-land">
        <img src="images/dongman.jpg"  class="img-responsive" alt="slide">
        <div class="caption  animated fadeInUp"><h1>动漫周边</h1><a href="goodsSearchByType?goodsType=6"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing zhubao-land">
        <img src="images/zhubao.jpg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>珠宝收藏</h1><a href="goodsSearchByType?goodsType=7"><i class="fa fa-angle-right"></i></a></div>
        </div>
        <div class="landing xiefu-land">
        <img src="images/xiefu.jpeg"  class="img-responsive" alt="slide">
        <div class="caption animated fadeInUp"><h1>鞋服配饰</h1><a href="goodsSearchByType?goodsType=8"><i class="fa fa-angle-right"></i></a></div>
        </div>
</div>
<!-- hero landing -->




<!-- slider and feature product-->
<div class="container-feature">

<div class="container">
<div class="row" style="margin-top: 550px">

<div class="col-sm-7">
<h3>Collections</h3>
    

<!-- banner -->
<div class="banner">


<div class="carousel fade-carousel slide" data-ride="carousel" data-interval="4000" id="banner-carousel">

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
  	 <div class="item slides active"  style="width: 700px;height: 450px; overflow: hidden;">
       	<img src="${requestScope.collection1.goodsPicture}"  class="img-responsive" alt="slide" style="margin-top: -10%;">
   		<div class="carousel-caption">
         		<h2 class="animated slideInLeft">${requestScope.collection1.userName}的收藏</h2>        
    		 	<a href="goodsSearchByUser?userId=${requestScope.collection1.userId}" style="background-color: yellow;">查看所有商品</a>
   		</div>
  	</div>
  	<div class="item slides"  style="width: 700px;height: 450px; overflow: hidden;">
       	<img src="${requestScope.collection2.goodsPicture}"  class="img-responsive" alt="slide" style="margin-top: -20%;">
   		<div class="carousel-caption">
         		<h2 class="animated slideInLeft">${requestScope.collection2.userName}的收藏</h2>        
    		 	<a href="goodsSearchByUser?userId=${requestScope.collection2.userId}" style="background-color: yellow;">查看所有商品</a>
   		</div>
  	</div>
  	<div class="item slides" style="width: 700px;height: 450px; overflow: hidden;">
         	<img src="${requestScope.collection3.goodsPicture}"  class="img-responsive" alt="slide" style="margin-top: -20%;">
     		<div class="carousel-caption">
           		<h2 class="animated slideInLeft">${requestScope.collection3.userName}的收藏</h2>        
      		 	<a href="goodsSearchByUser?userId=${requestScope.collection3.userId}" style="background-color: yellow;">查看所有商品</a>
     		</div>
  	</div>
    <!-- <div class="item slides active">
      <img src="images/1.jpg"  class="img-responsive" alt="slide">
      <div class="carousel-caption">
            <h2 class="animated slideInLeft">Check out our Wedding Collection</h2>        
        <button class="btn btn-primary btn-lg" role="button">View all Products</button>
      </div>
    </div> 
    <div class="item slides">
      <img src="images/2.jpg"  class="img-responsive" alt="slide">
      <div class="carousel-caption"> 
            <h2 class="animated slideInLeft">High quality products at your budget</h2>        
        <button class="btn btn-primary btn-lg" role="button">View all Products</button>
      </div>
    </div>
    <div class="item slides">
      <img src="images/3.jpg"  class="img-responsive" alt="slide">
      <div class="carousel-caption"> 
            <h2 class="animated slideInLeft">Gifts collection for any occasion</h2>        
        <button class="btn btn-primary btn-lg" role="button">View all Products</button>
      </div>
    </div>-->
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#banner-carousel" role="button" data-slide="prev">
    <i class="fa fa-angle-left"></i>
  </a>
  <a class="right carousel-control" href="#banner-carousel" role="button" data-slide="next">
    <i class="fa fa-angle-right"></i>
  </a>

</div>


    
</div>
<!-- banner-->

</div>

<div class="col-sm-5">
<!-- feature-products -->
<div class="feature-products">
        <h3>Featured Products</h3>
        <div id="owl-products" class="owl-carousel">
        	<c:forEach items="${requestScope.goodsList }" var="goods" begin="7" end="10">
        		<div class="product">
	                <a href="showGoodsByIdAction?goodsId=${goods.goodsId}"><img src="${goods.goodsPicture1 }" class="img-responsive"></a>
	                <div class="row title-price">
	                    <div class="col-md-8"><h5><a href="showGoodsByIdAction?goodsId=${goods.goodsId}">${goods.goodsName }</a></h5></div>
	                    <div class="col-md-4"><span>￥ ${goods.goodsPrice}</span></div>
	                </div>
	                <a href="addToCartByUserAndGoods?goodsId=${goods.goodsId }" class="btn btn-default"><i class="fa fa-shopping-cart"></i>加入购物车</a>
               	</div>
        	</c:forEach>
     	</div>
</div>
<!-- featured -->

</div>
</div>
</div>
</div>
<!-- slider and feature product-->




<!-- latest products -->
<div class="latest-products">
    <div class="container">
    <h3>Latest Products</h3>
        <div class="row">
        	<c:forEach items="${requestScope.goodsList }" var="goods" begin="1" end="6">
        		<div class="col-sm-2 col-xs-6">
                <div class="product" style="max-width: 100%;max-height: expression(max-width);">
                            <a href="showGoodsByIdAction?goodsId=${goods.goodsId}"><img src="${goods.goodsPicture1 }" class="img-responsive" style="width: expression(this.width>=this.height  ? 100% : (this.width *100%) / this.height); 
                                               height: expression(this.width>=this.height ? (this.height *100%) / this.width) : 100%;"></a>
                            <div class="row title-price">
                                <div class="col-md-8"><h5><a href="showGoodsByIdAction?goodsId=${goods.goodsId}">${goods.goodsName }</a></h5></div>
                                <div class="col-md-4"><span>¥ ${goods.goodsPrice }</span></div>
                            </div>
                            <a href="addToCartByUserAndGoods?goodsId=${goods.goodsId }" class="btn btn-default"><i class="fa fa-shopping-cart"></i>加入购物车</a>
                </div>
            </div>
        	</c:forEach>
            
        </div>
</div>
</div>
<!-- latest products -->








<footer>
   <div class="container">
            <div class="row">
                <div class="col-sm-3 sitemap">
                    <h4>Sitemap</h4>
                    <ul class="list-unstyled">
                        <li><a href="index.jsp">主页</a></li>
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
        
        ? Copyright SHOPS 2015   
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