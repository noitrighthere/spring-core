package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // AnnotationConfigApplicationContext가 상위 클래스이다
         ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
         NetworkClient client = ac.getBean(NetworkClient.class);
         ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient(); // 생성자 호출
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
