package com.yu.pojo;

/**
 * @author hhyygg2009
 * @date Created in 2021/6/14 11:28
 */
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Weather implements Serializable{
    private static final long serialVersionUID = -8221467966772683998L;
    private String id;
    private String city;
    private String weatherDetail;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getWeatherDetail() {
        return weatherDetail;
    }
    public void setWeatherDetail(String weatherDetail) {
        this.weatherDetail = weatherDetail;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Weather [id=" + id + ", city=" + city + ", weatherDetail=" + weatherDetail + "]";
    }
}

