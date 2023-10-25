package bestcommerce.test.auth;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import bestcommerce.test.modules.users.Users;
import bestcommerce.test.modules.users.UsersService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UsersService usersService;

    private List<String> publicEndpoints = Arrays.asList("users/create", "users/login", "swagger-ui", "api-docs");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);
        String requestURI = request.getRequestURI();

        if (isPublicEndpoint(requestURI)) {
            filterChain.doFilter(request, response);
        } else if (isValidToken(token)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Invalid Token !!!");
        }
    }

    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    private boolean isValidToken(String token) {
        if (token == null) {
            return false;
        }

        Users user = usersService.getByToken(token);

        if (user != null) {
            Principal principal = new CustomPrincipal(user.getId().toString());

            Authentication authentication = new UsernamePasswordAuthenticationToken(principal, token,
                    new ArrayList<>());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return true;
        }

        return false;
    }

    private boolean isPublicEndpoint(String requestURI) {
        for (String publicEndpoint : this.publicEndpoints) {
            if (requestURI.contains(publicEndpoint)) {
                return true;
            }
        }
        return false;
    }
}
