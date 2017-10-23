package com.heartBar.sharedDiary.service;

import com.heartBar.sharedDiary.dto.DiaryInfoDetail;
import com.heartBar.sharedDiary.dto.PublishDiary;

import java.util.List;

/**
 * @author zhangxy 2017/10/17
 */
public interface PublishDiaryService {

    int publish(PublishDiary publishDiary);

    List<PublishDiary> queryPublishDiary(PublishDiary publishDiary);

    PublishDiary selectByPrimaryKey(Long id);

    PublishDiary selectByDiaryId(Long diaryId);

    List<DiaryInfoDetail> queryPublishedDiary();

}
