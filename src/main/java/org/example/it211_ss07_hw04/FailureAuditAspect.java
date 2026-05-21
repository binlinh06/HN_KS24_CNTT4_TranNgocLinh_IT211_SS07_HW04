package org.example.it211_ss07_hw04;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FailureAuditAspect {

    @AfterThrowing(
            pointcut = "execution(* com.example.elearning.service..*(..))",
            throwing = "ex"
    )
    public void logServiceFailure(
            JoinPoint joinPoint,
            Exception ex
    ) {

        String methodName =
                joinPoint.getSignature().getName();

        System.out.println(
                "[AUDIT LOG] Method lỗi: "
                        + methodName
                        + " | Exception: "
                        + ex.getMessage()
        );
    }
}
