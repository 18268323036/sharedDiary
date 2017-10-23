package com.heartBar.sharedDiary.controller;

import com.alibaba.fastjson.JSON;
import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.common.util.DateUtil;
import com.heartBar.sharedDiary.dto.DiaryInfoDetail;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.dto.PublishDiary;
import com.heartBar.sharedDiary.service.PublishDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxy 2017/10/17 14:41
 */
@Controller
public class PublishDiaryController extends BaseController{

    @Resource
    private PublishDiaryService publishDiaryService;

    /**
     * 发布日记
     * @param publishDiary
     * @return
     */
    @RequestMapping(value = "publishDiary")
    @ResponseBody
    public Object publishDiary(PublishDiary publishDiary){
        if(publishDiary.getDiaryTextId()==null){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        publishDiary.setUserId(getUserId());
        publishDiary.setCreateTime(new Date());
        publishDiary.setShowDeadline(DateUtil.addOrSubHour(new Date(),publishDiary.getDeadTime()));
        publishDiary.setIsOverdue("0");
        PublishDiary diary = publishDiaryService.selectByDiaryId(publishDiary.getDiaryTextId());
        if(diary!=null){
            return new JsonResult<>(ResultEnum.PUBLIST_REPETETION_ERROR);
        }
        int result = publishDiaryService.publish(publishDiary);
        if(result>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }
        return new JsonResult<>(ResultEnum.ADD_ERROR);
    }

    /**
     * 查询日记列表
     * @param publishDiary
     * @return
     */
    @RequestMapping(value = "queryPublishDiary")
    @ResponseBody
    public Object queryPublishDiary(PublishDiary publishDiary){
        publishDiary.setIsOverdue("0");
        List<PublishDiary> diaryList = publishDiaryService.queryPublishDiary(publishDiary);
        return JsonResult.getOkJsonObj(diaryList);
    }

    /**
     * 查询已发布的日记
     * @return
     */
    @RequestMapping(value = "queryPublishedDiaryDetail")
    @ResponseBody
    public Object queryPublishedDiaryDetail(){
        List<DiaryInfoDetail> diaryInfoDetailList = publishDiaryService.queryPublishedDiary();
        return JsonResult.getOkJsonObj(diaryInfoDetailList);
    }

}
