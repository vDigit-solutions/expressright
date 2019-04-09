
			<div class="main-grids">
				<div class="top-grids">
				
						<div id="Photos" class="recommended-info">
					
							
							<div style="width: 50%; float:left">
							<h3>Gallery</h3>
									<img src="images/photos/img_1.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_2.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_3.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_4.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_5.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_6.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
									<img src="images/photos/img_7.png" class="mySlides" alt="Cinque Terre" width="500" height="250">
							</div>

							<div style="width: 50%; float:right">
							<h3>Events</h3>
								<!--<iframe width="500" height="250" alt="Cinque Terre" src="https://www.youtube.com/embed/FTT4UnISJSY" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>-->
								<img src="images/photos/img_event.jpg" width="500" height="250">
									
							</div>
									
					
						</div>		
						<div class="clearfix"> </div>						
					<div id="recentVideosOnly" class="recommended-info">
						<h3>Recent Videos</h3>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				
				
				
			</div>
			<div style="visibility: hidden;display: none;" id="gridTemplate">
			<div class="col-md-3 resent-grid recommended-grid slider-top-grids">
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
							<h3><a href="#include/single.jsp?video_id={video_id}" class="title title-info">{video_name}</a></h3>
							<ul>
								<li><p class="author author-info"><a href="#" class="author">{user_name}</a></p></li>
								<li class="right-list"><span class="likes likes-info">{like_count} likes</span><span class="views views-info">{view_count} views</span></li>
							</ul>
						</div>
					</div>
			</div>
			<div id="theme_template" class="hidden" >
				<div class="top-grids">
					<div class="recommended-info theme_id_{theme_id} theme_name_{theme_name}">
						<h3>{theme_name}</h3>
					</div
					<div class="clearfix"> </div>
				</div>
			</div>
<script type="text/javascript">
function recentVideos(){

	$.getJSON(config.restserverUrl+"videos/recent?pageSize=10&pageNo=5",function(data){
		$('.resent-grid','.top-grids').remove()
		data.forEach(function(video){
console.log(video)
			$("#recentVideosOnly").after(nano($("#gridTemplate").html(),video))
		})
	})
}
$(recentVideos)



function loadAllVideo(){
	
	$.getJSON(config.restserverUrl+"videos/loadAll?pageSize=4",function(data){
		
		data.forEach(function(theme){    
			
			$(".main-grids").append(nano($("#theme_template").html(), theme))
			
			theme.videos.forEach(function(video){
				
				$(".theme_id_"+theme.theme_id).after(nano($("#gridTemplate").html(),video))
			})
			
			
		});	
		
	})
	
}
$(loadAllVideo);


var slideIndex = 0;
photSlides();

function photSlides() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none"; 
    }
    slideIndex++;
    if (slideIndex > x.length) {slideIndex = 1} 
    x[slideIndex-1].style.display = "block"; 
    setTimeout(photSlides, 2000); 
}



</script>
