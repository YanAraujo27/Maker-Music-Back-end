package app.scr.makermusic.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityBeansConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Retorna um UserDetailsService vazio para sobrepor o padrão
        return username -> {
            throw new RuntimeException("Usuário não encontrado no serviço customizado. Utilize o JWT para autenticação.");
        };
    }
}
