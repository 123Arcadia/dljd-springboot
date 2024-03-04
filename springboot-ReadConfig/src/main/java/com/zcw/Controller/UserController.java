package com.zcw.Controller;


import com.zcw.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private User_ConfigurationProperties user;
    @Autowired
    private Value_Mail mail;

    @Autowired
    private Environment environment;

    @Autowired
    private ProSrouceConfig_User proSrouce_user;
    @Autowired
    private UserBean userBean;

    /**
     * 使用@ConfigurationProperties读取(包括List、Map)
     * [注意：但是不能多个Map]
     * 读取:time=20s
     *      ns (纳秒)
     *      us (微秒)
     *      ms (毫秒)
     *      s (秒)
     *      m (分)
     *      h (时)
     *      d (天)
     * 读取文件大小: fileSize=10MB
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User_ConfigurationProperties query(@PathVariable Integer id) {
        System.out.println("user = " + user);
        return user;
        //user = User_ConfigurationProperties(name=zhangchenwei, age=18, id=999,
        // duration=null, fileSize=10485760B, list=[a, b, c],
        // map={name=xiao-li, age=20, sex=man})
    }

    /**
     * 使用@Value读取(包括Lits/Map)
     * @return
     */
    @GetMapping("/mail")
    public Value_Mail query11() {
        System.out.println("mail = " + mail);
        return mail;
        //mail = Value_Mail(hostName=smtp.163.com, port=25,
        // from=jay.xu@example.com,
        // map={name=xiao-ming, sex=man, age=20},
        // list=[xiao-ming, man, 20])
    }


    @GetMapping("/getEnv")
    public Environment queryEnv() {
        System.out.println("environment = " + environment.getProperty("mail.port"));
        // 25
        return environment;
        //environment = ApplicationServletEnvironment
        // {activeProfiles=[], defaultProfiles=[default],
        // propertySources=[MapPropertySource {name='server.ports'},
        // ConfigurationPropertySourcesPropertySource {name='configurationProperties'},
        // StubPropertySource {name='servletConfigInitParams'},
        // ServletContextPropertySource {name='servletContextInitParams'},
        // PropertiesPropertySource {name='systemProperties'},
        // OriginAwareSystemEnvironmentPropertySource {name='systemEnvironment'},
        // RandomValuePropertySource {name='random'},
        // OriginTrackedMapPropertySource {name='Config resource 'class path resource [application.properties]' via location 'optional:classpath:/''}]}

    }


    /**
     * 使用@PropertiesSrouce读取指定配置文件
     *
     * @return
     */
    @GetMapping("/proSrouce_user")
    public ProSrouceConfig_User queryProSrouce() {
        System.out.println("proSrouce_user = " + proSrouce_user);
        return proSrouce_user;
        //proSrouce_user = ProSrouceConfig_User(name=dsfasd, age=20, id=2)
    }


    /**
     * 使用@ConfigurationProperties读取到@Bean中
     */
    @GetMapping("/userBean")
    public UserBean query() {
        System.out.println("userBean = " + userBean);
        return userBean;
        //userBean = UserBean(name=beName, age=19)

    }

    /**
     * 使用 PropertiesLoaderUtils 读取配置
     * 实际还是用Environment
     */
    @GetMapping("/PropertiesLoaderUtils")
    public PropertiesLoaderUtilsPojo queryPropertiesLoaderUtils() {
        PropertiesLoaderUtilsPojo pojo = new PropertiesLoaderUtilsPojo();
        pojo.readConfig();
        System.out.println("pojo = " + pojo);
        //pojo = PropertiesLoaderUtilsPojo(first=mydlq_First, second=mydlq_Second)
        return pojo;

    }



}
