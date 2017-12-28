package com.siping.java8.Lambda;

import java.io.File;

public class Demo1 {

    public static void main(String[] args) {
        /*File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isHidden();
            }
        });*/
        // java8的写法，找隐藏文件
        File[] hiddenFiles = new File("C:\\Users\\11934\\Desktop\\zigong_idm_test").listFiles(File::isHidden);
        for (File file : hiddenFiles) {
            System.out.println(file.getName());
        }
    }

}
