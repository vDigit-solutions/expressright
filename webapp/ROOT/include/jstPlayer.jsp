<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
/***
video-js
***/
 .video-js {
      /*margin: 40px auto;*/
      float: left;
    }

    /* Position our playlist on the example page */
    .vjs-playlist {
      width: 300px;
      float: right;
    }
	
	.video-js .vjs-menu-button-inline.vjs-slider-active,.video-js .vjs-menu-button-inline:focus,.video-js .vjs-menu-button-inline:hover,.video-js.vjs-no-flex .vjs-menu-button-inline {
    width: 10em
}

.video-js .vjs-controls-disabled .vjs-big-play-button {
    display: none!important
}

.video-js .vjs-control {
    width: 3em
}

.video-js .vjs-menu-button-inline:before {
    width: 1.5em
}

.vjs-menu-button-inline .vjs-menu {
    left: 3em
}

.vjs-paused.vjs-has-started.video-js .vjs-big-play-button,.video-js.vjs-ended .vjs-big-play-button,.video-js.vjs-paused .vjs-big-play-button {
    display: block
}

.video-js .vjs-load-progress div,.vjs-seeking .vjs-big-play-button,.vjs-waiting .vjs-big-play-button {
    display: none!important
}

.video-js .vjs-mouse-display:after,.video-js .vjs-play-progress:after {
    padding: 0 .4em .3em
}

.video-js.vjs-ended .vjs-loading-spinner {
    display: none;
}

.video-js.vjs-ended .vjs-big-play-button {
    display: block !important;
}

.video-js *,.video-js:after,.video-js:before {
    box-sizing: inherit;
    font-size: inherit;
    color: inherit;
    line-height: inherit
}

.video-js.vjs-fullscreen,.video-js.vjs-fullscreen .vjs-tech {
    width: 100%!important;
    height: 100%!important
}

.video-js {
    font-size: 14px;
    overflow: hidden
}

.video-js .vjs-control {
    color: inherit
}

.video-js .vjs-menu-button-inline:hover,.video-js.vjs-no-flex .vjs-menu-button-inline {
    width: 8.35em
}

.video-js .vjs-volume-menu-button.vjs-volume-menu-button-horizontal:hover .vjs-menu .vjs-menu-content {
    height: 3em;
    width: 6.35em
}

.video-js .vjs-control:focus:before,.video-js .vjs-control:hover:before {
    text-shadow: 0 0 1em #fff,0 0 1em #fff,0 0 1em #fff
}

.video-js .vjs-spacer,.video-js .vjs-time-control {
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-flex: 1 1 auto;
    -moz-box-flex: 1 1 auto;
    -webkit-flex: 1 1 auto;
    -ms-flex: 1 1 auto;
    flex: 1 1 auto
}

.video-js .vjs-time-control {
    -webkit-box-flex: 0 1 auto;
    -moz-box-flex: 0 1 auto;
    -webkit-flex: 0 1 auto;
    -ms-flex: 0 1 auto;
    flex: 0 1 auto;
    width: auto
}

.video-js .vjs-time-control.vjs-time-divider {
    width: 14px
}

.video-js .vjs-time-control.vjs-time-divider div {
    width: 100%;
    text-align: center
}

.video-js .vjs-time-control.vjs-current-time {
    margin-left: 1em
}

.video-js .vjs-time-control .vjs-current-time-display,.video-js .vjs-time-control .vjs-duration-display {
    width: 100%
}

.video-js .vjs-time-control .vjs-current-time-display {
    text-align: right
}

.video-js .vjs-time-control .vjs-duration-display {
    text-align: left
}

.video-js .vjs-play-progress:before,.video-js .vjs-progress-control .vjs-play-progress:before,.video-js .vjs-remaining-time,.video-js .vjs-volume-level:after,.video-js .vjs-volume-level:before,.video-js.vjs-live .vjs-time-control.vjs-current-time,.video-js.vjs-live .vjs-time-control.vjs-duration,.video-js.vjs-live .vjs-time-control.vjs-time-divider,.video-js.vjs-no-flex .vjs-time-control.vjs-remaining-time {
    display: none
}

.video-js.vjs-no-flex .vjs-time-control {
    display: table-cell;
    width: 4em
}

.video-js .vjs-progress-control {
    position: absolute;
    left: 0;
    right: 0;
    width: 100%;
    height: .5em;
    top: -.5em
}

.video-js .vjs-progress-control .vjs-load-progress,.video-js .vjs-progress-control .vjs-play-progress,.video-js .vjs-progress-control .vjs-progress-holder {
    height: 100%
}

.video-js .vjs-progress-control .vjs-progress-holder {
    margin: 0
}

.video-js .vjs-progress-control:hover {
    height: 1.5em;
    top: -1.5em
}

.video-js .vjs-control-bar {
    -webkit-transition: -webkit-transform .1s ease 0s;
    -moz-transition: -moz-transform .1s ease 0s;
    -ms-transition: -ms-transform .1s ease 0s;
    -o-transition: -o-transform .1s ease 0s;
    transition: transform .1s ease 0s
}

.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-active .vjs-control-bar,.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-inactive .vjs-control-bar,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-active .vjs-control-bar,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-inactive .vjs-control-bar,.video-js.vjs-has-started.vjs-playing.vjs-user-inactive .vjs-control-bar {
    visibility: visible;
    opacity: 1;
    -webkit-backface-visibility: hidden;
    -webkit-transform: translateY(3em);
    -moz-transform: translateY(3em);
    -ms-transform: translateY(3em);
    -o-transform: translateY(3em);
    transform: translateY(3em);
    -webkit-transition: -webkit-transform 1s ease 0s;
    -moz-transition: -moz-transform 1s ease 0s;
    -ms-transition: -ms-transform 1s ease 0s;
    -o-transition: -o-transform 1s ease 0s;
    transition: transform 1s ease 0s
}

.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-active .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-inactive .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-active .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-inactive .vjs-progress-control,.video-js.vjs-has-started.vjs-playing.vjs-user-inactive .vjs-progress-control {
    height: .25em;
    top: -.25em;
    pointer-events: none;
    -webkit-transition: height 1s,top 1s;
    -moz-transition: height 1s,top 1s;
    -ms-transition: height 1s,top 1s;
    -o-transition: height 1s,top 1s;
    transition: height 1s,top 1s
}

.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-active.vjs-fullscreen .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-paused.vjs-user-inactive.vjs-fullscreen .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-active.vjs-fullscreen .vjs-progress-control,.video-js.not-hover.vjs-has-started.vjs-playing.vjs-user-inactive.vjs-fullscreen .vjs-progress-control,.video-js.vjs-has-started.vjs-playing.vjs-user-inactive.vjs-fullscreen .vjs-progress-control {
    opacity: 0;
    -webkit-transition: opacity 1s ease 1s;
    -moz-transition: opacity 1s ease 1s;
    -ms-transition: opacity 1s ease 1s;
    -o-transition: opacity 1s ease 1s;
    transition: opacity 1s ease 1s
}

.video-js.vjs-live .vjs-live-control {
    margin-left: 1em
}

.video-js .vjs-big-play-button {
    top: 50%;
    left: 50%;
    margin-left: -1em;
    margin-top: -1em;
    width: 2em;
    height: 2em;
    line-height: 2em;
    border: none;
    border-radius: 50%;
    font-size: 3.5em;
    background-color: rgba(0,0,0,.45);
    color: #fff;
    -webkit-transition: border-color .4s,outline .4s,background-color .4s;
    -moz-transition: border-color .4s,outline .4s,background-color .4s;
    -ms-transition: border-color .4s,outline .4s,background-color .4s;
    -o-transition: border-color .4s,outline .4s,background-color .4s;
    transition: border-color .4s,outline .4s,background-color .4s
}

.video-js .vjs-menu-button-popup .vjs-menu {
    left: -3em
}

.video-js .vjs-menu-button-popup .vjs-menu .vjs-menu-content {
    background-color: transparent;
    width: 12em;
    left: -1.5em;
    padding-bottom: .5em
}

.video-js .vjs-menu-button-popup .vjs-menu .vjs-menu-item,.video-js .vjs-menu-button-popup .vjs-menu .vjs-menu-title {
    background-color: #151b17;
    margin: .3em 0;
    padding: .5em;
    border-radius: .3em
}

.video-js .vjs-menu-button-popup .vjs-menu .vjs-menu-item.vjs-selected {
    background-color: #2483d5
}

.video-js .vjs-big-play-button {
    background-color: rgba(0,0,0,0.5);
    font-size: 2.5em;
    border-radius: 20%;
    height: 1.4em !important;
    line-height: 1.4em !important;
    margin-top: -0.7em !important
}

.video-js:hover .vjs-big-play-button,.video-js .vjs-big-play-button:focus,.video-js .vjs-big-play-button:active {
    background-color: #cc181e
}

.video-js .vjs-loading-spinner {
    border-color: #cc181e
}

.video-js .vjs-control-bar2 {
    background-color: #000000
}

.video-js .vjs-control-bar {
    background-color: rgba(0,0,0,0.3) !important;
    color: #ffffff;
    font-size: 12px
}

.video-js .vjs-play-progress,.video-js  .vjs-volume-level {
    background-color: #cc181e
}

.video-js .vjs-load-progress {
    background: rgba(255,255,255,0.3);
}
/***
 end of video-js custom css 
***/
</style>
			<div class="show-top-grids">
				<div class="col-sm-8 single-left">
					<div class="song" id="video_interface" style="display: none;">
					</div>
					<script type="text/javascript">
						 var player = undefined;
						 var tpl = "<div class=\"song-info\"><h3>{video_name}</h3></div><div class=\"video-grid\"><video id=\"video1\" poster=\"{thumbnail_url}\" class=\"video-js vjs-default-skin vjs-big-play-centered video-div vjs-16-9\"  controls preload=\"auto\" data-setup='{\"fluid\":true}' ><source src=\"{file_url}\" typr=\"{file_mime_type}\"></source></video></div>"
							$.getJSON(config.restserverUrl+"videos/${param.video_id} ",function(video){
								//	$('.resent-grid','.top-grids').remove()
								//alert(video.file_url)
								//console.log(video)
								//console.log(nano(tpl,video))
								$("#publishedOn").text("Published on "+video.video_uploaded_time)
								$(".view").text(video.view_count+" views");
								$("#video_description").text("Published on "+video.video_description)
								//video.mpd = video.file_url.replace(".mp4","_dash.mpd")
										$("#video_interface").html(nano(tpl,video))
										if(video.mp4Address != null && video.mp4Address.length > 0 && video.mp4Address.endsWith(".mp4")){
											$("#video1").prepend("<source src=\""+video.mp4Address+"\" type=\"video/mp4\"></source>")
										}
										
										player = videojs(document.querySelector('.video-div'));
								player.on("play",function(){
									//$.get(config.restserverUrl+"videos/playBackStarted",{video_id:${param.video_id}})
								})
								player.Resume({
						          uuid: video.video_uploaded_time
						        });
								$.get(config.restserverUrl+"videos/playBackStarted",{video_id:${param.video_id},user_session_id:localStorage.getItem("user_session_id")})
										
								})
								$("#video_interface").show();
						 </script>
					 
				</div>
			</div>
			<script type="text/javascript">
			function publish(thumb,link,name,DESCRIPTION, player)
			{
			      var feed = {
			            method: 'feed',
			            picture: thumb,
			            link: link,
			            name: name,
			            description: DESCRIPTION,
			            source: player,
			            type: 'video',
			      };

			      function callback(response){
			            if(response && response.post_id !== undefined) {
			                  alert('published');
			            }
			      }

			      FB.ui(feed, callback);
			}
			</script>