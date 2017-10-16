package com.heartBar.sharedDiary.dao;


import com.heartBar.sharedDiary.dto.DiaryText;

import java.util.List;

public interface DiaryTextDAO {
    int deleteByPrimaryKey(Long id);

    int insert(DiaryText record);

    int insertSelective(DiaryText record);

    DiaryText selectByPrimaryKey(Long id);

    List<DiaryText> selectByFolderId(Long folderId);

    int updateByPrimaryKeySelective(DiaryText record);

    int updateByPrimaryKeyWithBLOBs(DiaryText record);

    int updateByPrimaryKey(DiaryText record);

    int deleteByFolderId(Long folderId);

    int diaryTextCount(Long folderId);
}