 <!DOCTYPE HTML>
<html>
<head>
<title>Express Right | Talent Platform for Younger generation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all" />
<!-- //bootstrap -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/appcustom.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- <script src="js/jquery-1.11.1.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--start-smoth-scrolling-->
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Poiret+One' rel='stylesheet' type='text/css'>
 <link href="js/dist/video-js.css" rel="stylesheet">
 <link rel="shortcut icon"
	href="images/appimage/BrowserTitleLogo.png">
	<script type="text/javascript" src="config/expressConfig.js"></script>

<!-- //fonts -->
</head>
  <body>
  <script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '384775331904180',
      xfbml      : true,
      version    : 'v2.8'
    });
    FB.AppEvents.logPageView();
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>   
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
         <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed"  aria-expanded="false" aria-controls="navbar" id="menu-toggle-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <a class="navbar-brand" href="#include/home.jsp"> <img src="images/appimage/LogoExpressRight.png"  alt="" style="height: 55px; margin-top: -11px;";/> </a>
		  
 		<!-- <div class="collapse navbar-collapse pull-left" id="bs-example-navbar-collapse-1" >
                            <ul class="nav navbar-nav">
                                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"> <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
                            </ul>
                </div> --><!-- bs-example-navbar-collapse-1 -->      
        </div> 
        <div id="navbar" class="navbar-collapse collapse">
			<div class="top-search">
			
				<form class="navbar-form navbar-right" name="searchForm">
					
					<div class="input-group col-md-12">
					  <div class="input-group-btn">
					        <button type="button" class="btn btn-secondary dropdown-toggle col-md-12 select_theme_button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					          All
					        </button>
					        <ul class="dropdown-menu dropdown-menu-left themes_select">
					          <li class="dropdown-item"><a href="#">Action</a></li>
					          <li class="dropdown-item"><a href="#">Another action</a></li>
					          <li class="dropdown-item"><a href="#">Something else here</a></li>
					          <li role="separator" class="dropdown-divider"></li>
					          <li class="dropdown-item" ><a href="#">Separated link</a></li>
					        </ul>
					      </div>
					 	<input type="text" class="form-control" placeholder="Search..." name="query">
					 	<input type="hidden" name="theme" value="-1">
						<input type="submit" class="form-control video_search_button" data-selected_theme="-1" value=" ">
					</div>
				</form>
			</div>
			<!-- <div class="header-top-right">
				<div class="file">
					<a href="upload.jsp">Upload</a>
				</div>
				<div class="signin">
					<a href="#" class="play-icon popup-with-zoom-anim">My Profile</a>
				</div>
				<div class="signin">
					<a href="home.jsp" class="play-icon popup-with-zoom-anim">Logout</a>
				</div>
				<div class="clearfix"> </div>
			</div> -->
			<div class="header-top-right">
				  <div class="file">
					<a href="#small-dialog111" class="play-icon popup-with-zoom-anim">Upload</a>
				</div> 
				<div class="signin">
					<a href="#small-dialog3" class="play-icon popup-with-zoom-anim usersignin_btn">Sign Up</a>
					<!-- pop-up-box -->
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
									<script type="text/javascript" src="js/modernizr.custom.min.js"></script>    
									<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
									<!--//pop-up-box -->
									<!-- <div id="small-dialog2" class="mfp-hide">
										<h3>Create Account</h3> 
										<div class="social-sits">
											<div class="facebook-button">
												<a href="#">Connect with Facebook</a>
											</div>
											<div class="chrome-button">
												<a href="#">Connect with Google</a>
											</div>
											<div class="button-bottom">
												<p>Already have an account? <a href="#small-dialog" class="play-icon popup-with-zoom-anim">Login</a></p>
											</div>
										</div>
										<div class="signup">
											<form>
												<input type="text" class="email" placeholder="Mobile Number" maxlength="10" pattern="[1-9]{1}\d{9}" title="Enter a valid mobile number" />
												
											</form>
											<div class="continue-button">
												<a href="#small-dialog3" class="hvr-shutter-out-horizontal play-icon popup-with-zoom-anim">CONTINUE</a>
											</div>
										</div>
										<div class="clearfix"> </div>
									</div> -->	
									<div id="small-dialog3" class="mfp-hide">
										<h3>Create Account</h3> 
										<div class="social-sits">
											<!--<div class="facebook-button">
												<a href="#">Connect with Facebook</a>
											</div>
											<div class="chrome-button">
												<a href="#">Connect with Google</a>
											</div>-->
											<div class="button-bottom">
												<p>Already have an account? <a href="#small-dialog" class="play-icon popup-with-zoom-anim">Login</a></p>
											</div>
										</div>
										<div class="signup">
											<form id="form_signup" action="#include/home.jsp">
												<div>
													<input type="text"  name="username" placeholder="Name" required="required" title="Enter name"/>
												</div>
												<div>
													<input type="text" class="email" name="email" placeholder="Email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter a valid email"/>
												</div>
												<div>
													<input type="password"  name="password" id="userpassword" placeholder="Password" required="required" pattern=".{6,}" title="Minimum 6 characters required" autocomplete="off" />
												</div>
												<div class="col-sm-6">
												<span id="8char1" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>
												<span id="ucase1" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
												</div>
												<div class="col-sm-6">
												<span id="lcase1" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
												<span id="num1" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
												</div>
												<div>
													<input type="password"  name="confirmPassword" id="userconfirmpassword" placeholder="Confirm Password" required="required" pattern=".{6,}" title="Minimum 6 characters required" autocomplete="off" />
												</div>
												<div class="col-sm-6">
												<span id="pwmatch1" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match 
												</div>
												<div>
													<input type="text"  name="phoneNumber" required="required" placeholder="Mobile Number" maxlength="10" pattern="[1-9]{1}\d{9}" title="Enter a valid mobile number" />
												</div>
												
												<div class="form-group">
						                            <select name="ageGroup" class="form-control" required="required" title="Select age group">
						                                <option value="na" selected="">Kids age group</option>
						                                <option value="1">5-8</option>
						                                 <option value="2">9-12</option>
						                                 <option value="3">13-16</option>
						                                  <option value="4">17</option>
						                                   <option value="5">18 ></option>
						                            </select>
						                        </div>
												<!-- <input type="hidden" name="login" value="true"> -->
												<div><input type="submit"  value="Sign Up"/></div>
											</form>
										</div>
										<div class="clearfix"> </div>
									</div>	
									<div id="small-dialog7" class="mfp-hide">
										<h3>Create Account</h3> 
										<div class="social-sits">
											<!--<div class="facebook-button">
												<a href="#">Connect with Facebook</a>
											</div>
											<div class="chrome-button">
												<a href="#">Connect with Google</a>
											</div>-->
											<div class="button-bottom">
												<p>Already have an account? <a href="#small-dialog" class="play-icon popup-with-zoom-anim">Login</a></p>
											</div>
										</div>
										<div class="signup">
											<form action="upload.jsp">
												 <input type="text" class="email" placeholder="Email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter a valid email"/>
												<input type="password" placeholder="Password" required="required" pattern=".{6,}" title="Minimum 6 characters required" autocomplete="off" /> 
												<input type="submit"  value="Sign In"/>
											</form>
										</div>
										<div class="clearfix"> </div>
									</div>		
									<div id="small-dialog4" class="mfp-hide">
										<h3>Feedback</h3> 
										<div class="feedback-grids">
											<div class="feedback-grid">
												<p>Suspendisse tristique magna ut urna pellentesque, ut egestas velit faucibus. Nullam mattis lectus ullamcorper dui dignissim, sit amet egestas orci ullamcorper.</p>
											</div>
											<div class="button-bottom">
												<p><a href="#small-dialog" class="play-icon popup-with-zoom-anim">Sign in</a> to get started.</p>
											</div>
										</div>
									</div>
									<div id="small-dialog5" class="mfp-hide">
										<h3>Help</h3> 
											<div class="help-grid">
												<p>Suspendisse tristique magna ut urna pellentesque, ut egestas velit faucibus. Nullam mattis lectus ullamcorper dui dignissim, sit amet egestas orci ullamcorper.</p>
											</div>
											<div class="help-grids">
												<div class="help-button-bottom">
													<p><a href="#small-dialog4" class="play-icon popup-with-zoom-anim">Feedback</a></p>
												</div>
												<div class="help-button-bottom">
													<p><a href="#small-dialog6" class="play-icon popup-with-zoom-anim">Lorem ipsum dolor sit amet</a></p>
												</div>
												<div class="help-button-bottom">
													<p><a href="#small-dialog6" class="play-icon popup-with-zoom-anim">Nunc vitae rutrum enim</a></p>
												</div>
												<div class="help-button-bottom">
													<p><a href="#small-dialog6" class="play-icon popup-with-zoom-anim">Mauris at volutpat leo</a></p>
												</div>
												<div class="help-button-bottom">
													<p><a href="#small-dialog6" class="play-icon popup-with-zoom-anim">Mauris vehicula rutrum velit</a></p>
												</div>
												<div class="help-button-bottom">
													<p><a href="#small-dialog6" class="play-icon popup-with-zoom-anim">Aliquam eget ante non orci fac</a></p>
												</div>
											</div>
									</div>
									<div id="small-dialog6" class="mfp-hide">
										<div class="video-information-text">
											<h4>Video information & settings</h4>
											<p>Suspendisse tristique magna ut urna pellentesque, ut egestas velit faucibus. Nullam mattis lectus ullamcorper dui dignissim, sit amet egestas orci ullamcorper.</p>
											<ol>
												<li>Nunc vitae rutrum enim. Mauris at volutpat leo. Vivamus dapibus mi ut elit fermentum tincidunt.</li>
												<li>Nunc vitae rutrum enim. Mauris at volutpat leo. Vivamus dapibus mi ut elit fermentum tincidunt.</li>
												<li>Nunc vitae rutrum enim. Mauris at volutpat leo. Vivamus dapibus mi ut elit fermentum tincidunt.</li>
												<li>Nunc vitae rutrum enim. Mauris at volutpat leo. Vivamus dapibus mi ut elit fermentum tincidunt.</li>
												<li>Nunc vitae rutrum enim. Mauris at volutpat leo. Vivamus dapibus mi ut elit fermentum tincidunt.</li>
											</ol>
										</div>
									</div>
									<div id="small-dialog111" class="mfp-hide">
										<h3>Upload</h3> 
										<div class="feedback-grids">
											<div class="feedback-grid">
												<p>Please sign in to perform this action.</p>
											</div>
											<div class="button-bottom">
												<p><a href="#small-dialog" class="play-icon popup-with-zoom-anim">Sign in</a> to get started.</p>
											</div>
										</div>
									</div>
									<div id="small-dialog112" class="mfp-hide">
										<h3>Forgot password</h3> 
										<div class="feedback-grids">
											<!-- <div class="feedback-grid">
												<p>Please sign in to perform this action.</p>
											</div>
											<div class="button-bottom">
												<p><a href="#small-dialog" class="play-icon popup-with-zoom-anim">Sign in</a> to get started.</p>
											</div> -->
											<form id="recover_form">
											<div class="form-group">
							                   <!--  <label for="email" class="col-sm-1 ">Title</label> -->
							                    <div class="col-sm-11">
							                        <div>
														<input type="text" class="form-control" name="email" placeholder="Enter your valid email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Registered Email Id"/>
													</div>
							                    </div>
							                    
							                </div>
											<div><input type="submit" class=" btn btn-primary" value="SUBMIT" style="margin-top: 10px"/></div>
											
										</form>
										</div>
									</div>
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
																											
											});
									</script>	
				</div>
				<div class="signin">
					<a href="#small-dialog" class="play-icon popup-with-zoom-anim">Sign In</a>
					<div id="small-dialog" class="mfp-hide">
						<h3>Login</h3>
						<div class="social-sits">
							<!--<div class="facebook-button">
								<a href="#">Connect with Facebook</a>
							</div>
							<div class="chrome-button">
								<a href="#">Connect with Google</a>
							</div>-->
							<div class="button-bottom">
								<p>New account? <a href="#small-dialog3" class="play-icon popup-with-zoom-anim">Signup</a></p>
							</div>
						</div>
						<div class="signup">
							<form id="signin_form">
								<div>
									<input type="text" name="username" class="email" placeholder="Enter Email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/>
								</div>
								<div>
									<input type="password" name="password" placeholder="Password" required="required" pattern=".{6,}" title="Minimum 6 characters required" autocomplete="off" />
								</div>
								
								<div><input type="submit"  value="LOGIN"/></div>
								
							</form>
							<div class="forgot">
								<a href="#small-dialog112" class="play-icon popup-with-zoom-anim">Forgot password ?</a>
							</div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
        </div>
		<div class="clearfix"> </div>
      </div>
      <!-- <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li> 
      <li><a href="#">Page 3</a></li> 
    </ul> -->
    	 
    </nav>
	
	<div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu">
 
                <li class="active">
                    <a href="#include/home.jsp" ><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-home "></i></span> Dashboard</a>
                      <%--<ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#">link1</a></li>
                        <li><a href="#">link2</a></li>
                    </ul> --%>
                </li>
                <li>
                    <!--<a href="#include/history.jsp" class="sub-icon" ><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-home glyphicon-hourglass"></i></span> History</a>-->
                    <%--<ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link1</a></li>
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link2</a></li>
 
                    </ul> --%>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"  style="margin: 0px 0em 0px -0.2em;"><i class="fa fa-cloud-download fa-stack-1x "></i></span>Themes<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span></a>
                    <ul class="nav-pills nav-stacked themes_list" style="list-style-type:none;">
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link1</a></li>
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>link2</a></li>
 
                    </ul>
                </li>
				<li>
					<a href="#include/aboutus.jsp" class="sub-icon" ><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-globe"></i></span> About Us</a>
				</li>
				<li>
					<a href="#include/contactus.jsp" class="sub-icon" ><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-envelope"></i></span> Contact Us</a>
				</li
				<li>
					<a href="#"><span class="fa-stack fa-lg pull-left"></span><img alt="Make A Wish" src="images/appimage/PartnerLogo1.png" style="width:230px"></a>
				</li>
				<li>
					<a href="https://channelstore.roku.com/details/229244/expressright-kids-tv"><span class="fa-stack fa-lg pull-left"></span><img alt="Roku Channel" src="images/appimage/PartnerLogo2.png" style="width:200px"></a>
				</li>
				<li>
					<a href="https://www.unreel.me/"><span class="fa-stack fa-lg pull-left"></span><img alt="Unreel.me" src="images/appimage/PartnerLogo3.png" style="width:200px;"></a>
				</li>
				
				
               </ul>
			 
			   
			   
        </div><!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">
                <div class="row">
                    <div class="col-lg-12" id="content">
                       <%--
                       	<h1>Simple Sidebar With Bootstrap 3 by <a href="http://seegatesite.com/create-simple-cool-sidebar-menu-with-bootstrap-3/" >Seegatesite.com</a></h1>
                        <p>This sidebar is adopted from start bootstrap simple sidebar startboostrap.com, which I modified slightly to be more cool. For tutorials and how to create it , you can read from my site here <a href="http://seegatesite.com/create-simple-cool-sidebar-menu-with-bootstrap-3/">create cool simple sidebar menu with boostrap 3</a></p>
                       
                        --%> 
                    </div>
                   
                </div>
                
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->
	
        <!-- <div class="col-sm-3 col-md-2 sidebar">
			
        </div> -->
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div id="content" style="min-height: 72vh">
        
        </div>
        
        <!-- footer -->
			<div class="footer">
				<div class="footer-grids">
					
						<div class="footer-top-nav">
							<ul>
								<li><a href="#include/aboutus.jsp">About Us </a></li>
								<li><a href="#include/contactus.jsp">Contact Us</a></li>
								<li><a href="#include/privacy.jsp">Privacy policy / Terms of use</a></li>
							
							</ul>
						</div>
						<div class="footer-bottom-nav">
							<ul>
								<li><p>©ExpressRight 2018</p></li>
								<li><a href="https://itunes.apple.com/us/app/express-right/id1223334039?ls=1&mt=8" target="_blank"><img alt="App Store" src="images/appimage/app-store.png"> <span class="appstore">App Store</span></a></li>
								<!--<li><a href="#"><img alt="Play Store" src="images/appimage/play-store.png"> <span class="playstore">Play Store</span></a></li>-->
								<li><img alt="Play Store" src="images/appimage/play-store.png"> <span class="playstore">Play Store</span></li>
								<li><p>Follow us<p></li>
							 	<li><div class="side-bottom-icons" style="margin: 0px!important;">
									<ul class="footer_social_links" >
										<li class="animate zoomIn" data-anim-type="zoomIn">
										<a href="https://www.facebook.com/expressright" target="_blank">
										<i class="fa fa-facebook"></i>
										</a>
										</li>								
										<li class="animate zoomIn" data-anim-type="zoomIn">
										<a href="https://www.twitter.com/express_right" target="_blank">
										<i class="fa fa-twitter"></i>
										</a>
										</li>
										<li class="animate zoomIn" data-anim-type="zoomIn">
										<a href="https://www.linkedin.com/in/express-right-858094140" target="_blank">
										<i class="fa fa-linkedin"></i>
										</a>
										</li>
									</ul>
								</div></li> 
							</ul>
						</div>
						
						
					
					<!--<div class="footer-bottom">
						<ul>
							
						</ul>
					</div>-->
				</div>
			</div>
			<!-- //footer -->
		
		</div> 
		 
		
		<div class="clearfix"> </div>
	<!-- <div class="drop-menu">
		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu4">
		  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Regular link</a></li>
		  <li role="presentation" class="disabled"><a role="menuitem" tabindex="-1" href="#">Disabled link</a></li>
		  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another link</a></li>
		</ul>
	</div> -->
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/dist/video.js"></script>
  <script src="js/jquery.validate.min.js"></script>
  <script src="js/appjs/bootstrap-notify.min.js"></script>
  
  <script src="js/appjs/gologin.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script type="text/javascript">
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
     $("#menu-toggle-2").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled-2");
        $("body").toggleClass("toggled-2");
        $('#menu ul').hide();
    });
 
     function initMenu() {
      $('#menu ul').hide();
      $('#menu ul').children('.current').parent().show();
      $('#menu li').click(
    	function(){
    		$('#menu li.active').removeClass("active");
    		$(this).addClass("active")
    	}	  
      )
      //$('#menu ul:first').show();
      $('#menu li a').click(
        function() {
          var checkElement = $(this).next();
          if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
        	  $('#menu ul:visible').slideUp('normal');
            return false;
            }
          if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
            $('#menu ul:visible').slideUp('normal');
            checkElement.slideDown('normal');
            return false;
            }
          }
        );
      }
    $(document).ready(function() {initMenu();});
    </script>
    
    <script type="text/javascript">
	var appstatus;	
	var setupsatatus=true;
	var hash = location.hash;
	
	if (!String.prototype.endsWith) {
		  String.prototype.endsWith = function(searchString, position) {
		      var subjectString = this.toString();
		      if (typeof position !== 'number' || !isFinite(position) || Math.floor(position) !== position || position > subjectString.length) {
		        position = subjectString.length;
		      }
		      position -= searchString.length;
		      var lastIndex = subjectString.lastIndexOf(searchString, position);
		      return lastIndex !== -1 && lastIndex === position;
		  };
		}
	
	
	if (hash.length > 0) {
		hashChangeHandler();
	} else {
		loadPage("include/home.jsp");
		
	}

	window.onhashchange = hashChangeHandler;

	function hashChangeHandler() {
		if (typeof clearFields == 'function') {
			clearFields();
			clearFields = undefined;
		}
		var hash = location.hash.substring(1, location.hash.length);

		loadPage(hash);
		//$('#page-content').load(encodeURI('dashBoard.jsp'));
		//$('#page-content').load(encodeURI(location.hash));
	}

	function loadPage(hashc) {
		console.log(hashc);
		if(setupsatatus){
			appstaus();
		}
		//hashc = hashc.substring(1,hashc.length)
		if (hashc.toLowerCase().indexOf(".html")>0|| hashc.toLowerCase().indexOf(".jsp") > 0) {
			
			$('#content').load(encodeURI(hashc));

		}
	}


	function nano(template, data) {
	  return template.replace(/\{([\w\.]*)\}/g, function(str, key) {
	    var keys = key.split("."), v = data[keys.shift()];
	    for (var i = 0, l = keys.length; i < l; i++) v = v[keys[i]];
	    return (typeof v !== "undefined" && v !== null) ? v : "";
	  });
	}
	/* $.getJSON(config.restserverUrl+"themes/all",function(data){
		data.forEach(function(theme){
			$("#name").append(' <option value="'+theme.theme_id+'">'+theme.theme_name+'</option>')
		})
	}); */

	$("input[type='password']","#form_signup").keyup(function(){
	    var ucase = new RegExp("[A-Z]+");
		var lcase = new RegExp("[a-z]+");
		var num = new RegExp("[0-9]+");
		
		if($("#userpassword").val().length >= 8){
			$("#8char1").removeClass("glyphicon-remove");
			$("#8char1").addClass("glyphicon-ok");
			$("#8char1").css("color","#00A41E");
		}else{
			$("#8char1").removeClass("glyphicon-ok");
			$("#8char1").addClass("glyphicon-remove");
			$("#8char1").css("color","#FF0004");
		}
		
		if(ucase.test($("#userpassword").val())){
			$("#ucase1").removeClass("glyphicon-remove");
			$("#ucase1").addClass("glyphicon-ok");
			$("#ucase1").css("color","#00A41E");
		}else{
			$("#ucase1").removeClass("glyphicon-ok");
			$("#ucase1").addClass("glyphicon-remove");
			$("#ucase1").css("color","#FF0004");
		}
		
		if(lcase.test($("#userpassword").val())){
			$("#lcase1").removeClass("glyphicon-remove");
			$("#lcase1").addClass("glyphicon-ok");
			$("#lcase1").css("color","#00A41E");
		}else{
			$("#lcase1").removeClass("glyphicon-ok");
			$("#lcase1").addClass("glyphicon-remove");
			$("#lcase1").css("color","#FF0004");
		}
		
		if(num.test($("#userpassword").val())){
			$("#num1").removeClass("glyphicon-remove");
			$("#num1").addClass("glyphicon-ok");
			$("#num1").css("color","#00A41E");
		}else{
			$("#num1").removeClass("glyphicon-ok");
			$("#num1").addClass("glyphicon-remove");
			$("#num1").css("color","#FF0004");
		}
		if($("#userpassword").val().length>1){
			
			if($("#userpassword").val() == $("#userconfirmpassword").val()){
				
				$("#pwmatch1").removeClass("glyphicon-remove");
				$("#pwmatch1").addClass("glyphicon-ok");
				$("#pwmatch1").css("color","#00A41E");
			}else{
				$("#pwmatch1").removeClass("glyphicon-ok");
				$("#pwmatch1").addClass("glyphicon-remove");
				$("#pwmatch1").css("color","#FF0004");
			}
			
		}else{
			$("#pwmatch1").addClass("glyphicon-remove");
			$("#pwmatch1").css("color","#FF0004");
		} 
		
	});

	$("#usersignin_btn").on("click",function(){
		$("#form_signup")[0].reset();
		$("#lcase").addClass("glyphicon-remove");
		$("#lcase").css("color","#FF0004");
		$("#8char").addClass("glyphicon-remove");
		$("#8char").css("color","#FF0004");
		$("#num").addClass("glyphicon-remove");
		$("#num").css("color","#FF0004");
		$("#ucase").addClass("glyphicon-remove");
		$("#ucase").css("color","#FF0004");
		$("#pwmatch").addClass("glyphicon-remove");
		$("#pwmatch").css("color","#FF0004");
		
	})
</script>
<script>
						$('.themes_list').html('');
						$('.themes_select').html('');
						$(document.searchForm).on('submit',function(event){
							event.preventDefault();
							location.hash="include/query.jsp?"+$(this).serialize();
						});
						
					$.getJSON(config.restserverUrl+"themes/all",function(data){
						function populateSearchThemes(theme){
							var theme_html = nano("<li><a href='#include/theme.jsp?theme_id={theme_id}'>{theme_name}</a></li>" ,theme)
							
							$('.themes_list').append(theme_html);
							var theme_select_html = nano("<li class=\"dropdown-item\"><a href=\"#\">{theme_name}</a></li>" ,theme)
							var theme_select_div =$(theme_select_html)
							theme_select_div.on("click",function(){
								$(".select_theme_button").text(theme.theme_name)
								$(".video_search_button").data("selected_theme",theme.theme_id)
								document.searchForm.theme.value = theme.theme_id;
								
							})
							$('.themes_select').append(theme_select_div);
						}
						populateSearchThemes({theme_name:"All" , theme_id : -1})
						data.forEach(populateSearchThemes)
					})
					$( "li a.menu" ).click(function() {
					$( "ul.cl-effect-1" ).slideToggle( 300, function() {
					// Animation complete.
					});
					});
							$( ".top-navigation" ).click(function() {
							$( ".drop-navigation" ).slideToggle( 300, function() {
							// Animation complete.
								if($(this).css("display") == 'none'){
									$(this).css("display","");
									}
							});
							});
						</script>
  
  </body>
  <link href="js/dist/videojs-resume.min.css" rel="stylesheet">
  <script type="text/javascript" src="js/dist/store.min.js"></script>
  <script type="text/javascript" src="js/dist/videojs-resume.min.js"></script> 
  
</html>
