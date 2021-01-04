# 说明：
该模块在Mapper+Annotation模块基础上 **实现使用SLF4J+Logback记录日志，并按日期生成日志文件**

## 日志滚动策略：

1. 时间策略.<rollingPolicy>`的class要设置为`ch.qos.logback.core.rolling.TimeBasedRollingPolicy
2. 文件大小策略.<rollingPolicy>`的class要设置为`ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy
3. 时间与文件大小策略.<rollingPolicy>`的class要设置为`ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy



