package pers.jess.template.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.List;

public class FastJsonUtil {

    /**
     * @param object
     * @return 将java对象转化为json字符串
     */
    public static String toJsonString(Object object) {
        return JSON.toJSONString(object,filter, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 添加过滤器使数据库中字段为NULL的字段为""
     */
    private static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };
    /**
     * @param json
     * @param cla
     * @param <T>
     * @return 将json字符串转化为java对象
     */
    public static <T> T toObject(String json, Class<T> cla) {
        return JSON.parseObject(json, cla);
    }

    public static <T> List<T> toList(String json, Class<T> t) {
        return JSON.parseArray(json, t);
    }

}
