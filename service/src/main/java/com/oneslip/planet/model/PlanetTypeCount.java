package com.oneslip.planet.model;

public class PlanetTypeCount {

    private String description;
    private long type;
    private long count;

    public PlanetTypeCount() {
        this.description = "Invalid type selected";
    }

    public PlanetTypeCount(String description, long type, long count) {
        this.description = description;
        this.type = type;
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
