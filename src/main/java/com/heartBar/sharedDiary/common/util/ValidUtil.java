package com.heartBar.sharedDiary.common.util;

import com.heartBar.sharedDiary.common.expection.ResultEnum;
import com.heartBar.sharedDiary.common.expection.ValidException;
import org.springframework.util.StringUtils;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangxy 2017/9/26 15:31
 */
public class ValidUtil {


    private static ValidatorFactory validatorFactory =  Validation.buildDefaultValidatorFactory();

    /** 手机号码的正则表达式 */
    public static final String MOBILE_PHONE_REG = "^((13[0-9])|(15[^4,\\D])|(18[0-9])|(17[6-8])|(14[0-9]))\\d{8}$";

    /** 手机虚拟号正则表达式 */
    public static final String VIRTUAL_PHONE_REG = "^17[0-6|8-9]\\d{8}$";

    /** 固定电话的正则表达式 */
    public static final String TELEPHONE_REG = "^(((0\\d{2,3}))(-{0,1})){0,1}(\\d{7,8})(-(\\d{3,}))?$";

    /** 身份证号码的正则表达式 */
    public static final String ID_CARD_REG = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[A-Za-z])$";

    /** 车牌号码的正则表达式 */
    public static final String CAR_NUMBER_REG = "^[\u4e00-\u9fa5]{1}[a-zA-Z]{1}[a-zA-Z_0-9]{4}[a-zA-Z_0-9_\u4e00-\u9fa5]$|^[a-zA-Z]{2}\\d{7}$";


    /**
     * 判断是否为正确的移动电话号码
     * @return false:不是; true:是
     * */
    public static boolean validateTelePhone(String telephone){
        if(StringUtils.isEmpty(telephone)){
            return false;
        }
        Pattern pattern= Pattern.compile(TELEPHONE_REG);
        Matcher macher=pattern.matcher(telephone);
        return macher.matches();
    }

    /**
     * 判断是否是虚拟号码
     */
    public static boolean validateVirtualTelePhone(String telephone){
        if(StringUtils.isEmpty(telephone)){
            return false;
        }
        Pattern pattern= Pattern.compile(VIRTUAL_PHONE_REG);
        Matcher macher=pattern.matcher(telephone);
        return macher.matches();
    }

    /**
     * 判断是否为正确的 固定电话号码（0571-88175786或057188175786）
     * @return false:不是; true:是
     * */
    public static boolean validatePhone(String mobilePhone){
        if(StringUtils.isEmpty(mobilePhone)){
            return false;
        }
        Pattern pattern= Pattern.compile(MOBILE_PHONE_REG);
        Matcher macher=pattern.matcher(mobilePhone);
        return macher.matches();
    }

    /**
     * 判断是否为正确的身份证号
     * @return false:不是; true:是
     * */
    public static boolean validateIdentityLicenseNum(String identityLicenseNum){
        if(StringUtils.isEmpty(identityLicenseNum)){
            return false;
        }
        Pattern pattern= Pattern.compile(ID_CARD_REG);
        Matcher macher=pattern.matcher(identityLicenseNum);
        return macher.matches();
    }

    /**
     *
     * @param mail 邮箱账号
     * @return
     */
    public static boolean isMail(String mail) {
        if(StringUtils.isEmpty(mail)) {
            return false;
        }
        Pattern mailRegx = Pattern.compile("^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+.[a-zA-Z]{2,4}$");
        Matcher match = mailRegx.matcher(mail);
        return match.matches();
    }

    /**
     * 是否数字
     * @param str
     * @return
     */
    public static boolean isNumberic(String str) {
        Pattern pattern = Pattern.compile("^\\d*$");
        return pattern.matcher(str).matches();
    }

    /**
     * @param \6~20位英文字母或数字
     * @return
     */
    public static boolean is6_20NumAndEng(String str) {
        if(StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern mailRegx = Pattern.compile("^[a-zA-Z0-9]{6,20}$");
        Matcher match = mailRegx.matcher(str);
        return match.matches();
    }

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
