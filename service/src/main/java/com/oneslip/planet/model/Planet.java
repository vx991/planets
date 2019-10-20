package com.oneslip.planet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Planet {

    @JsonProperty("PlanetIdentifier")
    private String planetIdentifier;

    @JsonProperty("TypeFlag")
    private int typeFlag;

    @JsonProperty("PlanetaryMassJpt")
    private float planetaryMassJpt;

    @JsonProperty("RadiusJpt")
    private float radiusJpt;

    @JsonProperty("PeriodDays")
    private float periodDays;

    @JsonProperty("SemiMajorAxisAU")
    private String semiMajorAxisAU;

    @JsonProperty("Eccentricity")
    private String eccentricity;

    @JsonProperty("PeriastronDeg")
    private String periastronDeg;

    @JsonProperty("LongitudeDeg")
    private String longitudeDeg;

    @JsonProperty("AscendingNodeDeg")
    private String ascendingNodeDeg;

    @JsonProperty("InclinationDeg")
    private String inclinationDeg;

    @JsonProperty("SurfaceTempK")
    private int surfaceTempK;

    @JsonProperty("AgeGyr")
    private int ageGyr;

    @JsonProperty("DiscoveryMethod")
    private String discoveryMethod;

    @JsonProperty("DiscoveryYear")
    private int discoveryYear;

    @JsonProperty("LastUpdated")
    private String lastUpdated;

    @JsonProperty("RightAscension")
    private String rightAscension;

    @JsonProperty("Declination")
    private String declination;

    @JsonProperty("DistFromSunParsec")
    private float distFromSunParsec;

    @JsonProperty("HostStarMassSlrMass")
    private float hostStarMassSlrMass;

    @JsonProperty("HostStarRadiusSlrRad")
    private float hostStarRadiusSlrRad;

    @JsonProperty("HostStarMetallicity")
    private float hostStarMetallicity;

    @JsonProperty("HostStarTempK")
    private int hostStarTempK;

    @JsonProperty("HostStarAgeGyr")
    private int hostStarAgeGyr;

    public String getPlanetIdentifier() {
        return planetIdentifier;
    }

    public void setPlanetIdentifier(String planetIdentifier) {
        this.planetIdentifier = planetIdentifier;
    }

    public int getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(int typeFlag) {
        this.typeFlag = typeFlag;
    }

    public float getPlanetaryMassJpt() {
        return planetaryMassJpt;
    }

    public void setPlanetaryMassJpt(float planetaryMassJpt) {
        this.planetaryMassJpt = planetaryMassJpt;
    }

    public float getRadiusJpt() {
        return radiusJpt;
    }

    public void setRadiusJpt(float radiusJpt) {
        this.radiusJpt = radiusJpt;
    }

    public float getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(float periodDays) {
        this.periodDays = periodDays;
    }

    public String getSemiMajorAxisAU() {
        return semiMajorAxisAU;
    }

    public void setSemiMajorAxisAU(String semiMajorAxisAU) {
        this.semiMajorAxisAU = semiMajorAxisAU;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(String eccentricity) {
        this.eccentricity = eccentricity;
    }

    public String getPeriastronDeg() {
        return periastronDeg;
    }

    public void setPeriastronDeg(String periastronDeg) {
        this.periastronDeg = periastronDeg;
    }

    public String getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(String longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public String getAscendingNodeDeg() {
        return ascendingNodeDeg;
    }

    public void setAscendingNodeDeg(String ascendingNodeDeg) {
        this.ascendingNodeDeg = ascendingNodeDeg;
    }

    public String getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(String inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public int getSurfaceTempK() {
        return surfaceTempK;
    }

    public void setSurfaceTempK(int surfaceTempK) {
        this.surfaceTempK = surfaceTempK;
    }

    public int getAgeGyr() {
        return ageGyr;
    }

    public void setAgeGyr(int ageGyr) {
        this.ageGyr = ageGyr;
    }

    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    public int getDiscoveryYear() {
        return discoveryYear;
    }

    public void setDiscoveryYear(int discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getRightAscension() {
        return rightAscension;
    }

    public void setRightAscension(String rightAscension) {
        this.rightAscension = rightAscension;
    }

    public String getDeclination() {
        return declination;
    }

    public void setDeclination(String declination) {
        this.declination = declination;
    }

    public float getDistFromSunParsec() {
        return distFromSunParsec;
    }

    public void setDistFromSunParsec(float distFromSunParsec) {
        this.distFromSunParsec = distFromSunParsec;
    }

    public float getHostStarMassSlrMass() {
        return hostStarMassSlrMass;
    }

    public void setHostStarMassSlrMass(float hostStarMassSlrMass) {
        this.hostStarMassSlrMass = hostStarMassSlrMass;
    }

    public float getHostStarRadiusSlrRad() {
        return hostStarRadiusSlrRad;
    }

    public void setHostStarRadiusSlrRad(float hostStarRadiusSlrRad) {
        this.hostStarRadiusSlrRad = hostStarRadiusSlrRad;
    }

    public float getHostStarMetallicity() {
        return hostStarMetallicity;
    }

    public void setHostStarMetallicity(float hostStarMetallicity) {
        this.hostStarMetallicity = hostStarMetallicity;
    }

    public int getHostStarTempK() {
        return hostStarTempK;
    }

    public void setHostStarTempK(int hostStarTempK) {
        this.hostStarTempK = hostStarTempK;
    }

    public int getHostStarAgeGyr() {
        return hostStarAgeGyr;
    }

    public void setHostStarAgeGyr(int hostStarAgeGyr) {
        this.hostStarAgeGyr = hostStarAgeGyr;
    }
}
