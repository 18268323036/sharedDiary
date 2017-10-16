package com.heartBar.sharedDiary.service;

import com.heartBar.sharedDiary.dto.DiaryText;

import java.util.List;

/**
 * @author zhangxy 2017/10/12
 */
public interface DiaryTextService {

    int insertDiary(DiaryText diaryText);

    int deleteDiary(Long diaryId);

    List<DiaryText> queryDiary(Long folderId);

    int updateDiary(DiaryText diaryText);
}
