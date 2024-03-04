package org.baiDuWangPan;

import org.baiDuWangPan.Service.ResourceService;
import org.baiDuWangPan.confgig.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForbadeDuWangPab {
    public static void main(String[] args) {
        /**
         * 这样可以把前后的空格删去，但中间的空格仍会判断
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourceService service = context.getBean(ResourceService.class);
        boolean flag = service.openURL("https://pan.baidu.com/xx", " root");
        System.out.println(flag); // true

    }
}
