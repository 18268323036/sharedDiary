package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.common.aop.ServiceLog;
import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.dao.DiaryFolderDAO;
import com.heartBar.sharedDiary.dao.DiaryTextDAO;
import com.heartBar.sharedDiary.dto.DiaryFolder;
import com.heartBar.sharedDiary.service.DiaryFolderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangxy 2017/10/11 15:05
 */
@Service
public class DiaryFolderServiceImpl implements DiaryFolderService{

    @Resource
    private DiaryFolderDAO diaryFolderDAO;
    @Resource
    private DiaryTextDAO diaryTextDAO;

    @Override
    @ServiceLog("新增文件夹")
    public int addFolder(DiaryFolder diaryFolder) {
        int count = diaryFolderDAO.insert(diaryFolder);
        return count;
    }

    @Override
    @ServiceLog("查询文件夹")
    public List<DiaryFolder> queryFolder(Long userId) {
        List<DiaryFolder> diaryFolderList = diaryFolderDAO.queryFolder(userId);
        return diaryFolderList;
    }

    @Override
    @Transactional
    @ServiceLog("删除文件夹")
    public int deleteFolder(Long id) {
        int deleteTextResult = diaryTextDAO.deleteByFolderId(id);
        int result = diaryFolderDAO.deleteByPrimaryKey(id);
        if(deleteTextResult==0 && result==0){
            throw  new ValidException(ResultEnum.NO_DATA_ERROR);
        }
        return 1;
    }


}
