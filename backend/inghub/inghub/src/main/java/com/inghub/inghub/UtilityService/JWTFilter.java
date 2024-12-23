package com.inghub.inghub.UtilityService;

import com.inghub.inghub.UtilityModel.PersonDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JWTFilter extends OncePerRequestFilter {

    PersonDetailsService personDetailsService;
    JWTService jwtService;
    @Autowired
    public JWTFilter(PersonDetailsService personDetailsService, JWTService jwtService){
        this.jwtService = jwtService;
        this.personDetailsService =personDetailsService;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){

            token = authHeader.substring(7);

            username = jwtService.getUsernameFromToken(token);
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails personDetails = personDetailsService.loadUserByUsername(username);

            if(jwtService.validateToken(token)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(personDetails, null, personDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                Setting the user as authenticated
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }


}
