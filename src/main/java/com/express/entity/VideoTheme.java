/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.express.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mansoor
 */
@Entity
@Table(name = "video_theme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VideoTheme.findAll", query = "SELECT v FROM VideoTheme v"),
    @NamedQuery(name = "VideoTheme.findByThemeId", query = "SELECT v FROM VideoTheme v WHERE v.themeId = :themeId"),
    @NamedQuery(name = "VideoTheme.findByThemeName", query = "SELECT v FROM VideoTheme v WHERE v.themeName = :themeName")})
public class VideoTheme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "theme_id")
    private Long themeId;
    @Column(name = "theme_name")
    private String themeName;

    public VideoTheme() {
    }

    public VideoTheme(Long themeId) {
        this.themeId = themeId;
    }

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (themeId != null ? themeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideoTheme)) {
            return false;
        }
        VideoTheme other = (VideoTheme) object;
        if ((this.themeId == null && other.themeId != null) || (this.themeId != null && !this.themeId.equals(other.themeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.express.entity.VideoTheme[ themeId=" + themeId + " ]";
    }
    
}
