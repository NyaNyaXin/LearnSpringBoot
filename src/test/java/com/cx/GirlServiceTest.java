package com.cx;

import com.cx.domain.Girl;
import com.cx.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(16);
        Assert.assertEquals(new Integer(22),girl.getAge());
    }
}
