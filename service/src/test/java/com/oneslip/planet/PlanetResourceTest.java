package com.oneslip.planet;

import com.oneslip.planet.model.PlanetSummary;
import com.oneslip.planet.model.Planet;
import com.oneslip.planet.model.PlanetTypeCount;
import com.oneslip.planet.resource.PlanetResource;
import com.oneslip.planet.service.PlanetDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PlanetResourceTest {

    List<Planet> planets = new ArrayList<>();

    @Mock
    PlanetDataService dataServiceMock;

    @InjectMocks
    PlanetResource planetResource;

    @Before
    public void init() {
        Planet planet1 = new Planet();
        planet1.setPlanetIdentifier("Planet1");
        planet1.setDiscoveryYear(2019);
        planet1.setRadiusJpt(0.5f);
        planet1.setTypeFlag(0);
        planet1.setHostStarTempK(1000);

        Planet planet2 = new Planet();
        planet2.setPlanetIdentifier("Planet2");
        planet2.setDiscoveryYear(2019);
        planet2.setRadiusJpt(1.5f);
        planet2.setTypeFlag(1);
        planet2.setHostStarTempK(2000);

        Planet planet3 = new Planet();
        planet3.setPlanetIdentifier("Planet3");
        planet3.setDiscoveryYear(2018);
        planet3.setRadiusJpt(2.0f);
        planet3.setTypeFlag(2);
        planet3.setHostStarTempK(3000);

        Planet planet4 = new Planet();
        planet4.setPlanetIdentifier("Planet4");
        planet4.setDiscoveryYear(2017);
        planet4.setRadiusJpt(3.0f);
        planet4.setTypeFlag(3);
        planet4.setHostStarTempK(4000);

        planets.add(planet1);
        planets.add(planet2);
        planets.add(planet3);
        planets.add(planet4);
    }

    @Test
    public void getPlanetDataTest() throws IOException {
        when(dataServiceMock.getPlanetData()).thenReturn(new ArrayList<>());
        List<Planet> emptyList = planetResource.getPlanetData();
        assertEquals(0, emptyList.size());

        when(dataServiceMock.getPlanetData()).thenReturn(planets);
        planets = planetResource.getPlanetData();
        assertEquals(4, planets.size());
    }

    @Test
    public void getCountByTypeTest() throws IOException {
        when(dataServiceMock.getPlanetData()).thenReturn(planets);

        PlanetTypeCount typeCount = planetResource.getCountByType(0);
        assertEquals(1, typeCount.getCount());

        typeCount = planetResource.getCountByType(1);
        assertEquals(1, typeCount.getCount());

        typeCount = planetResource.getCountByType(2);
        assertEquals(1, typeCount.getCount());

        typeCount = planetResource.getCountByType(3);
        assertEquals(1, typeCount.getCount());

        typeCount = planetResource.getCountByType(4);
        assertEquals("Invalid type selected", typeCount.getDescription());
    }

    @Test
    public void getPlanetByHottestParentStarTest() throws IOException {
        when(dataServiceMock.getPlanetData()).thenReturn(planets);

        Planet planet = planetResource.getPlanetByHottestParentStar();
        assertEquals("Planet4", planet.getPlanetIdentifier());
    }

    @Test
    public void getAnnualSummaryTest() throws IOException {
        when(dataServiceMock.getPlanetData()).thenReturn(planets);

        List<PlanetSummary> summaryList = planetResource.getAnnualSummary();
        assertEquals(3, summaryList.size());

        assertEquals(2017, summaryList.get(0).getYear());
        assertEquals(0, summaryList.get(0).getNumberOfSmall());
        assertEquals(0, summaryList.get(0).getNumberOfMedium());
        assertEquals(1, summaryList.get(0).getNumberOfLarge());

        assertEquals(2018, summaryList.get(1).getYear());
        assertEquals(0, summaryList.get(1).getNumberOfSmall());
        assertEquals(0, summaryList.get(1).getNumberOfMedium());
        assertEquals(1, summaryList.get(1).getNumberOfLarge());

        assertEquals(2019, summaryList.get(2).getYear());
        assertEquals(1, summaryList.get(2).getNumberOfSmall());
        assertEquals(1, summaryList.get(2).getNumberOfMedium());
        assertEquals(0, summaryList.get(2).getNumberOfLarge());
    }

}
