package kbo.whoareya.player.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * Before: 대상 “메서드”가 실행되기 전에 Advice를 실행합니다.
     */
    @Before("execution(* kbo.whoareya.player.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("before : " + joinPoint.getSignature().getName());
    }

    /**
     * After : 대상 “메서드”가 실행된 후에 Advice를 실행합니다.
     */
    @After("execution(* kbo.whoareya.player.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("after : " + joinPoint.getSignature().getName());
    }

    /**
     * AfterReturning: 대상 “메서드”가 정상적으로 실행되고 반환된 후에 Advice를 실행합니다.
     */
    @AfterReturning(pointcut = "execution(* kbo.whoareya.player.controller.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("AfterReturning: " + joinPoint.getSignature().getName() + " result: " + result);
    }


    /**
     * AfterThrowing: 대상 “메서드에서 예외가 발생”했을 때 Advice를 실행합니다.
     */
    @AfterThrowing(pointcut = "execution(* kbo.whoareya.player.controller.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.warn("AfterThrowing: " + joinPoint.getSignature().getName() + " exception: " + e);
    }
}
