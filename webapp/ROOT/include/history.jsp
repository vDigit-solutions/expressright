
			<div class="show-top-grids">
				<div class="main-grids news-main-grids">
					<div class="recommended-info">
						<!-- <h3>History Of My Play</h3>
						<p class="history-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus efficitur, eros 
							sed suscipit porttitor, diam felis tempus odio, eget sollicitudin purus sem sit amet dolor. Integer euismod 
							non mauris commodo rutrum. Nulla risus felis, rhoncus vel est sed, consequat efficitur ante. Phasellus mi 
							sapien, accumsan vitae lobortis vitae, laoreet dapibus metus. Pellentesque id ipsum vel nibh imperdiet 
							imperdiet ac ac mauris. Suspendisse ac leo augue. Nullam venenatis massa ut pulvinar scelerisque. Duis vel 
							vehicula urna. Quisque semper vitae lectus a feugiat. Sed dignissim egestas nunc, nec suscipit mauris 
							interdum lobortis.
							<span>Duis iaculis justo nec tellus bibendum rhoncus. Phasellus quis pretium leo, sed porta ligula. Mauris 
							vitae ornare nisi, et dapibus elit. Vestibulum vel urna malesuada, bibendum orci sed, venenatis nunc. Morbi 
							dignissim est tortor, ac aliquam augue blandit at. Pellentesque pulvinar convallis augue, in sodales risus 
							feugiat et. Ut viverra pellentesque tellus eu consectetur. Maecenas eget massa nulla. Fusce convallis et 
							sapien a hendrerit. Etiam viverra maximus dolor, ac tempor sapien.
							</span>
						</p> -->
						<div class="history-grids">
							<!-- <div class="col-md-1 history-left">
								<p>2001</p>
							</div>
							<div class="col-md-11 history-right">
								<h5>Praesent a dui sit amet turpis tempus gravida eu quis mi</h5>
								<p>Morbi eget malesuada nunc. Nullam ac congue ipsum, non tristique orci. Sed placerat porta justo, at sollicitudin velit. Curabitur sed hendrerit justo, eu vehicula lorem.
								Morbi eget malesuada nunc. Nullam ac congue ipsum, non tristique orci. Sed placerat porta justo, at sollicitudin velit. Curabitur sed hendrerit justo, eu vehicula lorem.</p>
							</div> -->
							<div class="clearfix"> </div>
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
							
					</div>
				</div>
			</div>
		<script type="text/javascript">
		
		$.getJSON(config.restserverUrl+"historyVideos",{user_session_id:localStorage.getItem("user_session_id")},function(videos){
			
			videos.forEach(function(video){
				
				$(".history-grids").after(nano($("#gridTemplate").html(),video))
			})
			
		})
		
		</script>