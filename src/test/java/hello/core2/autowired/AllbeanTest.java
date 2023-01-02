package hello.core2.autowired;

import hello.core2.AutoAppConfig;
import hello.core2.discount.DiscountPolicy;
import hello.core2.member.Grade;
import hello.core2.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllbeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountServuce.class);

        DiscountServuce discountServuce = ac.getBean(DiscountServuce.class);

        Member member = new Member(1L, "userA", Grade.VIP);

        int discountPrice = discountServuce.discount(member, 10000, "fixDiscountPolicy");

        assertThat(discountServuce).isInstanceOf(DiscountServuce.class);
        assertThat(discountPrice).isEqualTo(1000);


        int rateDiscountPrice = discountServuce.discount(member, 20000, "rateDiscountPolicy");

        assertThat(rateDiscountPrice).isEqualTo(2000);



    }


    static class DiscountServuce {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;


        DiscountServuce(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price ,String discountCode ) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member,price);
        }
    }
}
