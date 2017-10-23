package com.heartBar.sharedDiary.dao;

import com.heartBar.sharedDiary.dto.DiaryInfoDetail;
import com.heartBar.sharedDiary.dto.PublishDiary;

import java.util.List;

public interface PublishDiaryDAO {

    int deleteByPrimaryKey(Long id);

    int insert(PublishDiary record);

    int insertSelective(PublishDiary record);

    PublishDiary selectByPrimaryKey(Long id);

    PublishDiary selectByDiaryId(Long diaryId);

    List<PublishDiary> queryPublishDiary(PublishDiary record);

    int updateByPrimaryKeySelective(PublishDiary record);

    int updateByPrimaryKey(PublishDiary record);

    List<DiaryInfoDetail> queryPublishedDiary();
}