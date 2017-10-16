package com.heartBar.sharedDiary.service;

import com.heartBar.sharedDiary.dto.DiaryFolder;

import java.util.List;

/**
 * @author zhangxy 2017/10/11
 */
public interface DiaryFolderService {

    /**
     * 添加文件夹
     * @param diaryFolder
     * @return
     */
    int addFolder(DiaryFolder diaryFolder);

    /**
     * 查询文件夹
     * @param userId
     * @return
     */
    List<DiaryFolder> queryFolder(Long userId);

    /**
     * 删除文件夹
     * @param id
     * @return
     */
    int deleteFolder(Long id);

    int updateFolder(DiaryFolder diaryFolder);



}
