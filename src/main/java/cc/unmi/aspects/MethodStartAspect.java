package cc.unmi.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MethodStartAspect {

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* cc.unmi..*(..)) && @annotation(logStartTime)")
    private void logStartTimePointcut(LogStartTime logStartTime) {

    }

    @Before("logStartTimePointcut(logStartTime)")
    public void setStartTimeInThreadLocal(LogStartTime logStartTime) {
        System.out.println(logStartTime.value());
        startTime.set(System.currentTimeMillis());
        System.out.println("saved method start time in threadLocal");
    }

    public static Long getStartTime() {
        return startTime.get();
    }

    public static void clearStartTime() {
        startTime.set(null);
    }
}
