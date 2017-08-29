package com.cx.service;

import com.cx.domain.Girl;
import com.cx.enums.ResultEnum;
import com.cx.exception.GirlException;
import com.cx.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("F");
        girlA.setAge(22);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBB");
        girlB.setAge(21);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age<10){
           throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>10 && age<16){
           throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
