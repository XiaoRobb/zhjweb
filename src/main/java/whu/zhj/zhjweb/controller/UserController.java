package whu.zhj.zhjweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.response.ResponseWrapper;
import whu.zhj.zhjweb.service.UserService;

import javax.annotation.Resource;

/**
 * @author zhj
 * UserController
 */
@Controller
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *
     * @return
     */
    public ResponseWrapper signUp(User user){
        ResponseWrapper
    }
}
