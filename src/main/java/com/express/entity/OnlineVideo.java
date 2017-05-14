/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.express.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mansoor
 */
@Entity
@Table(name = "online_video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OnlineVideo.findAll", query = "SELECT o FROM OnlineVideo o"),
    @NamedQuery(name = "OnlineVideo.findByVideoId", query = "SELECT o FROM OnlineVideo o WHERE o.videoId = :videoId"),
    @NamedQuery(name = "OnlineVideo.findByVideoName", query = "SELECT o FROM OnlineVideo o WHERE o.videoName = :videoName"),
    @NamedQuery(name = "OnlineVideo.findByFilePath", query = "SELECT o FROM OnlineVideo o WHERE o.filePath = :filePath"),
    @NamedQuery(name = "OnlineVideo.findByFileMimeType", query = "SELECT o FROM OnlineVideo o WHERE o.fileMimeType = :fileMimeType"),
    @NamedQuery(name = "OnlineVideo.findByThemeType", query = "SELECT o FROM OnlineVideo o WHERE o.themeType = :themeType"),
    @NamedQuery(name = "OnlineVideo.findByVideoAddedDatetime", query = "SELECT o FROM OnlineVideo o WHERE o.videoAddedDatetime = :videoAddedDatetime"),
    @NamedQuery(name = "OnlineVideo.findByVideoUpdatedDatetime", query = "SELECT o FROM OnlineVideo o WHERE o.videoUpdatedDatetime = :videoUpdatedDatetime"),
    @NamedQuery(name = "OnlineVideo.findByVideoStatus", query = "SELECT o FROM OnlineVideo o WHERE o.videoStatus = :videoStatus")})
public class OnlineVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long videoId;
    @Column(name = "video_name")
    private String videoName;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_mime_type")
    private String fileMimeType;
    @Column(name = "theme_type")
    private BigInteger themeType;
    @Column(name = "video_added_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date videoAddedDatetime;
    @Column(name = "video_updated_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date videoUpdatedDatetime;
    @Column(name = "video_status")
    private Boolean videoStatus;
    @Column(name = "user_id")
    private Long userId;

    public OnlineVideo() {
    }

    public OnlineVideo(Long videoId) {
        this.videoId = videoId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public BigInteger getThemeType() {
        return themeType;
    }

    public void setThemeType(BigInteger themeType) {
        this.themeType = themeType;
    }

    public Date getVideoAddedDatetime() {
        return videoAddedDatetime;
    }

    public void setVideoAddedDatetime(Date videoAddedDatetime) {
        this.videoAddedDatetime = videoAddedDatetime;
    }

    public Date getVideoUpdatedDatetime() {
        return videoUpdatedDatetime;
    }

    public void setVideoUpdatedDatetime(Date videoUpdatedDatetime) {
        this.videoUpdatedDatetime = videoUpdatedDatetime;
    }

    public Boolean getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(Boolean videoStatus) {
        this.videoStatus = videoStatus;
    }

   

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (videoId != null ? videoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OnlineVideo)) {
            return false;
        }
        OnlineVideo other = (OnlineVideo) object;
        if ((this.videoId == null && other.videoId != null) || (this.videoId != null && !this.videoId.equals(other.videoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.express.entity.OnlineVideo[ videoId=" + videoId + " ]";
    }
    
}
