package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repositoy = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repositoy.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repositoy.save(member);

        Member result = repositoy.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(result, member);
//        Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
//        assertThat(member).isEqualTo(null);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositoy.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoy.save(member2);

        Member result = repositoy.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repositoy.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoy.save(member2);

        List<Member> result = repositoy.findAll();
    }
}
