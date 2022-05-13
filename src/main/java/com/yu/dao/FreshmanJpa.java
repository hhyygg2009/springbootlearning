package com.yu.dao;

import com.yu.pojo.Freshman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/17 16:20
 */
//@Repository
    @Component
public interface FreshmanJpa extends JpaRepository<Freshman,String> {

    @Query(value = "select * from tb_freshman where ticketnumber=?1",nativeQuery = true)
    Freshman selectjpa(String ticketnumber);
}
