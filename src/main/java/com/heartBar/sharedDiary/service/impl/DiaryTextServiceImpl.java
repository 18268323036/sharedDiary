package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.common.aop.ServiceLog;
import com.heartBar.sharedDiary.dao.DiaryTextDAO;
import com.heartBar.sharedDiary.dto.DiaryText;
import com.heartBar.sharedDiary.service.DiaryTextService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangxy 2017/10/12 17:03
 */
@Service
public class DiaryTextServiceImpl implements DiaryTextService {

    @Resource
    private DiaryTextDAO diaryTextDAO;

    @Override
    @ServiceLog("写入日记")
    public int insertDiary(DiaryText diaryText) {
        int result = diaryTextDAO.insert(diaryText);
        return result;
    }

    @Override
    @ServiceLog("删除日记")
    public int deleteDiary(Long diaryId) {
        int result = diaryTextDAO.deleteByPrimaryKey(diaryId);
        return result;
    }

    @Override
    @ServiceLog("查询日记")
    public List<DiaryText> queryDiary(Long folderId) {
        List<DiaryText> diaryTextList = diaryTextDAO.selectByFolderId(folderId);
        return diaryTextList;
    }

    @Override
    @ServiceLog("更新日记")
    public int updateDiary(DiaryText diaryText) {
        int result = diaryTextDAO.updateByPrimaryKey(diaryText);
        return result;
    }

    @Override
    @ServiceLog("根据id获取日记详情")
    public DiaryText getDiaryDetail(Long diaryId) {
        DiaryText diaryText = diaryTextDAO.selectByPrimaryKey(diaryId);
        return diaryText;
    }
}
