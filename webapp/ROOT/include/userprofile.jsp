<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<style>

#leftPanel{
    background-color:#f58634;
    color:#fff;
    text-align: center;
}

#rightPanel{
    min-height:415px;
}

/* Credit to bootsnipp.com for the css for the color graph */
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
.btn-labeled {
    padding-bottom: 0;
    padding-top: 0;
}
.btn-label {
    background: rgba(0, 0, 0, 0.15) none repeat scroll 0 0;
    border-radius: 3px 0 0 3px;
    display: inline-block;
    left: -12px;
    padding: 6px 12px;
    position: relative;
}

</style>

	<div class="row" id="main" style="padding: 0px;margin: 0px">
        <div class="col-md-4 well" id="leftPanel">
            <div class="row">
                <div class="col-md-12" style="height: 58vh;">
                	<div>
        				<img src="http://lorempixel.com/200/200/abstract/1/" alt="Texto Alternativo" class="img-circle img-thumbnail">
        				<h2 class="appuser"></h2>
        				<!-- <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
        				tempor incididunt ut labore et dolore magna aliqua.</p> -->
        				<button type="button" class="btn btn-labeled btn-primary" id="enableeditprofile" style="margin-top: 40px">
                            <span class="btn-label"><i class="fa fa-pencil"></i></span>Edit Profile</button>
        			</div>
        		</div>
            </div>
        </div>
        <div class="col-md-8 well" id="rightPanel">
    <div class="col-md-12">
    	
    	<form role="form" style="margin-bottom: 10px" id="userprofile_form">
			<h2>Edit your profile.<small>It's always easy</small></h2>
			<hr class="colorgraph">
			
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-12">
					<div class="form-group">
                        <input type="text" name="full_name" id="full_name" class="form-control input-lg" placeholder="Full Name" tabindex="1" disabled="disabled">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-12">
					<div class="form-group">
						<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4"  disabled="disabled">
					</div>
				</div>	
			</div>
			<!-- <button type="button" class="btn btn-labeled btn-info pull-right">
                            <span class="btn-label"><i class="fa fa-pencil"></i></span>Update</button> -->
			
			<div class="row">
			
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="newpassword" id="password1" class="form-control input-lg" placeholder=" New Password" disabled="disabled" tabindex="5">
					</div>
					<div class="col-sm-6">
						<span id="8char" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> 8 Characters Long<br>
						<span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
						</div>
						<div class="col-sm-6">
						<span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter<br>
						<span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number
						</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6" disabled="disabled">
					</div>
					<div class="col-sm-6">
					<span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match 
					</div>
				</div>
				<button type="reset" class="btn btn-warning pull-right canceleditprofile"  style="margin-left: 10px">
                            Clear</button>
                        <button type="submit" class="btn btn-primary pull-right saveeditprofile" disabled="disabled">
                            Submit</button>
                 
			</div>
			<input type="hidden" name="profile_id" value="">
           
			<hr class="colorgraph">
			<!-- <div class="row">
				<div class="col-xs-12 col-md-6"></div>
				<div class="col-xs-12 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Save</a></div>
			</div> -->
		</form>
	</div>
</div>

</div>
   
        
<script type="text/javascript">
$(".appuser").text(localStorage.getItem("appuser"));
$("input[name=profile_id").val(localStorage.getItem("user_session_id"));
$("input[type=password]").keyup(function(){
    var ucase = new RegExp("[A-Z]+");
	var lcase = new RegExp("[a-z]+");
	var num = new RegExp("[0-9]+");
	
	if($("#password1").val().length >= 8){
		$("#8char").removeClass("glyphicon-remove");
		$("#8char").addClass("glyphicon-ok");
		$("#8char").css("color","#00A41E");
	}else{
		$("#8char").removeClass("glyphicon-ok");
		$("#8char").addClass("glyphicon-remove");
		$("#8char").css("color","#FF0004");
	}
	
	if(ucase.test($("#password1").val())){
		$("#ucase").removeClass("glyphicon-remove");
		$("#ucase").addClass("glyphicon-ok");
		$("#ucase").css("color","#00A41E");
	}else{
		$("#ucase").removeClass("glyphicon-ok");
		$("#ucase").addClass("glyphicon-remove");
		$("#ucase").css("color","#FF0004");
	}
	
	if(lcase.test($("#password1").val())){
		$("#lcase").removeClass("glyphicon-remove");
		$("#lcase").addClass("glyphicon-ok");
		$("#lcase").css("color","#00A41E");
	}else{
		$("#lcase").removeClass("glyphicon-ok");
		$("#lcase").addClass("glyphicon-remove");
		$("#lcase").css("color","#FF0004");
	}
	
	if(num.test($("#password1").val())){
		$("#num").removeClass("glyphicon-remove");
		$("#num").addClass("glyphicon-ok");
		$("#num").css("color","#00A41E");
	}else{
		$("#num").removeClass("glyphicon-ok");
		$("#num").addClass("glyphicon-remove");
		$("#num").css("color","#FF0004");
	}
	if($("#password1").val().length>1){
		if($("#password1").val() == $("#password_confirmation").val()){
			$("#pwmatch").removeClass("glyphicon-remove");
			$("#pwmatch").addClass("glyphicon-ok");
			$("#pwmatch").css("color","#00A41E");
		}else{
			$("#pwmatch").removeClass("glyphicon-ok");
			$("#pwmatch").addClass("glyphicon-remove");
			$("#pwmatch").css("color","#FF0004");
		}
	}else{
		$("#pwmatch").addClass("glyphicon-remove");
		$("#pwmatch").css("color","#FF0004");
	} 
	
});

$("#userprofile_form").validate({

	submitHandler : function(form,event) {
		
		event.preventDefault();
		signupData = FormHelper.parseForm($(form))
		
		jQuery.ajax({
	        url: config.restserverUrl+"profile/update/do?login=true",
	        type: "POST",
	        contentType:"application/json; charset=utf-8",
	        dataType: "json",
	        data: signupData,
	        success: function(data){
				console.log(data)
				if(data['success']){
					appstatus=true;
					//user_session_id
					localStorage.setItem("appstatus",appstatus)
					localStorage.setItem("user_session_id",data['user_session_id'])
					console.log(data['message'])
					localStorage.setItem("appuser",data['name'])
					appstaus();
					$("#form_signup")[0].reset();
					$.notify({
						icon: 'glyphicon glyphicon-thumbs-up',
						message: "Registered successfully, welcome to Express Right",
						type: 'success'
					});
					var magnificPopup = $.magnificPopup.instance; 
					// save instance in magnificPopup variable
					magnificPopup.close(); 
				}
			}
	    }); 
	},
	// Do not change code below
	errorClass : "text-danger",
	errorPlacement : function(error, element) {
		error.insertAfter(element.parent());
	} 
});

$("#enableeditprofile").on("click",function(){
	$("#full_name").attr("disabled",false);
	$("#email").attr("disabled",false);
	$("#password1").attr("disabled",false);
	$("#password_confirmation").attr("disabled",false);
	$(".saveeditprofile").attr("disabled",false);
	 
});

$(".canceleditprofile").on("click",function(){
	$("#full_name").attr("disabled",true);
	$("#email").attr("disabled",true);
	$("#password1").attr("disabled",true);
	$("#password_confirmation").attr("disabled",true);
	$(".saveeditprofile").attr("disabled",true);

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
