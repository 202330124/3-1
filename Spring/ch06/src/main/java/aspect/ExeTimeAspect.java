package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {
    // Pointcut: 공통 기능을 적용할 대상을 설정한다.
    // chapter06 패키지와 그 하위 패키지에 public 메서드

    @Pointcut("execution(public * chapter06..*(..))")
    private void publicTarget() {}

    @Around("publicTarget()")
    public Object main(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        }

        finally {
            long end = System.nanoTime();

            Signature signature = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행시간: %d ns\n", joinPoint.getTarget().getClass().getSimpleName(), signature.getName(), Arrays.toString(joinPoint.getArgs()), (end - start));
        }
    }
}