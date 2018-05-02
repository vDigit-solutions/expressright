<style>
#content{
	max-width: 81vw;
    margin-left: 5px;
    padding: 0px 56px 0px 56px;
}
.resent-grid>input[type='checkbox']{
	box-shadow: 0 0 2px rgba(0, 0, 0, 0.4);
    opacity: 0;
    position: absolute;
    right: 10%;
    top: 2%;
    z-index: 1;
    
}
.resent-grid>input[type='checkbox']:checked{
	opacity : 0.7;
}
.resent-grid:hover>input[type='checkbox']{
	opacity : 0.9;
}

</style>
               <form name="video-list" class="video-list">
                <div class="main-grids">
               
					<!-- <button class="btn btn-danger pull-right deletevideoBtn hidden">Delete Video</button> -->
				
				<div id="top-grids">
					
					
					
					<!-- <a class="callbacks_nav callbacks1_nav prev" href="#">Previous</a><a class="callbacks_nav callbacks1_nav next" href="#">Next</a> -->
					<div class="clearfix"> </div>
				</div>
				
				<div class="" style="min-height: 35px">
					<button class="btn btn-danger pull-right deletevideoBtn hidden">Delete Video</button>
				</div>
				
			</div>
			<input type="hidden" name="user_session_id">
               </form>
		<div style="visibility: hidden;display: none;" id="gridTemplate">
			<div class="col-md-3 resent-grid recommended-grid slider-top-grids">
			<input type="checkbox" class="selectVideo" name='video_ids[]' value="{video_id}">
						<div class="resent-grid-img recommended-grid-img">
							<a href="#include/single.jsp?video_id={video_id}"><img src="{thumbnail_url}" alt=""></a>
							<div class="time">
								<p>{video_duration}</p>
							</div>
							<div class="clck">
								<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
							</div>
						</div>
						<div class="resent-grid-info recommended-grid-info">
							<h3><a href="#include/single.jsp" class="title title-info">{video_name}</a></h3>
							<ul>
								<li><p class="author author-info"><a href="#" class="author">{user_name}</a></p></li>
								<li class="right-list"><p class="views views-info">{view_count} views</p></li>
							</ul>
						</div>
					</div>
			</div>
			<div id="theme_template" class="hidden" >
				<div class="top-grids">
					<div class="recommended-info theme_id_{theme_id} theme_name_{theme_name}">
						<h3>{theme_name}</h3>
					</div>
					<!-- <a class="callbacks_nav callbacks1_nav prev" href="#">Previous</a><a class="callbacks_nav callbacks1_nav next" href="#">Next</a> -->
					
					<div class="clearfix"> </div>
				</div>
			</div>
	<script type="text/javascript">
	document["video-list"]["user_session_id"].value=localStorage.getItem("user_session_id")
	function loadAllVideo(){
		
		$.getJSON(config.restserverUrl+"loadUserVideos",{session_id:localStorage.getItem("user_session_id")},function(data){
			
			data.forEach(function(theme){    
				
				$("#top-grids").append(nano($("#theme_template").html(), theme))
				
				theme.videos.forEach(function(video){
					
					$(".theme_id_"+theme.theme_id).after(nano($("#gridTemplate").html(),video))
				})
				
				
			});	
			
		})
		
	}
	$(loadAllVideo);
	$(document).on('click',".selectVideo",function(){
		
		if($(".selectVideo:checked").length>0){
			$(".deletevideoBtn").removeClass("hidden")
		}else{
			$(".deletevideoBtn").addClass("hidden")
		}
	})
	
	$(".deletevideoBtn").on("click",function(){
		//event.preventDefault();
		//$(".video-list").submit();
		/* jQuery.ajax({
	        url: config.restserverUrl+"videos/deleteVideos",
	        type: "POST",
	        contentType:"application/json; charset=utf-8",
	        dataType: "json",
	        data: $(".video-list").serializeArray(),
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
	    }); */
	})
	
	 $(".video-list").validate({
	
	submitHandler : function(form,event) {
		
		event.preventDefault();
		
		jQuery.ajax({
	        url: config.restserverUrl+"videos/deleteVideos",
	        type: "POST",
	        //contentType:"application/json; charset=utf-8",
	       // dataType: "json",
	        data: $(form).serializeArray(),
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
		