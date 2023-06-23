package com.example.resturantreviewtestrestapi.model;

import lombok.Getter;

@Getter
public enum Cuisine{
    CHINNESE(1), ITALIAN(2), AMERICAN(3), INDIAN(4);

    private int value;

    private Cuisine(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Cuisine fromValue(int value) {
        for (Cuisine cuisine : Cuisine.values()) {
            if (cuisine.getValue() == value) {
                return cuisine;
            }
        }
        throw new IllegalArgumentException("Invalid Cuisine value: " + value);
    }
}