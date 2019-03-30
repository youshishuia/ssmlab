package com.lab.pojo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FormView {
    private Integer formid;

    private Integer userid;

    private Integer labid;

    private String username;

    private String labname;

    private String address;

    private Timestamp applicationtime;//申请时间

    private Timestamp appointment;//预约开始时间

    private Timestamp appointmentend;//预约结束时间

    private String pass;//预约审核  初定0不过 1过 null没审核

    public Integer getFormid() {
        return formid;
    }

    public void setFormid(Integer formid) {
        this.formid = formid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getLabid() {
        return labid;
    }

    public void setLabid(Integer labid) {
        this.labid = labid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplicationtime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str ;
        str= df.format(applicationtime);
        return str;
    }

    public void setApplicationtime(Timestamp applicationtime) { this.applicationtime = applicationtime; }

    public String getAppointment() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str ;
        str= df.format(appointment);
        return str;
    }

    public void setAppointment(Timestamp appointment) {
        this.appointment = appointment;
    }

    public String getAppointmentend() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str ;
        str= df.format(appointmentend);
        return str;
    }

    public void setAppointmentend(Timestamp appointmentend) {
        this.appointmentend = appointmentend;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
