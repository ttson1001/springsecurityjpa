package demo.test.springsecurityjpa;

import demo.test.springsecurityjpa.user.User;
import demo.test.springsecurityjpa.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class SpringsecurityjpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityjpaApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        // khi chương trình chạy
        //Inser vào csdl một user
        User user = new User();
        user.setUsername("somith");
        user.setPassword(passwordEncoder.encode("1234"));
        userRepository.save(user);
        System.out.println(user);
    }
}
