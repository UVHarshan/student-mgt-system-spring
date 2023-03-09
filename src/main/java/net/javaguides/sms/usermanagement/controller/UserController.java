package net.javaguides.sms.usermanagement.controller;

import net.javaguides.sms.usermanagement.entity.User;
import net.javaguides.sms.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String userRegForm(Model model) {
        User user = new User(); // Empty Student object creation
        model.addAttribute("user", user);
        return "user-register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "students";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginCheck(@RequestParam("username") String uName, @RequestParam("password") String pw) {
        System.out.println("Username " + uName + " ___ Password  " + pw);
        ////// Check whether username and pw are valid
        boolean isValid = false;

//      1) Get all users from DB
        List<User> usersList = userService.getAllUsers();  // Getting all the users into a list of User Objects
//      2) Check whether there is an user matching for entered username and pw
        for (User obj : usersList) {
            if (obj.getUsername().equals(uName) && obj.getPassword().equals(pw)) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            System.out.println("Login Success!!");
            return "home";
        } else {
            System.out.println("Login Denied!!");
            return "login";
        }

        // Further Improvements..............
//        1) Restrict user for accessing other pages
//        2) Authenticate and Authorization

    }


}
