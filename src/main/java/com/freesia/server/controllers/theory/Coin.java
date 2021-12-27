package com.freesia.server.controllers.theory;

public class Coin {

    private Long id;
    private String name;
    private String period;
    private String region;
    private String age;
    private String condition;
    private String value;
    private String dateAdded;

    public Coin(Long id, String name, String period, String region, String age, String condition, String value, String dateAdded) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.region = region;
        this.age = age;
        this.condition = condition;
        this.value = value;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
