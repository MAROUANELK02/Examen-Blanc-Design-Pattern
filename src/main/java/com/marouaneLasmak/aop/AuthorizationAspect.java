package com.marouaneLasmak.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)", argNames = "pjp,securedByAspect")
    public Object checkAuthorization(ProceedingJoinPoint pjp, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorized = false;
        for(String role: roles) {
            if(SecurityContext.hasRole(role)) {
                authorized = true;
                break;
            }
        }
        if(authorized) {
            return pjp.proceed();
        }else{
            throw new SecurityException("Unauthorized Access");
        }
    }
}
