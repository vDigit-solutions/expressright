
			<div class="main-grids">
				<div class="top-grids">
					<div id="recentVideosOnly" class="recommended-info">
						<h3>Recent Videos</h3>
					</div>
					
					
					<!-- <a class="callbacks_nav callbacks1_nav prev" href="#">Previous</a><a class="callbacks_nav callbacks1_nav next" href="#">Next</a> -->
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
					</div>
					<!-- <a class="callbacks_nav callbacks1_nav prev" href="#">Previous</a><a class="callbacks_nav callbacks1_nav next" href="#">Next</a> -->
					
					<div class="clearfix"> </div>
				</div>
			</div>
<script type="text/javascript">
function recentVideos(){

	$.getJSON(config.restserverUrl+"videos/recent?pageSize=25&pageNo=1",function(data){
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
</script>