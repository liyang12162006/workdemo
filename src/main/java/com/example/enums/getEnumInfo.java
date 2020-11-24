package com.example.enums;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author liyangyang
 * @date 2020/11/24 10:13
 * @since 2.4.0.0
 */
public class getEnumInfo {

    public static void main(String[] args) throws Exception {
        //指定文件夹
        List<String> fileList = new ArrayList<String>();
        File baseFile = new File(
            "/Users/htuser-7/IdeaProjects/exercisebank/exercisebank-common/src/main/java/com/huitongjy/exercisebank/common/enums");
        if (baseFile.exists()) {//开发环境，读取源文件
            getSubFileNameList(baseFile, fileList);
        }
        //指定jar包
        try {
            JarFile jarFile = new JarFile(new File(
                "/Users/htuser-7/lyy/soft/apache-maven-3.6.0/repository/com/huitongjy/common/common-util/2.0.6.2/common-util-2.0.6.2.jar"));
            Enumeration<JarEntry> en = jarFile.entries(); // 枚举获得JAR文件内的实体,即相对路径
            while (en.hasMoreElements()) {
                String name1 = en.nextElement().getName();
                if (!name1.endsWith(".class")) {//不是class文件
                    continue;
                }
                String name2 = name1.substring(0, name1.lastIndexOf(".class"));
                String name3 = name2.replaceAll("/", ".");
                fileList.add(name3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String a : fileList) {
            a = a.replaceAll("/", ".");
            a = a.replace("main.java.com.", "com.");
            if (isChildClass(a, IEnum.class)) {
                getAllEnumByClassName(a);
            }
        }

    }

    /**
     * 递归查找指定目录下的类文件的全路径
     *
     * @param baseFile 查找文件的入口
     * @param fileList 保存已经查找到的文件集合
     */
    private static void getSubFileNameList(File baseFile, List<String> fileList) {
        if (baseFile.isDirectory()) {
            File[] files = baseFile.listFiles();
            for (File tmpFile : files) {
                getSubFileNameList(tmpFile, fileList);
            }
        }
        String path = baseFile.getPath();
        if (path.endsWith(".java")) {
            String name1 = path.substring(path.indexOf("src") + 4, path.length());
            String name2 = name1.replaceAll("\\\\", ".");
            String name3 = name2.substring(0, name2.lastIndexOf(".java"));
            fileList.add(name3);
        }
    }

    /**
     * 判断一个类是否继承某个父类或实现某个接口
     */
    private static boolean isChildClass(String className, Class parentClazz) {
        if (className == null) {
            return false;
        }
        Class clazz = null;
        try {
            clazz = Class.forName(className);
            if (Objects.isNull(clazz)) {
                return false;
            }
            if (Modifier.isAbstract(clazz.getModifiers())) {//抽象类忽略
                return false;
            }
            if (Modifier.isInterface(clazz.getModifiers())) {//接口忽略
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return parentClazz.isAssignableFrom(clazz);
    }

    /**
     * 根据枚举的字符串获取枚举的值
     *
     * @param className 包名+类名
     */
    private static void getAllEnumByClassName(String className) throws Exception {
        // 1.得到枚举类对象
        Class<Enum> clz = (Class<Enum>)Class.forName(className);
        // 2.得到所有枚举常量
        Enum[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod("getValue");
        Method getMessage = clz.getMethod("getTitle");
        System.out.println("------------------------");
        System.out.println("枚举类  " + className);
        if (Objects.nonNull(objects)) {
            for (Enum obj : objects) {
                if (Objects.nonNull(obj)) {
                    System.out.println(obj.name() + " : " + getCode.invoke(obj) + " : " + getMessage.invoke(obj));
                }
            }
        }
    }
}
