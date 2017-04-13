package com.apple.aspect;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.util.StopWatch;


public class SearchServiceTimingLogAspect {
  private final Logger LOG = LogManager.getLogger("search-log");

  //@Around("execution(* com.apple..*.*(..))")
  public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    Object retVal = joinPoint.proceed();

    stopWatch.stop();

    long totalTimeMillis = stopWatch.getTotalTimeMillis();
    Signature signature = joinPoint.getSignature();
    Object[] oArgs = joinPoint.getArgs();
    String args = StringUtils.join(oArgs, ",");
    LOG.info("Execution time: {} ms, {} {}({}) ", totalTimeMillis, signature.getDeclaringTypeName(),
        signature.getName(), args);

    return retVal;
  }
}
