package com.heartBar.sharedDiary.dao;


import com.heartBar.sharedDiary.dto.DiaryText;

public interface DiaryTextDAO {
    int deleteByPrimaryKey(Long id);

    int insert(DiaryText record);

    int insertSelective(DiaryText record);

    DiaryText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiaryText record);

    int updateByPrimaryKeyWithBLOBs(DiaryText record);

    int updateByPrimaryKey(DiaryText record);

    int deleteByFolderId(Long folderId);
}