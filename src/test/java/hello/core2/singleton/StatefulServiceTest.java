package hello.core2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //Thread A : A 사용자가 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);

        //Thread B : B 사용자가 20000원 주문
        int userBPrice = statefulService2. order("userB", 20000);

        //Thread A : 사용자 A 가 주문금액 조회
//        int price = statefulService1.getPrice();

        Assertions.assertThat(userBPrice ).isEqualTo(20000);



    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}