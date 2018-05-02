<style>
.navbar .nav>li>.dropdown-menu:before {
    content: '';
    display: inline-block;
    border-left: 7px solid transparent;
    border-right: 7px solid transparent;
    border-bottom: 7px solid #ccc;
    border-bottom-color: rgba(0, 0, 0, 0.2);
    position: absolute;
    top: -7px;
    left: 251px;
}


.navbar .pull-right>li>.dropdown-menu:before, .navbar .nav>li>.dropdown-menu.pull-right:before {
    left: auto;
    right: 9px;
}
.navbar .nav>li>.dropdown-menu:after {
    content: '';
    display: inline-block;
    border-left: 6px solid transparent;
    border-right: 6px solid transparent;
    border-bottom: 6px solid #ffffff;
    position: absolute;
    top: -6px;
    left: 252px;
}

.navbar .pull-right>li>.dropdown-menu:after, .navbar .nav>li>.dropdown-menu.pull-right:after {
    left: auto;
    right: 10px;
}

.nav>li>a {
    position: relative;
    display: block;
    padding: 7px 15px;
}
</style>


<div class="file signin">
	<a href="#include/upload.jsp">Upload</a>
</div> 
<!-- <div class="signin">
	<a class="play-icon popup-with-zoom-anim" href="#small-dialog">Account</a>
</div>  -->
<!-- <a class="signin" style="font-size: 14px; color: orange; font-weight: bold;"> Wellcome <span class="appuser"></span> </a> -->
				<ul class="nav pull-right signin">
					<li class="dropdown" style="margin: -0.7em 0 0 0;">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown">Profile <strong class="caret"></strong></a>
						<div class="dropdown-menu" style="margin: 6px 0px 0 -133px;">
							<!-- <form method="post" action="login" accept-charset="UTF-8">
								<input style="margin-bottom: 15px;" type="text" placeholder="Username" id="username" name="username">
								<input style="margin-bottom: 15px;" type="password" placeholder="Password" id="password" name="password">
								<input style="float: left; margin-right: 10px;" type="checkbox" name="remember-me" id="remember-me" value="1">
							</form> -->
							<div  style="margin: 1em 0">
						           
					                <!-- <img class="media-object dp img-circle" src="http://www.huffmancode.com/img/hardik.jpg" style="width: 100px;height:100px;"> -->
					                <div class="media-body" style="text-align: center;"><i class="fa fa-user" style="font-size: 25px"></i><h4 class="appuser"> Hardik Sondagar </h4> </div>
						            
						            <hr style="margin:8px auto">
						            <a class="btn btn-primary btn-sm appsignout" href="#" style="float: right;margin-right: 10px"> Sign out</a>
						            <a class="btn btn-primary btn-sm myaccount" style="float: left;margin-left: 10px"> My account</a>
						        </div>
						</div>
					</li>
				</ul>