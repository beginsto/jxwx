package pers.jess.template.app.fileUpload.service;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import pers.jess.template.app.medium.service.MediumService;
import pers.jess.template.common.util.StringRandomUtil;
import pers.jess.template.exception.ServiceException;
import pers.jess.template.exception.enums.GeneralExceptionEnums;

import java.io.File;
import java.io.IOException;

public class UploadService {

    private Logger logger = LoggerFactory.getLogger(MediumService.class);

    public String uploadFlie(String path, MultipartFile multipartFile){

        if (multipartFile.isEmpty()){
            throw new ServiceException(GeneralExceptionEnums.EMPTY_FILE.toString());
        }

        try {

            File file = new File(path);

            // 上传文件按日归类，如果当日文件不存在，则先创建文件夹
            if (!file.exists() && !file.isDirectory()){

                logger.info("创建当日文件夹==========================>>");

                // 创建文件夹
                file.mkdir();

                logger.info("创建成功");

            }

            logger.info("开始上传文件==========================>>");

            // 获取文件原始名称
            String originalFilename = multipartFile.getOriginalFilename();

            // 生成上传文件名称
            String name = StringRandomUtil.stringRandom(26)
                    + "."
                    + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            // 文件转存
            multipartFile.transferTo(new File(path + name));

            logger.info(name + "\n上传成功==========================>>");

            return name;

        }catch (ServiceException e){

            throw new ServiceException(GeneralExceptionEnums.ERROR_UPLOAD_FILE.toString());

        }catch (Exception e){

            logger.error("文件上传失败===========================>>\n"
                    + path
                    + "/"
                    + multipartFile.getOriginalFilename()
                    + "\n"
                    + "Exception:【"+ e.toString() +"】" );
            return null;
        }
    }

    /**
     * 生成预览图
     * @param source 文件 (File)
     * @param output 输出路径
     * @param keepAspectRatio  //是否按比例压缩 默认true
     */
    public void uploadPreview(File source, String output, boolean keepAspectRatio) {
        try {
            logger.info("开始生成预览图=============================>>");

            //生成预览图
            Thumbnails.of(source).size(100,100).outputQuality(1L).toFile(output);

            logger.info("预览图生成结束=============================>>");
        } catch (IOException e) {
            logger.error("预览图生成失败===========================>>"
                    + "\n"
                    + output
                    + "\n"
                    + "Exception:【"+ e.toString() +"】" );
        }
    }
}
