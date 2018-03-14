package pers.jess.template.app.medium.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.jess.template.app.medium.bean.Medium;
import pers.jess.template.app.medium.service.MediumService;
import pers.jess.template.common.BaseAction.BaseController;
import pers.jess.template.common.util.DatePatternUtil;
import pers.jess.template.exception.enums.GeneralExceptionEnums;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "medium")
public class MediumController extends BaseController{

    // 上传原图存放路径
   // private  static final  String UPLOAD_PATH = "/home/jxwx/tomcat7_jxwx/webapps/jxwx/static/medium";

    // TEST
    private  static final  String UPLOAD_PATH = "/Users/mac/desktop";

    @Resource
    private MediumService mediumService;


    /**
     * 图片上传并且生成预览图
     * @param req
     * @param medium
     * @param files
     * @return
     */
    @RequestMapping(value = "upload", produces={"text/html;charset=UTF-8;","application/json;"})
    @ResponseBody
    public Object upload(HttpServletRequest req, Medium medium, @RequestParam("file") MultipartFile[] files){

        Date now = new Date();

        // 图片每天创建一个文件夹yyyyMMdd
        String folderName =  DatePatternUtil.DateToString(now);

        // 原图路径
        String path = UPLOAD_PATH + "/img_upload/" + folderName + "/";

        // 预览图路径
        String pathPre = UPLOAD_PATH + "/img_upload_preview/";

        Medium m = null;

        List<Medium> list = new ArrayList<>();

        int index = 0;

        if(null == files || files.length < 1){

            // 空文件异常
            throw new WebServiceException(GeneralExceptionEnums.EMPTY_FILE.toString());

        }

        // 遍历并保存文件
        for(MultipartFile file : files){

            m = new Medium();

            m = medium;

            // 上传原图，返回文件名
            String result = mediumService.uploadFlie(path, file);

            // 生成缩略图
            mediumService.uploadPreview(new File(path + result), pathPre + result, true);

            //
            m.setImgPreview(result);
            m.setImgOriginal(folderName + "/" + result);
            m.setOrderNum(m.getOrderNum()==null ? (0 + index) : m.getOrderNum() + index);
            list.add(m);
            index++;
        }


        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
