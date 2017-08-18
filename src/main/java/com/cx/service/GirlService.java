package com.cx.service;

import com.cx.domain.Girl;
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
}
