
			<div class="main-grids">
				
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
							<h3><a href="#include/single.jsp" class="title title-info">{video_name}</a></h3>
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
					<div class="clearfix"> </div>
				</div>
			</div>
<script type="text/javascript">


function loadSearchVideo(){
	
	$.getJSON(config.restserverUrl+"videos/loadAll?theme=${param.theme_id}",function(data){
		
		data.forEach(function(theme){    
			
			$(".main-grids").append(nano($("#theme_template").html(), theme))
			
			theme.videos.forEach(function(video){
				
				$(".theme_id_"+theme.theme_id).after(nano($("#gridTemplate").html(),video))
			})
			
			
		});	
		
	})
	
}
loadSearchVideo();
</script>