package com.heartBar.sharedDiary.dao;

import com.heartBar.sharedDiary.dto.DiaryFolder;

import java.util.List;

public interface DiaryFolderDAO {
    int deleteByPrimaryKey(Long id);

    int insert(DiaryFolder record);

    int insertSelective(DiaryFolder record);

    DiaryFolder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DiaryFolder record);

    int updateByPrimaryKey(DiaryFolder record);

    List<DiaryFolder> queryFolder(Long userId);
}