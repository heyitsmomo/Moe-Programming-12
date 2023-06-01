package com.moe.module21;

import java.util.Objects;

public class Planet {
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;

    /**
     * PLANET CONSTRUCTOR
     * @param designation String of planet name
     * @param type The type of planet
     */
    public Planet(String designation, PlanetType type){
        this.designation = designation;
        this.type = type;
    }

    /**
     * PLANET CONSTRUCTOR
     * @param designation String of planet name
     * @param massKg mass of planet in double
     * @param orbitEarthYears in double
     * @param type the type of planet
     */
    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    /**
     * EQUALS
     * @param obj the object
     * @return boolean if the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Planet planet = (Planet)obj;
        return Objects.equals(designation, planet.designation);
    }

    /**
     * HASH CODE
     * @return int of hash value of designation
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(designation);
    }

    /**
     * OVERALL RESULTS IN STRING
     * @return string of overall result of planet
     */
    @Override
    public String toString() {
        return "Designation: " + designation +
                "\nMass: " + massKg +
                "\nOrbit Earth Years: " + orbitEarthYears +
                "\nPlanet Type: " + type;
    }
}
