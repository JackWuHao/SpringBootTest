package com3.wuhao.test;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.*;
import java.net.URL;
import java.util.Properties;

@Configuration
@ComponentScan("com3.wuhao.test")
//@PropertySource("/Users/apple/IdeaProjects/hight_spring4/src/main/java/com3/wuhao/test/test.properties") //指定文件地址
public class ElConfig {
    @Value("LOVE YOU")
    private  String normal;

    @Value("#{systemProperties['os.name']}")
    private  String osName;

    @Value("#{T(java.lang.Math).random() * 100.00 }")
    private double randomNumber;

    @Value("#{demoService.another}")
    private String fromAnother;

   @Value("src/main/java/com3/wuhao/test/test.txt")
    private  File testFile;


    @Value("http://www.baidu.com")
    private  String testUrl;

    @Value("src/main/java/com3/wuhao/test/test.properties")
    private File bookName;

    @Autowired
    private Environment environment;
  //如果使用@Value 一定要配置一个PropertySourcesPlaceholderConfigurer的Bean
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return  new PropertySourcesPlaceholderConfigurer();
    }

    public  static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }

    static String test5(String name) throws IOException {
        String s;
        try(InputStream input = new FileInputStream(name)){
            s = readAsString(input);
        }
        return s;
    }

     static  void  getHtml(String url){
       try {
           URL targetUrl = new URL(url);
           BufferedReader read = new BufferedReader(new InputStreamReader(targetUrl.openStream(),"utf-8"));
           String line;
           while ((line = read.readLine())!=null){
               System.out.println(line);
           }
           read.close();
       }
       catch ( IOException e){
           e.printStackTrace();
       }
     }
    public  void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            String s = test5(testFile.getAbsolutePath());
//            System.out.println(testFile.getAbsolutePath());
            System.out.println(s);
            getHtml(testUrl);
//            System.out.println(IOUtils.toString(testUrl.getBytes()));
            //System.out.println(bookName);

            Resource res = new ClassPathResource("resource");
            System.out.println(res.exists());
            System.out.println(this.getClass().getResource("").getPath());
            Properties props = new Properties();
            props.load(new FileInputStream(bookName.getAbsolutePath()));
            String filepath = props.getProperty("book.author");
            System.out.println(filepath);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
