package com.travel.front.utils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(targetFile.getAbsolutePath()+"/"+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static String getUploadFilePath(){
        File path = null;
        try{
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        if(!path.exists()) path = new File("");
        File filepath = new File(path.getAbsolutePath(),"static/src/pic/");
        return filepath.getAbsolutePath();
    }
}
