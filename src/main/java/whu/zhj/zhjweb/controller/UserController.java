package whu.zhj.zhjweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whu.zhj.zhjweb.entity.User;
import whu.zhj.zhjweb.response.ResponseWrapper;
import whu.zhj.zhjweb.service.UserService;

import javax.annotation.Resource;

/**
 * @author zhj
 * UserController
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *
     * @return
     */
    @GetMapping("/zhj")
    public ResponseWrapper signUp(User user){
        ResponseWrapper responseWrapper = ResponseWrapper.markSuccess();
        return responseWrapper;
    }
}
