package com.example.aoplogdemo.common.aop;

import java.lang.annotation.*;

/**
 * 基于方法的Web日志注解
 */
@Documented  //指明修饰的注解可以被javadoc此类的工具文档化
@Target(ElementType.METHOD) //定义Annotation能够被应用于方法
@Retention(RetentionPolicy.RUNTIME) // 定义Annotation的生命周期为运行期
public @interface ControllerWebLogOfMethod {
	 String name();//所调用接口的名称
     boolean intoDb() default false;//标识该条操作日志是否需要持久化存储
}
