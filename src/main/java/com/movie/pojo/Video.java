package com.movie.pojo;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
    private String videoId;

    private Byte cId;

    private String name;

    private String title;

    private String image;

    private String playurl;

    private Date showTime;

    private String country;

    private Integer playtimes;

    private Double score;

    private Byte state;

    private String introduce;

    private Category category;

    private VideoDetail videoDetail;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public VideoDetail getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(VideoDetail videoDetail) {
        this.videoDetail = videoDetail;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Byte getcId() {
        return cId;
    }

    public void setcId(Byte cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlayurl() {
        return playurl;
    }

    public void setPlayurl(String playurl) {
        this.playurl = playurl;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPlaytimes() {
        return playtimes;
    }

    public void setPlaytimes(Integer playtimes) {
        this.playtimes = playtimes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}