package cc.unmi;

import cc.unmi.service.UserService;

public class HelloAop {

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.fetchUserById(234));
    }
}
