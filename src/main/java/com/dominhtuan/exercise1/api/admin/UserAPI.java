package com.dominhtuan.exercise1.api.admin;

import com.dominhtuan.exercise1.dto.UserDTO;
import com.dominhtuan.exercise1.dto.request.ChangePasswordRequest;
import com.dominhtuan.exercise1.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private UserService userService;
    @PostMapping
    @ApiOperation(value = "insert new account",
    notes = "username require do not repeat",
    response = Void.class)
    public ResponseEntity<Void> insert(@ApiParam(value = "username khong dc giong nhau",required = true)
                                           @RequestBody UserDTO userDTO){
        userService.insertUser(userDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody List<Long> userIds) throws NotFoundException {
        userService.delete(userIds);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateProfile(@RequestBody UserDTO userDTO) throws NotFoundException {
        userService.updateProfile(userDTO);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/password")
    public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        userService.changePassword(changePasswordRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("password/reset/{username}")
    public ResponseEntity<Void> resetPassword(@PathVariable String username) throws NotFoundException {
        userService.resetPassword(username);
        return ResponseEntity.ok().build();
    }
}
