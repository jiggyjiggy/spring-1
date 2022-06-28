package hello.hellospring;

import hello.hellospring.repository.MemberRepositoy;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepositoy());
    }

    @Bean
    public MemberRepositoy memberRepositoy() {
        return new MemoryMemberRepository();
    }
}
