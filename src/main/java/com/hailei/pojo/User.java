package com.hailei.pojo;

public class User {
    private String bank_id;//银行内ID
    private String bank_name;//用户名
    private String password;  //密码
    private String id_card;  //身份ID
    private String phone;   //手机号
    private char gender;//性别
    private String birth_date;//出生日期
    private double money;  //余额

    public User() {}

    public User(String bank_id, String bank_name, String password, String id_card, String phone, char gender, String birth_date, double money) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.password = password;
        this.id_card = id_card;
        this.phone = phone;
        this.gender = gender;
        this.birth_date = birth_date;
        this.money = money;
    }

    public String getBank_id() {
        return bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getPassword() {
        return password;
    }

    public String getId_card() {
        return id_card;
    }

    public String getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public double getMoney() {
        return money;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "bank_id='" + bank_id + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", password='" + password + '\'' +
                ", id_card='" + id_card + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", birth_date='" + birth_date + '\'' +
                ", money=" + money +
                '}';
    }
}
