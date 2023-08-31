//회원 정보를 담는 Entity Class

package edu.pnu.domain;

import java.time.LocalDate;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Setter
@Getter
@Table(name = "user_db")
public class UserEntity {
    @Id
    private String username;
    private String password;
    @Transient
    // DB에 저장하지 않아도 됨. Test 후 DB 열 수정 예정.
    private String user_pw_chk;
    private String name;
    private String email;
    private LocalDate birth;
    private String authority;

    // public Collection<? extends GrantedAuthority> getAuthority() {
    // return AuthorityUtils.createAuthorityList(authority);
    // }

}
