本项目使用maven+spring+axis2实现了webService服务的开发工作
项目目录说明：
+webService
    -src
       -main
        -java
            +com.ws  webservice相关服务类
            PRCMainTest     webservice client 测试类
            SampleService
        -resources   项目配置文件
        -webapp
            -WEB-INF
                +services   在此处配置service.xml
                web.xml     项目配置
            index.jsp
    -pom.xml