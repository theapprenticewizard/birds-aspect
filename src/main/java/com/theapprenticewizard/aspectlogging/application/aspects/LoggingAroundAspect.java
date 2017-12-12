package com.theapprenticewizard.aspectlogging.application.aspects;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect // self explanatory, for AspectJ
@Component // this is a bean, duh
public class LoggingAroundAspect {

    private Log log = LogFactory.getLog(getClass()); // get an instance of a logger, here may be a better implementation

    @Around("execution(* com.theapprenticewizard.aspectlogging.model.service.BirdServiceImpl.findAll()) && @annotation(Loggable)") // annotations preferred
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LocalDateTime start = LocalDateTime.now();

        Throwable toThrow = null;
        Object returnValue = null;

        try {
            returnValue = proceedingJoinPoint.proceed(); // determine the value that we're proxying
        } catch (Throwable t) { // catch literally anything, because we are proxying it
            toThrow = t;
        }

        LocalDateTime stop = LocalDateTime.now();

        log.info("starting @ " + start.toString());
        log.info("finishing @ " + stop.toString());
        log.info("with duration " + stop.minusNanos(start.getNano()).getNano() + "ns");

        if (null != toThrow) // if we should catch an exception we SHOULD NOT just let it slide.
            throw toThrow; // throw the exception we caught earlier

        return returnValue; // return the value we we're supposed to throw
    }
}
