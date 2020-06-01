package pl.haladyj.ss15_ex1_AS.configuration;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
        import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
        import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
        import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
        import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
        import org.springframework.security.oauth2.provider.token.TokenStore;
        import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

        import javax.sql.DataSource;

@EnableAuthorizationServer
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("client")
                .secret("secret")
                .authorities("read")
                .authorizedGrantTypes("password","refresh_token");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userDetailsService);
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenStore(tokenStore());
    }

    @Bean
    public TokenStore tokenStore(){
        return new JdbcTokenStore(dataSource);

    }
}
