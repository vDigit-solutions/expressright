<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <style>
	.jumbotron {
	background: #f58634 none repeat scroll 0 0;
	color: #FFF;
	border-radius: 0px;
	}
	 .jumbotron-sm { padding-top: 0px;
	padding-bottom: 0px; 
	text-align: center;
	} 
	.jumbotron small {
	color: #FFF;
	}
	.h1 small {
	font-size: 24px;
	}
	#content {
    margin-left: 5px;
    padding: 0 15px;
}
</style> 
    
<!--<div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h4>
                    Get in contact </h4>
            </div>
        </div>
    </div>
</div>-->

    <div class="row">
    	<div class="col-md-4">
            <form >
            <legend><span class="glyphicon glyphicon-globe"></span> Our office</legend>
            <address>
            	<strong style="text-decoration: underline;">USA</strong><br><br>
                <!--<strong style="text-decoration: underline;">ExpressRight Classes at</strong><br>
                3720 Honey Locust dr,<br>
                Naperville, IL 60564 <br><br>-->
              
                1952 McDowell Road,<br>
				Suite - 108,<br>
                Naperville, IL 60563 <br>
               
            </address>
            
            <address>
                <strong style="text-decoration: underline;font-weight:bold;">Support</strong><br><br>
                <a href="mailto:#">EMAIL: support@expressright.com</a>
            </address>
            </form>
        </div>
        <div class="col-md-8">
            <div class="well well-sm">
                <form id="contactus_form">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Name<sup style="color:red">*</sup></label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Email Address<sup style="color:red">*</sup></label>
								<input type="text" class="form-control" id="emailid" name="email" placeholder="Enter email id" required="required" />
                            <!--<div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="Enter email id" required="required" name="emailAddress" /></div>-->
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Reason for contact</label>
                            <select id="subject" name="subject" class="form-control" required="required" name="subject" >
                                <option value="1">General</option>
                                <option value="2">Suggestions</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message<sup style="color:red">*</sup></label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Message" maxlength="500"></textarea>
                                <h6 class="pull-right" id="count_message"></h6>
                        </div>
                    </div>
                    <div class="col-md-12">
                    	<button type="reset" class="btn btn-warning pull-right" style="margin-left: 10px">
                            Clear</button>
                        <button type="submit" class="btn btn-primary pull-right">
                            Submit</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        
    </div>

<script type="text/javascript">
var text_max = 500;
$('#count_message').html(text_max + ' remaining');

$('#message').keyup(function() {
  var text_length = $('#message').val().length;
  var text_remaining = text_max - text_length;
  
  $('#count_message').html(text_remaining + ' remaining');
});

$("#contactus_form").validate({

	submitHandler : function(form,event) {
		
		event.preventDefault();
		contactUsData = FormHelper.parseForm($(form))
		console.log(contactUsData)
		jQuery.ajax({
	        url: config.restserverUrl+"feedback/do",
	        type: "POST",
	        contentType:"application/json; charset=utf-8",
	        dataType: "json",
	        data: contactUsData,
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
</script>