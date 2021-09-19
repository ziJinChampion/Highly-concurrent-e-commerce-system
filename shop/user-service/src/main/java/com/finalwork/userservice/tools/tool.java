package com.finalwork.userservice.tools;


import java.io.File;
import java.io.IOException;

//列出File的一些常用操作
public class tool {
    /**
     * 遍历指定目录下（包括其子目录）的所有文件，并删除以 lastUpdated 结尾的文件
     * @param dir 目录的位置 path
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists())
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录。");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory())
                    //递归
                    listDirectory(file);
                else{ // 删除以 lastUpdated 结尾的文件
                    String fileName = file.getName();
                    boolean isLastupdated = fileName.toLowerCase().endsWith("lastupdated");
                    if (isLastupdated){
                        boolean is_delete = file.delete();
                        System.out.println("删除的文件名 => " + file.getName() + "  || 是否删除成功？ ==> " + is_delete);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 指定maven的本地仓库
        listDirectory(new File("/usr/local/localMaven/wx"));
    }
}
