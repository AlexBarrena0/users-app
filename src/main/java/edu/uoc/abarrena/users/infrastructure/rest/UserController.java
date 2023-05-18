package edu.uoc.abarrena.users.infrastructure.rest;

import edu.uoc.abarrena.users.application.UserService;
import edu.uoc.abarrena.users.application.converter.UserConverter;
import edu.uoc.abarrena.users.infrastructure.rest.dto.request.LoginDto;
import edu.uoc.abarrena.users.infrastructure.rest.dto.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(UserController.BASE_PATH)
public class UserController {

    public static final String BASE_PATH = "/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDto loginDto) {
        log.trace("Login user " + loginDto);

        String token = userService.login(UserConverter.INSTANCE.toDomain(loginDto));

        return new Result<>(token, "User logged successfully");
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        log.trace("Delete user " + id);

        userService.deleteUser(id);

        return new Result<>(true, "User deleted successfully");
    }
}
