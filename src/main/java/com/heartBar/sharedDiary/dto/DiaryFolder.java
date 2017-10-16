package com.heartBar.sharedDiary.dto;

import java.io.Serializable;
import java.util.Date;

public class DiaryFolder implements Serializable{

    private static final long serialVersionUID = 4663197150190824230L;

    private Long id;

    private String name;

    private Long userId;

    private Date createTime;

    private Date modifyTime;

    private int diaryAmount;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getDiaryAmount() {
        return diaryAmount;
    }

    public void setDiaryAmount(int diaryAmount) {
        this.diaryAmount = diaryAmount;
    }
}