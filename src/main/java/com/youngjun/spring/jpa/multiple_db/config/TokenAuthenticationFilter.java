package com.youngjun.spring.jpa.multiple_db.config;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class TokenAuthenticationFilter extends GenericFilterBean {

    private final TokenProvider tokenProvider;
    private final String AUTH_HEADER_NAME;

    public TokenAuthenticationFilter(TokenProvider tokenProvider, String AUTH_HEADER_NAME) {
        this.tokenProvider = tokenProvider;
        this.AUTH_HEADER_NAME = AUTH_HEADER_NAME;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest) request).getHeader(AUTH_HEADER_NAME);

        if (token != null && tokenProvider.validateToken(token)) {
            // Create user dto
            TokenUser tokenUser = new TokenUser(tokenProvider.getUid(token));

            Authentication authentication = this.getAuthentication(tokenUser);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    // JWT 토큰에서 인증 정보 조회
    private Authentication getAuthentication(TokenUser tokenUser) {
        return new UsernamePasswordAuthenticationToken(tokenUser, "",
            tokenUser.getAuthorities());
    }

}
