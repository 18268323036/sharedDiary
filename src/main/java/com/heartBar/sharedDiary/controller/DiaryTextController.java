package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.dto.DiaryText;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.service.DiaryTextService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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



}
