package com.architecture.em.utils;

import com.architecture.em.Environment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.ParseException;
import java.util.Date;

public class CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

    private static final ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();

    /**
     * 去除字符串中间和头尾的空格
     */
    public static String replaceBlank(String source) {
        if (StringUtils.isNotEmpty(source)) {
            source = source.replaceAll("\\s+", "").trim();
        }
        return source;
    }

    /**
     * toString 方法 优先返回json格式,发生异常则使用字符串格式
     */
    public static String toString(Object source) {
        try {
            if (source == null) {
                return "<null>";
            }
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            LOGGER.error("ToString异常,{}", e);
            return ToStringBuilder.reflectionToString(source, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    /**
     * date 转 string
     * yyyy-MM-dd
     */
    public static String dataFormat(Date date) {
        return DateFormatUtils.format(date, Environment.DATE_FORMAT);
    }

    /**
     * date 转 string
     * HH:mm:ss
     */
    public static String timeFormat(Date date) {
        return DateFormatUtils.format(date, Environment.TIME_FORMAT);
    }

    /**
     * date 转 string
     * yyyy-MM-dd HH:mm:ss
     */
    public static String dataTimeFormat(Date date) {
        return DateFormatUtils.format(date, Environment.DATE_TIME_FORMAT);
    }


    /**
     * string 转 date
     * yyyy-MM-dd
     */
    public static Date dataFormat(String dateStr) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, Environment.DATE_FORMAT);
        } catch (ParseException e) {
            LOGGER.error("dateStr to date异常,{}", e);
        }
        return date;
    }


    /**
     * string 转 date
     * HH:mm:ss
     */
    public static Date timeFormat(String dateStr) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, Environment.TIME_FORMAT);
        } catch (ParseException e) {
            LOGGER.error("dateStr to date异常,{}", e);
        }
        return date;
    }

    /**
     * string 转 date
     * yyyy-MM-dd HH:mm:ss
     */
    public static Date dataTimeFormat(String dateStr) {
        Date date = null;
        try {
            date = DateUtils.parseDate(dateStr, Environment.DATE_TIME_FORMAT);
        } catch (ParseException e) {
            LOGGER.error("dateStr to date异常,{}", e);
        }
        return date;
    }
}
