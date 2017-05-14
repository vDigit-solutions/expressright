package com.express.vo.bean;

import java.util.List;

public class DeleteVideos{
		List<Long> video_ids;
		Long user_session_id;
		public List<Long> getVideo_ids() {
			return video_ids;
		}
		public void setVideo_ids(List<Long> video_ids) {
			this.video_ids = video_ids;
		}
		public Long getUser_session_id() {
			return user_session_id;
		}
		public void setUser_session_id(Long user_session_id) {
			this.user_session_id = user_session_id;
		}
		
	}