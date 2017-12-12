package com.theapprenticewizard.aspectlogging.application.aspects;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAroundAspect {

    private Log log = LogFactory.getLog(getClass());

    @Around("execution(* com.theapprenticewizard.aspectlogging.model.service.BirdServiceImpl.findAll()) && @annotation(Loggable)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();

        Throwable toThrow = null;
        Object returnValue = null;

        try {
            returnValue = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            toThrow = t;
        }

        LocalDateTime stop = LocalDateTime.now();

        log.info("starting @ " + start.toString());
        log.info("finishing @ " + stop.toString());
        log.info("with duration " + stop.minusNanos(start.getNano()).getNano() + "ns");

        if (null != toThrow)
            throw toThrow;

        return returnValue;
    }
}
