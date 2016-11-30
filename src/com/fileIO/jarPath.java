package com.fileIO;

import java.io.File;

/**
 * Created by tenny on 2016/11/29.
 */
public class jarPath {

    public static String getJarDir()
    {
        File file = getFile();
        if (file == null)
            return null;
        return getFile().getParent();
    }

    private static File getFile()
    {
        String path = jarPath.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try
        {
            path = java.net.URLDecoder.decode(path, "UTF-8"); // 转换处理中文及空格
        }
        catch (java.io.UnsupportedEncodingException e)
        {
            return null;
        }
        return new File(path);
    }
}
