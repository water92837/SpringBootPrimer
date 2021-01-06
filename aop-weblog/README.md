# 说明：
该模块在logdemo模块基础上（删减了添加、删除、修改接口，只保留了查询所有User和查询单个User信息接口）引入AOP，实现2个切面（一个基于类，一个基于方法）

### 关于AOP：

面向切面编程(Aspect-oriented Programming，俗称AOP)提供了一种面向对象编程(Object-oriented Programming，俗称OOP)的补充，面向对象编程最核心的单元是类(class)，然而面向切面编程最核心的单元是切面(Aspects)。与面向对象的顺序流程不同，AOP采用的是横向切面的方式，注入与主业务流程无关的功能，例如事务管理和日志管理。

### 纵向抽取：

把相同的代码抽取出来成为公共的方法，降低耦合性。这种提取代码的方式是纵向抽取，纵向抽取的代码之间的关联关系非常密切。

### 横向抽取：

那么使用 AOP 之后，你就可以横向抽取重复代码，什么叫横向抽取呢？横向抽取也是代码提取的一种方式，不过这种方式不会修改主要业务逻辑代码，只是在此基础上添加一些与主要的业务逻辑无关的功能，AOP 采取横向抽取机制，补充了传统纵向继承体系(OOP)无法解决的重复性 代码优化(性能监视、事务管理、安全检查、缓存)，将业务逻辑和系统处理的代码(关闭连接、事务管理、操作日志记录)解耦。

### 切入点表达式的理解：

再切面中使用@Pointcut定义的一个规则表达式，用来定义连接点的拦截规则。当匹配到的方法执行时，就会按相关顺序执行相关的一些通知，来增强应用到目标对象。

### 通知分类：

- 前置通知(Before Advice): 在目标方法被调用前调用通知功能；相关的类`org.springframework.aop.MethodBeforeAdvice`
- 后置通知(After Advice): 在目标方法被调用之后调用通知功能；相关的类`org.springframework.aop.AfterReturningAdvice`
- 返回通知(After-returning): 在目标方法成功执行之后调用通知功能；
- 异常通知(After-throwing): 在目标方法抛出异常之后调用通知功能；相关的类`org.springframework.aop.ThrowsAdvice`
- 环绕通知(Around): 把整个目标方法包裹起来，在**被调用前和调用之后分别调用通知功能**相关的类`org.aopalliance.intercept.MethodInterceptor`

### 注意事项：

Spring Boot 的版本号不一样，通知的执行顺序也不一样。经过自己实验后发现如下：

```xml
<version>2.4.1</version>
2.4.1 AOP执行顺序：@Around->@Before->目标方法->@AfterReturning->@Around
<version>2.1.9.RELEASE</version>
2.1.9.RELEASE AOP执行顺序：@Around->@Before->目标方法->@Around->@AfterReturning
```



