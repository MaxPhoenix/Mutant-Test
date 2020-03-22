package com.example.xmen.strategy;

public enum DnaCrossBoardDirectionOrientations {
    RIGHT(1),
    LEFT(2),
    DOWN(3),
    UP(4),
    DOWN_RIGHT(5),
    UP_RIGHT(6),
    DOWN_LEFT(7),
    UP_LEFT(8);

    DnaCrossBoardDirectionOrientations(Integer orientation) {
        this.orientation = orientation;
    }

    private Integer orientation;

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }
}
