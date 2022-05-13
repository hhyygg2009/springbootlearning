package com.yu.dao;

import com.yu.pojo.Freshman;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Repository;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/17 10:54
 */
@Mapper
@Repository
public interface FreshmanDao  {

    Freshman select(String ticketnumber);
    int insert(Freshman freshman);
    int update(Freshman freshman);
    int delete(int ticketnumber);

}
