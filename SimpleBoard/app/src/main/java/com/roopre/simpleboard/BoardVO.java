package com.roopre.simpleboard;

public class BoardVO {
    private String profile_url;
    private String nickname;
    private String crt_dt;
    private String title;
    private String content;
    private String like_count;
    private String reply_count;

    public BoardVO(String profile_url, String nickname, String crt_dt, String title, String content, String like_count, String reply_count) {
        this.profile_url = profile_url;
        this.nickname = nickname;
        this.crt_dt = crt_dt;
        this.title = title;
        this.content = content;
        this.like_count = like_count;
        this.reply_count = reply_count;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCrt_dt() {
        return crt_dt;
    }

    public void setCrt_dt(String crt_dt) {
        this.crt_dt = crt_dt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getReply_count() {
        return reply_count;
    }

    public void setReply_count(String reply_count) {
        this.reply_count = reply_count;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "profile_url='" + profile_url + '\'' +
                ", nickname='" + nickname + '\'' +
                ", crt_dt='" + crt_dt + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", like_count='" + like_count + '\'' +
                ", reply_count='" + reply_count + '\'' +
                '}';
    }
}
