package br.com.finalproject.Controllers;

import br.com.finalproject.Entities.User;
import br.com.finalproject.Dto.Response;
import br.com.finalproject.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody User user){
        try{
            return ResponseEntity.ok(new Response("success", "User registered with success!", userService.register(user)));
        }   catch (RuntimeException e){
            return ResponseEntity.badRequest().body(new Response("error", e.getMessage(),null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getUser(@PathVariable long id){
        try{
            return ResponseEntity.ok(new Response("success", "User found!", userService.findById(id)));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(new Response("error", e.getMessage(),null));
        }
    }
}
