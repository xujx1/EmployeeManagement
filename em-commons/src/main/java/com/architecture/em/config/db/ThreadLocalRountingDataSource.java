package com.architecture.em.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by xujinxin on 2017/2/24.
 */
public class ThreadLocalRountingDataSource extends AbstractRoutingDataSource {

    protected Object determineCurrentLookupKey() {
        return DataSourceTypeManager.get();
    }
}
