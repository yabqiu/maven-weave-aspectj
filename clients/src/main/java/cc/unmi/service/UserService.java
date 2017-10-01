package cc.unmi.service;

import cc.unmi.LogStartTime;
import cc.unmi.MethodStartAspect;

public class UserService {

    @LogStartTime("Hello World")
    public String fetchUserById(int userId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start time: " + MethodStartAspect.getStartTime());

        return "nameOf" + userId;
    }
}
