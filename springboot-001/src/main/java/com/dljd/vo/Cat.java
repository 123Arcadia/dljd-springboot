package com.dljd.vo;

public class Cat {
    private String name;
    private String cardId;
    private Integer age;

//    public Cat(String name, String cardId, Integer age) {
//        this.name = name;
//        this.cardId = cardId;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
