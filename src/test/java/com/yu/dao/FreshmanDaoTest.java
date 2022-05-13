package com.yu.dao;

import com.yu.pojo.Freshman;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/17 11:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class FreshmanDaoTest {
    @Autowired
    FreshmanDao freshmanDao;
    @Autowired
    FreshmanJpa freshmanJpa;
    @Autowired
    Freshman freshmannew;

    @Test
    void select() {
//        Freshman freshman=freshmanDao.selectjpa("16445122105383");
        Freshman freshman=freshmanDao.select("16445122105383");
        assertNotNull(freshman);
    }

    @Test
    void jpaselect(){
//        Freshman freshman=freshmanJpa.selectjpa("16445122105383");
        freshmanJpa.save(freshmannew);
        Freshman freshman=freshmanJpa.findById("16445122105383").get();
        System.out.println(freshman.toString());
        assertNotNull(freshman);
    }


}