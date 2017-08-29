package com.cx.controller;

import com.cx.domain.Girl;
import com.cx.domain.Result;
import com.cx.repository.GirlRepository;
import com.cx.service.GirlService;
import com.cx.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /*
    * 查询女生列表
    * */
    @GetMapping(value = "girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 新增一个女生
     **/
    @PostMapping(value = "girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    //查询一个女生

    @GetMapping(value = "/girls/{id}")
    public Girl FindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
