package itsol.intership02.security.manager.authentication;

/**
 * Created by nhs3108 on 29/03/2017.
 */
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenAuthenticationService {
    private final long EXPIRATIONTIME = 864_000_000; // 10 days
    private final String SECRET = "ThisIsASecret";
    private final String TOKEN_PREFIX = "Bearer";
    private final String HEADER_STRING = "Authorization";


    public  void addAuthentication(HttpServletResponse res,  Authentication authResult) {

        System.out.println("When username exist, this function execute and after response for client");
        String JWT = Jwts.builder()
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader("Access-Control-Allow-Origin","*");
        res.addHeader("Access-Control-Allow-Headers","Authorization,timezone,Content-Type, X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Date, X-Api-Version, X-File-Name");
        res.addHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");
        res.addHeader("Access-Control-Expose-Headers","Access-Control-*,Authorization,ROLE");
        res.addHeader("Allow", "GET, POST, PUT, DELETE");
        res.addHeader("ROLE", authResult.getAuthorities().toString());
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public  Authentication getAuthentication(HttpServletRequest request,HttpServletResponse res,ApplicationContext applicationContext) {
        System.out.println("When login success, client got authentication string and give it for every request ");
        UserDetailsService userDetailsService = applicationContext.getBean(CustomUserDetailsService.class);


        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parse the token.
            System.out.println("token got");
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();


            return user != null ?
                    new UsernamePasswordAuthenticationToken
                            (user,null,userDetailsService.loadUserByUsername(user).getAuthorities()):
                    null;
        }
        System.out.println("token not got");
        res.addHeader("Access-Control-Allow-Origin","*");
        res.addHeader("Access-Control-Allow-Headers","Authorization,timezone,Content-Type, X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Date, X-Api-Version, X-File-Name");
        res.addHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE");
        res.addHeader("Access-Control-Expose-Headers","Access-Control-*,status,message");
        res.addHeader("Allow", "GET, POST, PUT, DELETE");
        res.addHeader("status","fail");
        res.addHeader("message","Username or Password incorrect");
        return null;
    }


}