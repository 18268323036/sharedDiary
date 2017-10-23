package com.heartBar.sharedDiary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxy 2017/10/18 13:36
 */
public class DiaryInfoDetail implements Serializable{

    private static final long serialVersionUID = 2305922292149304634L;

    private Long diaryId;

    private String title;

    private String content;

    private Long userId;

    private String isAnonymity;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date showDeadline;

    public Long getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(Long diaryId) {
        this.diaryId = diaryId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIsAnonymity() {
        return isAnonymity;
    }

    public void setIsAnonymity(String isAnonymity) {
        this.isAnonymity = isAnonymity;
    }

    public Date getShowDeadline() {
        return showDeadline;
    }

    public void setShowDeadline(Date showDeadline) {
        this.showDeadline = showDeadline;
    }
}
