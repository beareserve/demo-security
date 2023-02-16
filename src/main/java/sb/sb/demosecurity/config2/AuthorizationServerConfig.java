//package sb.sb.demosecurity.config2;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//
///**
// * @author Fox
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//       clients.inMemory()
//               .withClient("client")
//               .secret(passwordEncoder.encode("123123"))
//               .accessTokenValiditySeconds(3600)
//               .refreshTokenValiditySeconds(86400)
//               .redirectUris("http://www.baidu.com")
//               .scopes("all")
//               .authorizedGrantTypes("authorization_code","refresh_token","implicit");
//    }
//}
