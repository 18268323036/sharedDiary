package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import com.heartBar.sharedDiary.common.util.DateUtil;
import com.heartBar.sharedDiary.dto.DiaryFolder;
import com.heartBar.sharedDiary.dto.JsonResult;
import com.heartBar.sharedDiary.service.DiaryFolderService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zhangxy 2017/10/11 14:58
 */
@Controller
public class DiaryFolderController extends BaseController{

    @Resource
    private DiaryFolderService diaryFolderService;

    /**
     * 添加文件夹
     * @param name
     * @return
     */
    @RequestMapping(value = "addFolder")
    public Object addFolder(String name){
        if(StringUtils.isEmpty(name)){
            name = DateUtil.dateToFormatStr(new Date(),DateUtil.DATE_FORMATE_DAY)+"日记";
        }
        DiaryFolder diaryFolder = new DiaryFolder();
        diaryFolder.setName(name);
        diaryFolder.setUserId(getUserId());
        int count = diaryFolderService.addFolder(diaryFolder);
        if(count>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }
        return new JsonResult<>(ResultEnum.ADD_ERROR);
    }

    /**
     * 删除文件夹
     * @param folderId
     * @return
     */
    @RequestMapping(value = "deleteFolder")
    public Object deleteFolder(Long folderId){
        if(folderId==null){
            throw new ValidException(ResultEnum.PARAM_ERROR);
        }
        int result = diaryFolderService.deleteFolder(folderId);
        if(result>0){
            return new JsonResult<>(ResultEnum.SUCCESS);
        }else{
            return new JsonResult<>(ResultEnum.NO_DATA_ERROR);
        }
    }


}
