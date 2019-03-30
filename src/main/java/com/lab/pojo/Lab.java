package com.lab.pojo;

import java.util.Objects;

public class Lab {
    private Integer id;

    private String name;

    private String address;

    private Integer size;

    public Lab() {
    }

    public Lab(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lab)) return false;
        Lab lab = (Lab) o;
        return Objects.equals(getId(), lab.getId()) &&
                Objects.equals(getName(), lab.getName()) &&
                Objects.equals(getAddress(), lab.getAddress()) &&
                Objects.equals(getSize(), lab.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getSize());
    }
}

