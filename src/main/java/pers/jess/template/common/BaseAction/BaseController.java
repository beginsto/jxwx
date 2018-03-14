package pers.jess.template.common.BaseAction;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 组装返回结果
     * @param status
     * @param message
     * @param data
     * @return
     */
    protected String packResult(int status, String message, String data){
        Map<String, Object> map = new HashMap<>();
        map.put("resultCode",status);
        map.put("message",message);
        map.put("data",data);
        return JSON.toJSONString(map);
    }
}
