package com.lab.pojo;

import java.sql.Timestamp;

public class Form {
    private Integer id;

    private Integer userid;

    private Integer labid;

    private Timestamp applicationtime;//申请时间

    private Timestamp appointment;//预约开始时间

    private Timestamp appointmentend;//预约结束时间


    private String pass;//预约审核  初定0不过 1过 null没审核

    public Form() {
    }

    public Form(Integer userid, Integer labid, Timestamp appointment, Timestamp appointmentend) {
        this.userid = userid;
        this.labid = labid;
        this.appointment = appointment;
        this.appointmentend = appointmentend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Timestamp applicationtime) {
        this.applicationtime = applicationtime;
    }

    public Timestamp getAppointment() {
        return appointment;
    }

    public void setAppointment(Timestamp appointment) {
        this.appointment = appointment;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Timestamp getAppointmentend() {
        return appointmentend;
    }

    public void setAppointmentend(Timestamp appointmentend) {
        this.appointmentend = appointmentend;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", userid=" + userid +
                ", labid=" + labid +
                ", applicationtime=" + applicationtime +
                ", appointment=" + appointment +
                ", appointmentend=" + appointmentend +
                ", pass=" + pass +
                '}';
    }
}

