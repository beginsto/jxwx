package pers.jess.template.app.ad.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.jess.template.app.ad.bean.Ad;
import pers.jess.template.app.ad.service.AdService;
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
@RequestMapping("ad")
public class AdController extends BaseController{


    //上传原图存放路径
   // private  static final  String UPLOAD_PATH = "/home/jxwx/tomcat7_jxwx/webapps/jxwx/static/adManager";

    //TEST
    private  static final  String UPLOAD_PATH = "/Users/mac/desktop";

    @Resource
    private AdService adService;

    /**
     *
     * @param req
     * @param ad
     * @param files
     * @return
     */
    @RequestMapping(value = "upload", produces={"text/html;charset=UTF-8;","application/json;"})
    @ResponseBody
    public Object upload(HttpServletRequest req, Ad ad, @RequestParam("file") MultipartFile[] files){
        Date now = new Date();

        // 上传的文件每天创建一个文件夹yyyyMMdd
        String folderName =  DatePatternUtil.DateToString(now);

        // 文件上传路径
        String path = UPLOAD_PATH + "/img_upload/" + folderName + "/";

        // 预览图路径
        String pathPre = UPLOAD_PATH + "/img_upload_preview/";

        Ad record = null;

        List<Ad> list = new ArrayList<>();

        int index = 0;

        if(null == files || files.length < 1){

            // 空文件异常
            throw new WebServiceException(GeneralExceptionEnums.EMPTY_FILE.toString());

        }


        // 遍历并保存文件
        for(MultipartFile file : files){
            record = new Ad();
            record = ad;

            // 返回文件名
            String result = adService.uploadFlie(path, file);

            // 生成缩略图
            adService.uploadPreview(new File(path + result), pathPre + result, true);

            record.setImgpre(result);
            record.setImg(folderName + "/" + result);
            record.setOrdernum(record.getOrdernum()==null ? (0 + index) : record.getOrdernum() + index);
            list.add(record);
            index++;
        }


        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
