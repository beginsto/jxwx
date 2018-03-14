package pers.jess.template.exception.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pers.jess.template.exception.ServiceException;
import pers.jess.template.exception.utils.ExceptionUtils;

@Aspect
@Component
public class WebExceptionAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void webPointcut() {}

    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e 异常对象
     */
    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    public void handleThrowing(Exception e) {
        //不需要再记录ServiceException，因为在service异常切面中已经记录过
        if (!(e instanceof ServiceException)) {
            LOGGER.error(ExceptionUtils.getExcTrace(e));
        }
    }


}
