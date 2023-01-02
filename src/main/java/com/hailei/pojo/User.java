package com.hailei.pojo;

public class User {
    private String bank_id;//银行内ID
    private String bank_name;//用户名
    private String land_pwd;  //登陆密码
    private String pay_pwd;  //支付密码
    private String id_card;  //身份ID
    private String phone;   //手机号
    private char gender;//性别
    private String birth_date;//出生日期
    private double money;  //余额

    public User() {
    }

    public User(String bank_id, String bank_name, String land_pwd, String pay_pwd, String id_card, String phone, char gender, String birth_date, double money) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.land_pwd = land_pwd;
        this.pay_pwd = pay_pwd;
        this.id_card = id_card;
        this.phone = phone;
        this.gender = gender;
        this.birth_date = birth_date;
        this.money = money;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getLand_pwd() {
        return land_pwd;
    }

    public void setLand_pwd(String land_pwd) {
        this.land_pwd = land_pwd;
    }

    public String getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(String pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "bank_id='" + bank_id + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", land_pwd='" + land_pwd + '\'' +
                ", pay_pwd='" + pay_pwd + '\'' +
                ", id_card='" + id_card + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", birth_date='" + birth_date + '\'' +
                ", money=" + money +
                '}';
    }
}

