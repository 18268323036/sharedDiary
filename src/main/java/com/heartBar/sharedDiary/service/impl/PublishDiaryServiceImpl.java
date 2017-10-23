package com.heartBar.sharedDiary.service.impl;

import com.heartBar.sharedDiary.common.aop.ServiceLog;
import com.heartBar.sharedDiary.dao.PublishDiaryDAO;
import com.heartBar.sharedDiary.dto.DiaryInfoDetail;
import com.heartBar.sharedDiary.dto.PublishDiary;
import com.heartBar.sharedDiary.service.PublishDiaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangxy 2017/10/17 14:22
 */
@Service
public class PublishDiaryServiceImpl implements PublishDiaryService {

    @Resource
    private PublishDiaryDAO publishDiaryDAO;

    @Override
    @ServiceLog("发布日记")
    public int publish(PublishDiary publishDiary) {
        int result = publishDiaryDAO.insert(publishDiary);
        return result;
    }

    @Override
    @ServiceLog("查询发布的日记")
    public List<PublishDiary> queryPublishDiary(PublishDiary publishDiary) {
        List<PublishDiary> diaryList = publishDiaryDAO.queryPublishDiary(publishDiary);
        return diaryList;
    }

    @Override
    @ServiceLog("根据id查询日记")
    public PublishDiary selectByPrimaryKey(Long id) {
        PublishDiary publishDiary = publishDiaryDAO.selectByPrimaryKey(id);
        return publishDiary;
    }

    @Override
    @ServiceLog("根据日记id查询日记")
    public PublishDiary selectByDiaryId(Long diaryId) {
        PublishDiary publishDiary = publishDiaryDAO.selectByDiaryId(diaryId);
        return publishDiary;
    }

    @Override
    @ServiceLog("查询发布的日记详情")
    public List<DiaryInfoDetail> queryPublishedDiary() {
        List<DiaryInfoDetail> diaryInfoDetailList = publishDiaryDAO.queryPublishedDiary();
        return diaryInfoDetailList;
    }

}
