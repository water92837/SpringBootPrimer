package com.example.aoplogdemo.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by SJS
 * Date:2020-12-31
 * Desc:实现基于类的切面逻辑
 */
@Aspect  //使用注解的方式定义一个切面
@Component  //把切面当作一个组件交给 Spring 管理
@Order(100) //AOP切面执行顺序， @Before 数值越小越先执行，@After 和 @AfterReturning 数值越大越先执行
public class WebLogAspectOfClass {

    private static final Logger logger = LoggerFactory.getLogger(WebLogAspectOfClass.class);

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * 横切点
     * within()限制连接点匹配指定的类型 如包名前缀(com.example.aoplogdemo.controller.*)
     * @within() 限制连接点匹配指定注解(ControllerWebLogOfClass)所标注的类型
     */
    @Pointcut("@within(com.example.aoplogdemo.common.aop.ControllerWebLogOfClass)") //切入点表达式
    public void webLog() {} //方法签名 代表切入点表达式 返回值必须是 void

    /**
     * webLog() 等价于切入点表达式 @within(com.example.aoplogdemo.common.aop.ControllerWebLogOfClass)
     * 匹配使用注解ControllerWebLogOfClass的类
     * Desc：接收请求，并记录数据
     * @param joinPoint 连接点对象
     */
    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("----------------基于类的切面通知@Before开始执行---------------- ");
        // 接收到请求
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        //记录请求内容 threadInfo存储所有内容
        Map<String, Object> threadInfo = new HashMap<>();
        logger.info("URL : " + request.getRequestURL());
        threadInfo.put("url", request.getRequestURL());
        logger.info("URI : " + request.getRequestURI());
        threadInfo.put("uri", request.getRequestURI());
        logger.info("HTTP_METHOD : " + request.getMethod());
        threadInfo.put("httpMethod", request.getMethod());
        logger.info("REMOTE_ADDR : " + request.getRemoteAddr());
        threadInfo.put("remoteAddr", request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        threadInfo.put("classMethod",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        threadInfo.put("args", Arrays.toString(joinPoint.getArgs()));
        logger.info("USER_AGENT :"+request.getHeader("User-Agent"));
        threadInfo.put("userAgent", request.getHeader("User-Agent"));
//        logger.info("METHOD_NAME :" + controllerWebLogOfMethod.name());
//        threadInfo.put("methodName", controllerWebLogOfMethod.name());

        threadLocal.set(threadInfo);
        logger.info("----------------基于类的切面通知@Before结束执行---------------- ");
    }

    /**
     * 在切入点 return 内容之后处理逻辑;
     * 即在目标方法成功执行之后调用通知功能.
     * @param ret 绑定的目标方法返回值
     * @throws Throwable
     */
    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
        logger.info("----------------基于类的切面通知@AfterReturning开始执行---------------- ");
        Map<String, Object> threadInfo = threadLocal.get();
        threadInfo.put("response", ret);
        //处理完请求 返回内容
        logger.info("RESPONSE : " + ret);
        //保存threadInfo
        threadLocal.set(threadInfo);

        logger.info("----------------基于类的切面通知@AfterReturning结束执行---------------- ");
    }

    /**
     * 环绕通知:把整个目标方法包裹起来，在被调用前和调用之后分别调用通知功能。
     * 在环绕通知中必须显式的调用目标方法，目标方法才会执行，
     * 这个显式调用是通过ProceedingJoinPoint来实现的，
     * 可以在环绕通知中接收一个此类型的形参，spring容器会自动将该对象传入，
     * 注意这个参数必须处在环绕通知的第一个形参位置。
     *
     * Desc:获取执行时间
     * @param proceedingJoinPoint 用于调用目标方法
     * @return 环绕通知需要返回返回值，否则真正调用者将拿不到返回值，只能得到一个null
     * @throws Throwable
     */
    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("----------------基于类的切面通知@Around开始执行---------------- ");
        long startTime = System.currentTimeMillis();
        //先执行该方法到该语句后 跳转到doBefore方法->目标方法 再回到该方法此处继续往下执行完 最后执行doAfterReturning()
        Object ob = proceedingJoinPoint.proceed();//显式的调用目标方法
        Map<String, Object> threadInfo = threadLocal.get();
        Long takeTime = System.currentTimeMillis() - startTime;
        logger.info("耗时：" + takeTime);
        threadInfo.put("takeTime", takeTime);
        threadLocal.set(threadInfo);
        logger.info("----------------基于类的切面通知@Around结束执行---------------- ");
        return ob;//
    }

    /**
     * 异常处理
     * 在目标方法抛出异常之后调用通知功能
     * @param throwable
     */
    @AfterThrowing(value = "webLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        logger.info("----------------基于类的切面通知@AfterThrowing开始执行---------------- ");
        //接收到请求
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 异常信息
        logger.error("{}接口调用异常，异常信息{}", request.getRequestURI(), throwable);

        logger.info("----------------基于类的切面通知@AfterThrowing结束执行---------------- ");
    }

}
