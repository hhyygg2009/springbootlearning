package com.yu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: hhyygg2009
 * @date: Created in 2021/5/11 9:59
 */
@Component
@PropertySource("classpath:freshman.properties")
public class Person {
    @Value("${person.politic}")
    private Integer politic;//政治面貌,0：群众，1：共青团员，2：党员
    @Value("${person.deptId}")
    private Integer deptId;//系别
    private String majorId;//专业
    private Integer classId;//班级ID
    private Integer dormId;//宿舍ID
    private Integer userId;//用户ID
    private String stuNo;//学号
    private Integer roleId;//角色
    private Integer status;//缴费状态,0：未缴费，1：未分配学号，2：未分配宿舍，3：已分配宿舍
    private String registerTime;//注册时间

    @Override
    public String toString() {
        return "Person{" +
                "politic=" + politic +
                ", deptId=" + deptId +
                ", majorId='" + majorId + '\'' +
                ", classId=" + classId +
                ", dormId=" + dormId +
                ", userId=" + userId +
                ", stuNo='" + stuNo + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
