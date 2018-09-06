<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>FalboMusic - brani</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Mosaic Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.css" type='text/css' />
<!-- //lined-icons -->
 <!-- Meters graphs -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/functionUtility.js"></script>
<script src="js/login.js"></script>
<script>



</script>
</head> 
	
		<%@include file="js/navbar.jsp"%>

    	 <!-- /w3layouts-agile -->
 <body class="sticky-header left-side-collapsed"  > <!-- onload="initMap()">  -->
    <section>
      <!-- left side start-->
      <%@include file="js/leftbar.jsp"%>
		 	 <!-- /w3layouts-agile -->
					<!-- app-->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog facebook" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body">
							<div class="app-grids">
								<div class="app">
						
						<div class="col-md-7 app-image">
							<img src="images/apps.png" alt="">
						</div>
						<div class="clearfix"></div>
					</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<!-- //app-->

 	 <!-- /w3l-agile -->
		<!-- signup -->
			<div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="sign-grids">
								<div class="sign">
							<!--  	<div class="sign-left">
										<ul>
											<li><a class="fb" href="#"><i></i>Sign in with Facebook</a></li>
											<li><a class="goog" href="#"><i></i>Sign in with Google</a></li>
											<li><a class="linkin" href="#"><i></i>Sign in with Linkedin</a></li>
										</ul>
									</div> -->	
									<div class="sign-right">
										<form id=registerForm method="post">

											<h3>Create your account </h3>
											
											<input type="text" value="Name" id="nome" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
											<input type="text" value="Cognome" id="cognome" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="">
											<input type="text" value="Username" id="usrreg" name="usr"onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required="" onchange="controllauser();">
											<div id="availability" class="form-group"></div>
											
									<!--	<input type="text" value="Mobile number" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Mobile number';}" required="">
								    		<input type="text" value="Email id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email id';}" required="">	-->
											<input type="password" value="Password" id="pswreg" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
											<input type="password" value="Password" id="pswrepeat" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">	
											<div id="statusreg" class="form-group"></div>
											<input type="button" value="CREATE ACCOUNT" id="submitregbutton" onclick="registraUtente();" style="display:none" >
										</form>
									</div>
									<div class="clearfix"></div>								
								</div>
								<p>By logging in you agree to our <span>Terms and Conditions</span> and <span>Privacy Policy</span></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //signup -->
 	 <!-- /w3l-agile -->
		<!-- left side end-->
		<!-- main content start-->
		<div class="main-content">
						<div id="page-wrapper">
				<div class="inner-content">
				
				      <div class="music-left">
					      <!--banner-section-->
							
									
						
								<div class="clearfix"> </div>
							</div>
						</div>	
				<!--//End-banner-->
					<!--albums-->
					<!-- pop-up-box --> 
							<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all">
							<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
							 <script>
									$(document).ready(function() {
									$('.popup-with-zoom-anim').magnificPopup({
										type: 'inline',
										fixedContentPos: false,
										fixedBgPos: true,
										overflowY: 'auto',
										closeBtnInside: true,
										preloader: false,
										midClick: true,
										removalDelay: 300,
										mainClass: 'my-mfp-zoom-in'
									});
									//$("#b-search").hide();
									
									caricaNuoveUscite();
									controlloLogin();
									caricaArtisti();
									
									
									});
							</script>		
				
				<div id="myTabContent" class="tab-content">
								  <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
									<div class="browse-inner">
								 	 <!-- /agileits -->
								
									<div class="col-md-3 artist-grid">
										<a  href="single.html"><img src="images/a3.jpg" title="allbum-name"></a>
										 <a href="single.html"><i class="glyphicon glyphicon-play-circle"></i></a>
												<a class="art" href="single.html">Sukhwinder singh</a>
										</div>
							</div>
						
		
													 <!--//music-right-->
											<div class="clearfix"></div>
			 	 <!-- /w3l-agile-its -->
										</div>
						
 	 <!-- /w3l-agile -->
					</div>

        <!--footer section start-->
			<footer>
			   <p>copy 2018 Falbo Gianluca </p>
			</footer>
        <!--footer section end-->
 	 <!-- /w3l-agile -->
      <!-- main content end-->
   </section>
  
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- <script src="js/login.js"></script> -->
<script src="js/functionUtility.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.js"></script>
</body>
</html>