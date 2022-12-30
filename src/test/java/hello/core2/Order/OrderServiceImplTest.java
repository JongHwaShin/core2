package hello.core2.Order;

import hello.core2.discount.FixDiscountPolicy;
import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;
import hello.core2.order.Order;
import hello.core2.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){

        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}