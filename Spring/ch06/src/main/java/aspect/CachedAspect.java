package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(2)
public class CachedAspect {
    private Map<Integer, Object> cache = new HashMap<>();

    /*
    @Pointcut("execution(public * chapter06..*(int))")
    private void publicTarget() {

    }
    */

    // @Around("publicTarget()")
    @Around("execution(public * chapter06..*(int))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Integer num = (Integer) joinPoint.getArgs()[0];

        if(cache.containsKey(num)) {
            System.out.println("Cached Aspect: Cache에서 구함 [" + num + "] \n");
            return cache.get(num);
        }

        Object proceed = joinPoint.proceed();
        cache.put(num, proceed);
        System.out.println("Cached Aspect: Cache에 추가 [" + num + "] \n");

        return proceed;
    }
}