package org.learn.model;

public class Telefone {

    private Long id;
    private String number;
    private String type;
    private Long userNum;


    public Telefone() {}

    public Telefone( String number, String type, Long userNum) {
        this.number = number;
        this.type = type;
        this.userNum = userNum;
    }
    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", userNum=" + userNum +
                '}';
    }
}
