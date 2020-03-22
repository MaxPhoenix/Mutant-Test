package com.example.xmen.strategy;

public enum DnaCrossBoardDirectionSearchConstants {
    RIGHT("RIGHT"),
    DOWN("DOWN"),
    DOW_RIGHT("DOWN_RIGHT");

    private String directionalKey;

    DnaCrossBoardDirectionSearchConstants(String directionalKey) {
        this.directionalKey = directionalKey;
    }

    public String getDirectionalKey() {
        return directionalKey;
    }

    public void setDirectionalKey(String directionalKey) {
        this.directionalKey = directionalKey;
    }


}
