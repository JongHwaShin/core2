package hello.core2.singleton;

import hello.core2.AppConfig;
import hello.core2.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할ㄷ 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할ㄷ 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른것을 확인

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }
}
