package demo.test.springsecurityjpa.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("NOT FOUND");

        }return new CustomUserDetails(user);
    }
}
