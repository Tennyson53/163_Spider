package com.fileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tenny on 2016/11/29.
 */
public class fileWrite {

    public static void appendWrite(String fileName, String content) {

        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
