package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.common.util.DateUtil;
import com.heartBar.sharedDiary.dto.DiaryText;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.service.DiaryTextService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhangxy 2017/10/12 17:13
 */
@Controller
public class DiaryTextController extends BaseController {

    @Resource
    private DiaryTextService diaryTextService;

    @RequestMapping(value = "queryDiary")
    @ResponseBody
    public Object queryDiary(Long folderId){
        List<DiaryText> diaryTextList = diaryTextService.queryDiary(folderId);
        return JsonResult.getOkJsonObj(diaryTextList);
    }

    @RequestMapping(value = "diaryDetail")
    @ResponseBody
    public Object diaryDetail(Long diaryTextId){
        if(diaryTextId==null){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        DiaryText diaryText = diaryTextService.getDiaryDetail(diaryTextId);
        return JsonResult.getOkJsonObj(diaryText);
    }

    @RequestMapping(value = "addDiary")
    @ResponseBody
    public Object addDiary(DiaryText diaryText){
        if(StringUtils.isEmpty(diaryText.getDiaryTitle())){
            diaryText.setDiaryTitle(DateUtil.dateToFormatStr(new Date(),DateUtil.DATE_FORMATE_DAY)+"日记");
        }
        diaryText.setUserId(getUserId());
        int result = diaryTextService.insertDiary(diaryText);
        if(result>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }
        return new JsonResult<>(ResultEnum.ADD_ERROR);
    }

    @RequestMapping(value = "delDiary")
    @ResponseBody
    public Object delDiary(Long diaryTextId){
        if(diaryTextId==null){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        int result = diaryTextService.deleteDiary(diaryTextId);
        if(result>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }
        return new JsonResult<>(ResultEnum.DELETE_ERROR);
    }

    @RequestMapping(value = "updateDiary")
    @ResponseBody
    public Object updateDiary(DiaryText diaryText){
        if(diaryText==null || diaryText.getId()==null){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        int result = diaryTextService.updateDiary(diaryText);
        if(result>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }
        return new JsonResult<>(ResultEnum.UPDATE_ERROR);
    }


}
