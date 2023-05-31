package com.alibaba.enums;


public enum VehicleType {
    Plane(200,3.0, 800),Car(4,2.0, 70),Bus(16,1.0, 60),Train(500,1.5, 50);

    public final Integer defaultCapacity;
    public final Double priceRatio;
    public final Integer averageSpeed;


    VehicleType(Integer defaultCapacity, Double priceRatio, Integer averageSpeed) {
        this.defaultCapacity = defaultCapacity;
        this.priceRatio = priceRatio;
        this.averageSpeed = averageSpeed;
    }

}
