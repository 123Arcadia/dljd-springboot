package org.example.Config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
@EnableAspectJAutoProxy
public class SpringConfig {
}