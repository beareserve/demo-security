package sb.sb.demosecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lixiangyu
 * @title: AuthController
 * @projectName demo-security
 * @description：TODO
 * @date ：2023-02-15 21:57
 */
@RestController
@RequestMapping("/admin")
public class AuthController {

    @GetMapping("/demo")
    public String demo() {
        return "spring security demo";
    }
}
