package com.architecture.em.aspect;

import com.architecture.em.config.db.DataSourceTypeManager;
import com.architecture.em.config.db.DataSources;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceInterceptor.class);

    @Around(value = "execution(public * com.architecture.em.dao.*.impl.*.*(..)) and @annotation(com.architecture.em.annotation.ReadOnly)")
    public Object around(ProceedingJoinPoint joinPoint) {
        DataSourceTypeManager.set(DataSources.READ);
        LOGGER.info("Data_Source:{}", DataSourceTypeManager.get().name());
        Object rst=null;
        try {
            rst= joinPoint.proceed();
        } catch (Throwable throwable) {
            LOGGER.error("proceed exception,{}",throwable);
        }finally {
            DataSourceTypeManager.reset();
        }
     return rst;
    }
}
