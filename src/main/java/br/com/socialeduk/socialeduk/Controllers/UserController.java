package br.com.socialeduk.socialeduk.Controllers;

import br.com.socialeduk.socialeduk.Entities.User;
import br.com.socialeduk.socialeduk.Response.Response;
import br.com.socialeduk.socialeduk.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody User user){
        try{
            User registerUser = userService.registerUser(user);
            return ResponseEntity.ok(new Response("success", "User registered with success!", registerUser));
        }   catch (RuntimeException e){
            String errorMessage = e.getMessage();
            return ResponseEntity.badRequest().body(new Response("error", e.getMessage(),null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable long id){
        try{
            User user = userService.findById(id);
            return ResponseEntity.ok(new Response("success", "User found!", user));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Response("error", e.getMessage(),null));
        }
    }
}
