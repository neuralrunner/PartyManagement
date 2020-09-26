package codes.nk.partymanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class InMemorySecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        builder
                .inMemoryAuthentication()
                .withUser("Zeus").password(encoder.encode("123")).roles("USER")
                .and()
                .withUser("Poseidon").password(encoder.encode("321")).roles("USER")
                .and()
                .withUser("Hades").password(encoder.encode("654")).roles("USER");
    }

}
