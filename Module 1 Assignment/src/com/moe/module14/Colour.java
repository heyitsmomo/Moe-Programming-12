package com.moe.module14;

public enum Colour {
    RED("Red"), GREEN("Green"), BLUE("Blue"), NONE("None");

    private final String COLOURNAME;

    /**
     * COLOUR
     * @param name of colour
     */
    Colour(String name) {
        this.COLOURNAME = name;
    }

    /**
     * GET NAME
     * @return colour name
     */
    public String getName() {
        return this.COLOURNAME;
    }
}