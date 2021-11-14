package com.pb.tsvik.hw7;

public enum Size {

    XXS("Маленький размер", 32),
    XS("Взрослый размер", 34),
    S("Взрослый размер", 36),
    L("Взрослый размер", 38),
    M("Взрослый размер", 40);


    private Size size;
    private String description;
    private int euroSize;

    Size(String description,int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription() {
        if (size == XXS) {
            return "Маленкий размер";
        }
        else return "Взрослый размер";
    }

    public int getEuroSize() {
        switch (size) {
            case XXS:
                return 32;
            case XS:
                return 34;
            case S:
                return 36;
            case M:
                return 38;
            case L:
                return 40;
            default:
                return 0;
        }
    }

    
}

