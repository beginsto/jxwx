package pers.jess.template.exception.utils;

import com.google.common.base.Enums;
import pers.jess.template.exception.enums.GeneralExceptionEnums;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 */
public class ExceptionUtils {

    /**
     * Build a message for the given base message and root cause.
     *
     * @param message the base message
     * @param cause   the root cause
     * @return the full exception message
     */
    public static String buildMessage(String message, Throwable cause) {
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            if (message != null) {
                sb.append(message).append("; ");
            }
            sb.append("nested exception is ").append(cause);
            return sb.toString();
        } else {
            return message;
        }
    }



    /**
     * 获取异常堆栈信息
     *
     * @param e 异常
     * @return 异常堆栈信息
     */
    public static String getExcTrace(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        writer.close();
        try {
            stringWriter.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 组装返回json
     * @param message
     * @return
     */
    public static String buildMessage(String message) {
        GeneralExceptionEnums ex = getTypeOfException(message);

      //  System.out.println(signature);
        return "jsonCallBack" + "({'resultCode:'" + ex.getCode() + ",'message':'" + ex.getMessage() + "'})";
    }

    /**
     * 
     * @param e
     * @return
     */
    private static GeneralExceptionEnums getTypeOfException(String e) {
        return Enums.getIfPresent(GeneralExceptionEnums.class, e).orNull() == null ? GeneralExceptionEnums.ERROR_UNKNOWN :  Enums.getIfPresent(GeneralExceptionEnums.class, e).orNull();
    }
}
