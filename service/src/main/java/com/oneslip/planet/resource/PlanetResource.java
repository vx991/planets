package com.oneslip.planet.resource;

import com.oneslip.planet.model.PlanetSummary;
import com.oneslip.planet.model.Planet;
import com.oneslip.planet.model.PlanetTypeCount;
import com.oneslip.planet.service.PlanetDataService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class PlanetResource {

    private final PlanetDataService dataService;

    private final String[] planetTypes = {
        "no known stellar binary companion",
        "P-type binary (circumbinary)",
        "S-type binary",
        "orphan planet (no star)"
    };

    public PlanetResource(PlanetDataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Retrieve all planet data from the planet data service
     *
     * @return A list of planets
     * @throws IOException
     */
    @RequestMapping("/planet")
    public List<Planet> getPlanetData() throws IOException {
        return dataService.getPlanetData();
    }

    /**
     * Get the number of planets of a given type
     *
     * @param id - The planet type
     *                 0 - no known stellar binary companion
     *                 1 - P-type binary (circumbinary)
     *                 2 - S-type binary
     *                 3 - orphan planet (no star)
     * @return A PlanetTypeCount object that contains the type description, the type id, and the count
     * @throws IOException
     */
    @RequestMapping("/planet/type/{id}")
    public PlanetTypeCount getCountByType(@PathVariable int id) throws IOException {
        PlanetTypeCount planetTypeCount = new PlanetTypeCount();

        if (id >= 0 && id < planetTypes.length) {
            planetTypeCount.setDescription(planetTypes[id]);
            planetTypeCount.setType(id);
            planetTypeCount.setCount(getPlanetData()
                .stream()
                .filter(planet -> planet.getTypeFlag() == id)
                .count()
            );
        }

        return planetTypeCount;
    }

    /**
     * Get the planet with the hottest host star
     *
     * @return A planet
     * @throws IOException
     */
    @RequestMapping("/planet/host/hottest")
    public Planet getPlanetByHottestParentStar() throws IOException {
        List<Planet> sortedList = getPlanetData()
            .stream()
            .sorted(Comparator.comparing(Planet::getHostStarTempK).reversed())
            .collect(Collectors.toList());

        return sortedList.get(0);
    }

    /**
     * Get a summary of the planet size grouped by the year of discovery
     *
     * @return A list of planet summary objects. Each containing the year, and the
     * number of small, medium, and large planets discovered that year
     *
     * @throws IOException
     */
    @RequestMapping("/planet/summary")
    public List<PlanetSummary> getAnnualSummary() throws IOException {
        List<PlanetSummary> summaryList = new ArrayList<>();

        Map<Integer, List<Planet>> planetsByYear = getPlanetData()
            .stream()
            .collect(sortedGroupingBy(Planet::getDiscoveryYear));

        planetsByYear.forEach((key, value) -> {
            PlanetSummary summary = new PlanetSummary.Builder()
                .year(key)
                .numberOfSmall(value.stream().filter(planet -> planet.getRadiusJpt() < 1.0).count())
                .numberOfMedium(value.stream().filter(planet -> planet.getRadiusJpt() >= 1.0 && planet.getRadiusJpt() < 2.0).count())
                .numberOfLarge(value.stream().filter(planet -> planet.getRadiusJpt() >= 2.0).count())
                .build();

            summaryList.add(summary);
        });

        return summaryList;
    }

    private static <T, K extends Comparable<K>> Collector<T, ?, TreeMap<K, List<T>>> sortedGroupingBy(Function<T, K> function) {
        return Collectors.groupingBy(function, TreeMap::new, Collectors.toList());
    }

}
