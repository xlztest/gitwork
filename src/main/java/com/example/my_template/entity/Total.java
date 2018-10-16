package com.example.my_template.entity;

import java.util.Date;

public class Total {

      private String location;
      private int total;
      private String time;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Total{" +
                "location='" + location + '\'' +
                ", total=" + total +
                ", time='" + time + '\'' +
                '}';
    }
}
