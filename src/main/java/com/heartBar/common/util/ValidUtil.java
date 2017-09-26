package com.heartBar.common.util;

import com.heartBar.common.expection.ResultEnum;
import com.heartBar.common.expection.ValidException;
import org.springframework.util.StringUtils;

/**
 * @author zhangxy 2017/9/26 15:31
 */
public class ValidUtil {

    public static void paramValid(Object...objs){
        for(Object obj:objs){
            if(obj instanceof String){
                if(StringUtils.isEmpty(obj)){
                    throw new ValidException(ResultEnum.PARAM_ERROR);
                }
            }else{
                if(obj==null){
                    throw new ValidException(ResultEnum.PARAM_ERROR);
                }
            }
        }
    }

}
