package cn.tangzy.oauth2.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("usersDetailService")
public class CustomerUsersDetailService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "select username,password,authority from USER_DETAILS where username = ?";
        User user = jdbcTemplate.execute(sql, (PreparedStatement ps) -> {
            ResultSet rs = null;
            try {
                ps.setString(1, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String pass = rs.getString(2);
                    String authorize = rs.getString(3);
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority(authorize));
                    return new User(username, pass, authorities);
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }

            return null;
        });
        if (user == null) {
            throw new UsernameNotFoundException("USER NOT FOUND " + username);
        }
        return user;
    }
}
