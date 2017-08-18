package com.cx.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    //组合注解，下面的功能与上面整个的功能相同
    //@GetMapping(value = "/say")
    public String say(@PathVariable("id") Integer id){
       return "id:"+id;
    }
}
