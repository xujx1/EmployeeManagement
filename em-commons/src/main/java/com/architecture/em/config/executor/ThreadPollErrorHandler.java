package com.architecture.em.config.executor;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

/**
 * Created by xujinxin on 2017/2/22.
 */
public class ThreadPollErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPollErrorHandler.class);
    @Override
    public void handleError(Throwable t) {
        LOGGER.error("[ThreadPoll Error] {}", ExceptionUtils.getStackTrace(t));
    }
}
