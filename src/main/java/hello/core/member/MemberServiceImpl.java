package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // DIP에 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 추상화에만 의존하게 됨 (DIP를 지킴)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
