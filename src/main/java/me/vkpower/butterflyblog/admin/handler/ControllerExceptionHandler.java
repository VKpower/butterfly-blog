package me.vkpower.butterflyblog.admin.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 *
 * 配置对Controller异常处理
 * @author xaiyuancheng
 * @date 2020/4/16 - 17:23
 */
//对Controller的监控
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());



//    @ExceptionHandler(Exception.class)
//    public Map<String,Object> exceptionHandler1(Exception e){
//        Map<String, Object> c = new HashMap<>();
//        c.put("cuowu",e.getMessage());
//        return c;
//    }
//    /**
//     * 配置日志记录异常
//     * 请求URL
//     * 再发送到错误页面
//     * @param request
//     * @param e
//     * @return
//     */
//    @ExceptionHandler
//    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
//        logger.error("Request URL : {}, Exception : {}",request.getRequestURL(),e);
//     //更具注解获取NotFoundResuorceException的ResponseStatus不为空则交给springboot处理返回
//        //到404页面
//        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null){
//            throw e;
//        }
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("url",request.getRequestURL());
//        mv.addObject("exception",e);
//        mv.setViewName("error/error");
//        return mv;
//    }

}
