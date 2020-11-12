package com.example.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class JsonUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule();
        module.addSerializer(Date.class, new JacksonDateJsonSerializer());
        module.addDeserializer(Date.class, new JacksonDateJsonDeserializer());
        //null的字段不输出,减少数据量,也避免.NET系统用基本类型反序列化本系统的包装类型字段,导致出错
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.registerModule(module);
    }

    public static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public static Map<String, Object> json2Map (String s) {
        try {
            return objectMapper.readValue(s, Map.class);
        } catch (IOException e) {
            LOGGER.error("string to Json error, return null", e);
            return null;
        }
    }

    /**
     * 使用Jackson序列化字符串,出异常后写日志但不抛异常
     *
     * @return
     */
    public static String writeObjectAsStringSilently(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Json to String error, return null", e);
            return null;
        }
    }

    /**
     * 使用Jackson序列化字符串,出异常后写日志&抛异常
     *
     * @return
     */
    public static String writeObjectAsString(Object object) throws Exception {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("Jackson Convert Object to String error, return null", e);
            throw new Exception("Jackson转字符串时报错", e);
        }
    }

    public static void decodeJSONObject(String prefix, Object obj, Map<String, Object> map) {
        if (obj instanceof JSONObject) {
            JSONObject json = ((JSONObject) obj);
            Iterator<String> keys = ((JSONObject) obj).keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                Object o = json.get(key);
                String pre = String.join(".", new String[]{prefix, key});
                if (o instanceof JSONObject || o instanceof JSONArray) {
                    decodeJSONObject(pre, o, map);
                } else {
                    map.put(pre, o);
                }
            }
        } else if (obj instanceof JSONArray) {
            Iterator iterator = ((JSONArray) obj).iterator();
            while (iterator.hasNext()) {
                Object ob = iterator.next();
                if (ob instanceof JSONObject || ob instanceof JSONArray) {
                    decodeJSONObject(prefix, ob, map);
                } else {
                    map.put(prefix, ob);
                }
            }
        }
    }

    /**
     * 将字符串转为Java对象
     *
     * @param data
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T readValue(String data, Class<T> c) throws Exception {
        try {
            return objectMapper.readValue(data, c);
        } catch (Exception e) {
            LOGGER.error("Jackson Convert String to Object error, return null", e);
            throw new Exception("Jackson转对象时报错", e);
        }
    }

    public static <T> T readValue(String data, TypeReference c) throws Exception {
        try {
            return objectMapper.readValue(data, c);
        } catch (Exception e) {
            LOGGER.error("Jackson Convert String to Object error, return null,data:{}", data, e);
            throw new Exception("Jackson转对象时报错", e);
        }
    }


    private static class JacksonDateJsonSerializer extends JsonSerializer<Date> {

        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            jsonGenerator.writeString(dateFormat.format(date));
        }
    }

    private static class JacksonDateJsonDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return dateFormat.parse(jsonParser.getText());
            } catch (ParseException e) {
                throw new RuntimeException("时间转换错误", e);
            }
        }
    }
}
