package me.vkpower.butterflyblog.admin.aspect;

import me.vkpower.butterflyblog.admin.util.ReactiveRequestContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.ast.Var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.util.Arrays;

/**
 *
 * 配置日志切面
 * 记录访问信息
 * @author xaiyuancheng
 * @date 2020/4/16 - 18:44
 */
@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* me.vkpower.butterflyblog.admin.controller.*.*(..))")
    public void log(){}

    /**
     * 记录访问
     * URL
     * IP
     * ClassMethod
     * 参数
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        Mono<URI> map = ReactiveRequestContextHolder.getRequest()
                .map(HttpRequest::getURI);

       // String IP = request1.map(request -> request.getRemoteAddress()).block().toString();
        String ClassMethod = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
//        RequestLog requestLog = new RequestLog(url,ClassMethod,IP,args);
//        logger.info("Request : {}" ,requestLog);
    }

    @After("log()")
    public void doAfter(){

        logger.info("============after===========");

    }

    @AfterReturning(pointcut = "log()",returning = "result")
    public void doAfterReturning(Object result){
        logger.info("Result: {}",result);
    }



    /**
     *封装访问信息
     * 内部类
     */

    private class RequestLog{
        private String URl;
        private String ClassMethod;
        private String IP;
        private Object[] args;

        public RequestLog(String URl, String classMethod, String IP, Object[] args) {
            this.URl = URl;
            ClassMethod = classMethod;
            this.IP = IP;
            this.args = args;
        }

        public String getURl() {
            return URl;
        }

        public void setURl(String URl) {
            this.URl = URl;
        }

        public String getClassMethod() {
            return ClassMethod;
        }

        public void setClassMethod(String classMethod) {
            ClassMethod = classMethod;
        }

        public String getIP() {
            return IP;
        }

        public void setIP(String IP) {
            this.IP = IP;
        }

        public Object[] getArgs() {
            return args;
        }

        public void setArgs(Object[] args) {
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "URl='" + URl + '\'' +
                    ", ClassMethod='" + ClassMethod + '\'' +
                    ", IP='" + IP + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }

}
