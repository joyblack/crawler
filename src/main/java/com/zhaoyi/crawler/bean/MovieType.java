package com.zhaoyi.crawler.bean;

public class MovieType {
    private Integer id;
    private String freeInfo;
    private String zone;
    private String sureType;
    private String standard;
    String year;
    private String url;

    public MovieType() {
    }

    public MovieType(Integer id, String freeInfo, String zone, String sureType, String standard, String year, String url) {
        this.id = id;
        this.freeInfo = freeInfo;
        this.zone = zone;
        this.sureType = sureType;
        this.standard = standard;
        this.year = year;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFreeInfo() {
        return freeInfo;
    }

    public void setFreeInfo(String freeInfo) {
        this.freeInfo = freeInfo;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getSureType() {
        return sureType;
    }

    public void setSureType(String sureType) {
        this.sureType = sureType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MovieType{" +
                "id=" + id +
                ", freeInfo='" + freeInfo + '\'' +
                ", zone='" + zone + '\'' +
                ", sureType='" + sureType + '\'' +
                ", standard='" + standard + '\'' +
                ", year='" + year + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
