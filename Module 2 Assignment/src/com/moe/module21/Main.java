package com.moe.module21;

public class Main {
    /**
     * MAIN METHOD
     * @param args not used
     */
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 5.972e24, 1.0, PlanetType.TERRESTRIAL);
        Planet mars = new Planet("Mars", 6.39e23, 1.88, PlanetType.TERRESTRIAL);

        System.out.println(earth);
        System.out.println();
        System.out.println(mars);

        System.out.println("\nAre earth and mars equal? " + earth.equals(mars));
    }
}
