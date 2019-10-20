package com.oneslip.planet.model;

public class PlanetSummary {

    private final long year;
    private final long numberOfSmall;
    private final long numberOfMedium;
    private final long numberOfLarge;

    public PlanetSummary(Builder builder) {
        this.year = builder.year;
        this.numberOfSmall = builder.numberOfSmall;
        this.numberOfMedium = builder.numberOfMedium;
        this.numberOfLarge = builder.numberOfLarge;
    }

    public long getYear() {
        return year;
    }

    public long getNumberOfSmall() {
        return numberOfSmall;
    }

    public long getNumberOfMedium() {
        return numberOfMedium;
    }

    public long getNumberOfLarge() {
        return numberOfLarge;
    }

    public static class Builder {

        private long year;
        private long numberOfSmall;
        private long numberOfMedium;
        private long numberOfLarge;

        public Builder year(long year) {
            this.year = year;
            return this;
        }

        public Builder numberOfSmall(long numberOfSmall) {
            this.numberOfSmall = numberOfSmall;
            return this;
        }

        public Builder numberOfMedium(long numberOfMedium) {
            this.numberOfMedium = numberOfMedium;
            return this;
        }

        public Builder numberOfLarge(long numberOfLarge) {
            this.numberOfLarge = numberOfLarge;
            return this;
        }

        public PlanetSummary build() {
            PlanetSummary summary = new PlanetSummary(this);
            return summary;
        }

    }

}
