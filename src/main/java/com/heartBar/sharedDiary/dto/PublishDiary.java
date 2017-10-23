package com.heartBar.sharedDiary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PublishDiary implements Serializable{

    private static final long serialVersionUID = 9207010428536476014L;

    private Long id;

    private Long diaryTextId;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Date showDeadline;

    private String isOverdue;

    private String isAnonymity;

    private int deadTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiaryTextId() {
        return diaryTextId;
    }

    public void setDiaryTextId(Long diaryTextId) {
        this.diaryTextId = diaryTextId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getShowDeadline() {
        return showDeadline;
    }

    public void setShowDeadline(Date showDeadline) {
        this.showDeadline = showDeadline;
    }

    public String getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(String isOverdue) {
        this.isOverdue = isOverdue == null ? null : isOverdue.trim();
    }

    public String getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(String isAnonymity) {
        this.isAnonymity = isAnonymity;
    }

    public int getDeadTime() {
        return deadTime;
    }

    public void setDeadTime(int deadTime) {
        this.deadTime = deadTime;
    }
}