package org.example.type;

public enum Size {
    ONE,
    TWO,
    THREE;

    public int getValue(){
        return switch (this) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
        };
    }
}
