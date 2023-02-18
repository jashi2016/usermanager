package com.kiran.User.Controller;

import com.kiran.User.Entity.User;
import com.kiran.User.Exception.UserCustomExceptionFound;
import com.kiran.User.Service.UserInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInt userInt;

    @PostMapping("/adduser")
    public User addUser(@Valid @RequestBody User user, BindingResult response){
        String message="";
        if(response.hasErrors()){
            List<FieldError> errors = response.getFieldErrors();
            for (FieldError error : errors ) {
                message=message+error.getDefaultMessage();
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                message=message+"  ";
            }
            throw new UserCustomExceptionFound(message);
        }
        else
            return userInt.addUser(user);
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers(){
        return userInt.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userInt.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id,@RequestBody String userName){
        return userInt.updateUserById(id,userName);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUserById(@PathVariable int id){
        return userInt.deleteUserById(id);
    }
}
