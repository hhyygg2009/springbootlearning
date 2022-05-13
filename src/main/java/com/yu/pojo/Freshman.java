package com.yu.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: hhyygg2009
 * @date: Created in 2021/5/11 9:34
 */

//@Entity(name = "tb_freshman")
@Component
@ConfigurationProperties("freshman")
@RedisHash("tb_freshman")
public class Freshman {
    @org.springframework.data.annotation.Id
    @Indexed
//    @Id
//    @Column(name = "ticketnumber")
    private String ticketNumber;//准考证号
    @Indexed
//    @Column(name="id_card")
    private String idCard;//身份证号
//    @Column(name = "name")
    @Indexed
    private String name;//姓名
    @Indexed
    private Integer sex;//性别,0：女，1：男
    @Indexed
    private Integer age;//年龄
    private Date birthday;//生日
    private String nation;//民族

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Freshman{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", nation='" + nation + '\'' +
                '}';
    }
}
