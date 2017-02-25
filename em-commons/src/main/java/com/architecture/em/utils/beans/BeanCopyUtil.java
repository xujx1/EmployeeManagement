package com.architecture.em.utils.beans;

import com.architecture.em.utils.errorcode.CommonExceptionCode;
import com.architecture.em.utils.exception.BeanCopyException;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.MapperKey;
import ma.glasnost.orika.metadata.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 反射Copy对象，递归深拷贝
 * Created by xujinxin on 2017/2/22.
 */
public class BeanCopyUtil {

    public static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCopyUtil.class);

    public static <S, D> D copy(S sourceObject, Class<D> destinationClass) throws BeanCopyException {
        try {
            MapperKey mapperKey = new MapperKey(TypeFactory.valueOf(sourceObject.getClass()),
                    TypeFactory.valueOf(destinationClass));
            if (MAPPER_FACTORY.getClassMap(mapperKey) == null) {
                MAPPER_FACTORY.classMap(sourceObject.getClass(), destinationClass).byDefault().register();
            }
            return MAPPER_FACTORY.getMapperFacade().map(sourceObject, destinationClass);
        } catch (Exception e) {
            LOGGER.error("Copy Bean error...", e);
            throw new BeanCopyException(CommonExceptionCode.REFLECTION_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.REFLECTION_EXCEPTION.getErrorMsg(), e);
        }
    }

    public static <S, D> List<D> copyList(List<S> sourceObjectIterator, Class<S> sourceClass, Class<D> destinationClass)
            throws BeanCopyException {

        if (sourceObjectIterator == null) {
            return null;
        }
        List<D> destinationObjList;
        try {

            MapperKey mapperKey = new MapperKey(TypeFactory.valueOf(sourceClass),
                    TypeFactory.valueOf(destinationClass));
            if (MAPPER_FACTORY.getClassMap(mapperKey) == null) {
                MAPPER_FACTORY.classMap(sourceClass, destinationClass).byDefault().register();
            }
            destinationObjList = MAPPER_FACTORY.getMapperFacade().mapAsList(sourceObjectIterator, destinationClass);
        } catch (Exception e) {
            LOGGER.error("Copy Bean error...", e);
            throw new BeanCopyException(CommonExceptionCode.REFLECTION_EXCEPTION.getErrorCode(),
                    CommonExceptionCode.REFLECTION_EXCEPTION.getErrorMsg(), e);
        }
        return destinationObjList;
    }
}
