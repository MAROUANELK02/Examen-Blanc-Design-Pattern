package com.marouaneLasmak.aop;

import com.marouaneLasmak.implementation.Agent;
import com.marouaneLasmak.implementation.Transaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CachableAspect {
    private Map<String, Transaction> cache = new HashMap<>();

    @Around("@annotation(com.marouaneLasmak.aop.Cachable) && execution(* com.marouaneLasmak.implementation.Agent.maxTransactionAmount(..))")
    public Object cachableMaxTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        String agentName = ((Agent) joinPoint.getTarget()).getName();
        if (cache.containsKey(agentName)) {
            System.out.println("From the cache");
            return cache.get(agentName);
        } else {
            Object result = joinPoint.proceed();
            cache.put(agentName, (Transaction) result);
            return result;
        }
    }

    @Around("@annotation(com.marouaneLasmak.aop.Cachable) && execution(* com.marouaneLasmak.implementation.Agent.addTransaction(..))")
    public void cachableAddTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        String agentName = ((Agent) joinPoint.getTarget()).getName();
        joinPoint.proceed();
        cache.remove(agentName);
    }

}
