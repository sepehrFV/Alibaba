package com.alibaba.enums;

public enum DesCity {
    Tehran(35.7219,51.3347),Mashhad(36.2972,59.6067);

    public final Double latitude;
    public final Double longitude;

    DesCity(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
