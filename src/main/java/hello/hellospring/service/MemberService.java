package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositoy;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {


    private final MemberRepositoy memberRepositoy;

    @Autowired
    public MemberService(MemberRepositoy memberRepositoy) {
        this.memberRepositoy = memberRepositoy;
    }

    /*
    회원가입
     */
     public Long join(Member member) {
         // 같은 이름이 있는 중복 회원X

//         Optional<Member> result = memberRepositoy.findByName(member.getName());
//         result.ifPresent(m -> {
//             throw new IllegalStateException("이미 존재하는 회원입니다.");
//         });

         validateDuplicateMember(member); // 중복회원 검즘

         memberRepositoy.save(member);
         return member.getId();
     }

    private void validateDuplicateMember(Member member) {
        memberRepositoy.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    전체 회원 조회
     */
    public List<Member> findMemvers() {
        return memberRepositoy.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepositoy.findById(memberId);
    }
}
