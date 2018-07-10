package by.nesterenok.testyourself.web.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    private static final Logger log = LogManager.getLogger(MyAspect.class);

//
//    @Pointcut(value = "execution(* by.nesterenok.testyourself.service.*.*(..))")
//    public void getPointCut() {
//    }

//    @Before(value = "execution(* by.nesterenok.testyourself.service.QuestionService.readQuestion(..))")
//    public void doSmth(JoinPoint point) {
//        log.info(point.getSignature().getDeclaringTypeName() + " " + point.getSignature().getName() + " called.");
//    }

//    @After(value = "execution(* by.nesterenok.testyourself.service.QuestionService.readQuestion(..))")
//    public void doSmth2(JoinPoint point) {
//        log.info(point.getSignature().getDeclaringTypeName() + " " + point.getSignature().getName() + " finished.");
//    }

//    @Around(value = "execution(* by.nesterenok.testyourself.service.*.*(..))")
//    public Object aroundDoSmth(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        log.info(proceedingJoinPoint.getSignature().getDeclaringTypeName() + " "
//                + proceedingJoinPoint.getSignature().getName() + " started.");
//        log.info(proceedingJoinPoint.getSignature().getDeclaringTypeName() + " "
//                + proceedingJoinPoint.getSignature().getName() + " runs with "
//                + proceedingJoinPoint.getArgs());
//       Object ret =  proceedingJoinPoint.proceed();
//        log.info(proceedingJoinPoint.getSignature().getDeclaringTypeName() + " "
//                + proceedingJoinPoint.getSignature().getName() + " finished.");
//        return ret;
//    }

//    @AfterThrowing(value = "execution(* by.nesterenok.testyourself.service.*.*(..))", throwing = "exception")
//    public void afterThrowDoSmth(JoinPoint point, Exception exception) {
//        log.info(point.getSignature().getDeclaringTypeName() + " "
//                + point.getSignature().getName()
//                + " throws exception ");
//        log.error(point.getSignature().getDeclaringTypeName() + " "
//                + point.getSignature().getName(), exception.getCause());
//    }

//    @After(value = "execution(* by.nesterenok.testyourself.service.*.*(..))")
//    public void afterFinnaly(JoinPoint point){
//        log.info(point.getSignature().getDeclaringTypeName() + " "
//                + point.getSignature().getName()
//                + " should work all the time");
//    }

//    @AfterReturning(value = "execution(* by.nesterenok.testyourself.service.*.*(..))")
//    public void afterReturning(JoinPoint point){
//        log.info(point.getSignature().getDeclaringTypeName() + " "
//                + point.getSignature().getName()
//                + " shoud work only without throwing");
//    }
}
