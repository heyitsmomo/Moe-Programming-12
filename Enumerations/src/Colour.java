public enum Colour {
    RED("Red"), GREEN("Green"), BLUE("Blue"), NONE("None");

    private final String COLOURNAME;

    Colour(String name) {
        this.COLOURNAME = name;
    }

    public String getName() {
        return this.COLOURNAME;
    }
}
