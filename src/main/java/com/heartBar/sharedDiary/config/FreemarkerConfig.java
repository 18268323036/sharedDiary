package com.heartBar.sharedDiary.config;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author zhangxy 2017/10/9 10:02
 */
@Configuration
public class FreemarkerConfig {

    @Resource
    protected freemarker.template.Configuration configuration;
    @Resource
    protected org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver resolver;
    @Resource
    protected org.springframework.web.servlet.view.InternalResourceViewResolver springResolver;

    @PostConstruct
    public void  setSharedVariable() {
        configuration.setDateFormat("yyyy/MM/dd");
        configuration.setDateTimeFormat("yyyy-MM-dd HH:mm:ss");
//      setting配置
        try {
            configuration.setSetting("template_update_delay", "1");
            configuration.setSetting("default_encoding", "UTF-8");
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        //配置Spring JSP的视图解析器
        springResolver.setPrefix("/XXX/");//解析前缀后XXX路径下的jsp文件
        springResolver.setSuffix(".jsp");
        springResolver.setOrder(1);
        //配置Freemarker视图解析器
        resolver.setSuffix(".ftl"); //解析后缀为ftl的
        resolver.setCache(false); //是否缓存模板
        resolver.setRequestContextAttribute("request");//为模板调用时，调用request对象的变量名
        resolver.setOrder(0);
//        resolver.setContentType("text/html");
    }

}
