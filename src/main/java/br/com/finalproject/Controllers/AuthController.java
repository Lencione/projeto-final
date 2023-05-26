package br.com.finalproject.Controllers;

import br.com.finalproject.Entities.User;
import br.com.finalproject.Requests.LoginRequest;
import br.com.finalproject.Response.Response;
import br.com.finalproject.Services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;
import java.util.Date;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
        User user = authenticateUser(loginRequest);

        if(user == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new Response("error", "Invalid credentials.", null));
        }

        return ResponseEntity.ok().body(new Response("success", "Successfull authentication", user));
    }

    private User authenticateUser(LoginRequest loginRequest) {

        User user = userService.findByEmail(loginRequest.getEmail());
        if(user == null || !user.getPassword().equals(loginRequest.getPassword())){
            return null;
        }
        return user;
    }

    private String generateToken(String email){
        final long expirationTime = 86400000;
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }
}
