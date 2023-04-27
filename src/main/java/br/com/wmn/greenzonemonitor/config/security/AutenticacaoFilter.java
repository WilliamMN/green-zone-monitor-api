package br.com.wmn.greenzonemonitor.config.security;

import br.com.wmn.greenzonemonitor.config.security.jwt.GerenciadorTokenJwt;
import br.com.wmn.greenzonemonitor.service.usuario.autenticacao.AutenticacaoService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
public class AutenticacaoFilter extends OncePerRequestFilter {

    private final AutenticacaoService autenticacaoService;

    private final GerenciadorTokenJwt gerenciadorTokenJwt;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = null;
        String jwtToken = null;

        String requestTokenHeader = request.getHeader("Authorization");

        if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);

            try {
                username = gerenciadorTokenJwt.getUsernameFromToken(jwtToken);
            } catch (ExpiredJwtException e) {
                log.info("[FALHA NA AUTENTICAÇÃO] - Token expirado, usuario {} - {}", e.getClaims().getSubject(), e.getMessage());

                log.trace("[FALHA NA AUTENTICAÇÃO] - stack trace: ", e);

                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }

        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            addUsernameInContext(request, username, jwtToken);
        }

        filterChain.doFilter(request, response);
    }

    private void addUsernameInContext(HttpServletRequest request, String username, String jwtToken) {
        UserDetails userDetails = autenticacaoService.loadUserByUsername(username);

        if (gerenciadorTokenJwt.validateToken(jwtToken, userDetails)) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
}
