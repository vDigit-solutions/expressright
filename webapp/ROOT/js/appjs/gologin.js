/*$.backstretch(
		[ 	 "images/backgrounds/bak1.jpg" , 
	  		"images/backgrounds/bak2.jpg" ,
	  		"images/backgrounds/bak3.jpg" ,
	  		"images/backgrounds/bak4.png" ,
			  "images/backgrounds/bak5.jpg"
	  	],
	{
		duration : 5000,
		fade : 750
});*/

    FormHelper = {};

    FormHelper.parseForm = function($form){
        var serialized = $form.serializeArray();
        var s = '';
        var data = {};
        for(s in serialized){
            data[serialized[s]['name']] = serialized[s]['value']
        }
        return JSON.stringify(data);
    }



$("#form_signup").validate({
	
	submitHandler : function(form,event) {
		
		event.preventDefault();
		signupData = FormHelper.parseForm($(form))
		console.log(signupData)
		jQuery.ajax({
	        url: config.restserverUrl+"registration/do?login=true",
	        type: "POST",
	        contentType:"application/json; charset=utf-8",
	        dataType: "json",
	        data: signupData,
	        success: function(data){
				console.log(data)
				if(data.success){
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
				}else{
					$.notify({
						title: '<strong>Warning!</strong>',
						message: data.message
					},{
						type: 'danger'
					});
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

$("#recover_form").validate({
	
	submitHandler : function(form,event) {
		
		event.preventDefault();
		signupData = FormHelper.parseForm($(form))
		console.log(signupData)
		jQuery.ajax({
	        url: config.restserverUrl+"registration/forgotPassword?login=true",
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

function appstaus(){
	appstatus = localStorage.getItem("appstatus")=='true';
	if(appstatus){
		setupsatatus=false;
		$(".file").html("<a href='#include/upload.jsp' >Upload</a>")
		$(".header-top-right").load("include/signed.jsp",function(){
			$(".appuser").text(localStorage.getItem("appuser"));
		});
		$("#menu").append('<li><a href="#include/userprofile.jsp" class="song-icon"><span class="fa fa-user" aria-hidden="true" style="margin:0 1.2em 0 -0.9em;font-size: 17px"></span>My account</a></li>'+
		'<li><a href="#include/myUploads.jsp" class="news-icon"><span class="fa fa-cloud-upload" aria-hidden="true" style="margin:0 1em 0 -1em;font-size: 17px"></span>My uploads</a></li> ');
	}else{
		//localStorage.clear();
		
	}
}
$(document).on("click",".nav-sidebar li",function(){
	$(".nav-sidebar li").removeClass("active");
	$(this).addClass("active");
})
$("#signin_form").validate({
	
	submitHandler : function(form , event) {

		event.preventDefault();
		console.log(this)
		console.log(form)
		signupData = FormHelper.parseForm($(form))
		jQuery.ajax({
		url: config.restserverUrl+"auth/login/do",
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
		$("#signin_form")[0].reset();
		$.notify({
			icon: 'glyphicon glyphicon-thumbs-up',
			message: "Logged in successfully, welcome to <strong>Express Right</strong>",
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

function applogout(){
	
	jQuery.ajax({
		url: config.restserverUrl+"auth/logout/do?session_id="+localStorage.getItem("user_session_id"),
        type: "POST",
        contentType:"application/json; charset=utf-8",
        dataType: "json",
        success: function(data){
			console.log(data)
			console.log(data==true)
			if(data){
				setupsatatus=true;
				localStorage.clear();
				location.href="";
				
			}
		}
    });
}

$(document).on("click",".appsignout",function(){
	applogout();
});

$(document).on("click",".myaccount",function(){
	
	location.hash='#include/userprofile.jsp';
});
