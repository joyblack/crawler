package com.zhaoyi.crawler.bean;

import java.util.Date;

public class Movie {
    private String name;
    private String url;
    private String movieType;
    private String coverImg;
    private String roleInfo;
    private String description;
    private Date issueTime;
    private String categories;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public String getRoleInfo() {
        return roleInfo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}
