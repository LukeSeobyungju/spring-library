package spring.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.library.Domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
