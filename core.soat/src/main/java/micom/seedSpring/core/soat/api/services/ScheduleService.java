package micom.seedSpring.core.soat.api.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;


import com.google.gson.JsonObject;

import micom.seedSpring.core.soat.api.domain.ConferenceDay;
import micom.seedSpring.core.soat.api.domain.PagingInfo;
import micom.seedSpring.core.soat.api.domain.Slot;
import micom.seedSpring.core.soat.api.domain.Sort;
import micom.seedSpring.core.soat.api.domain.SortDirection;
import micom.seedSpring.core.soat.api.domain.SortingInfo;

/**
 * Schedule service that simulates dynamic data for the conference.
 * 
 
 */
@Service
public class ScheduleService {

    private static final Set<Slot> FIRST_DAY_SLOTS;
    private static final Set<Slot> SECOND_DAY_SLOTS;
    private static final Set<Slot> THIRD_DAY_SLOTS;

    /**
     * Gets the conference data for a single conference day.
     * 
     * @param day         the position of the day in the conference.
     * @param sortingInfo sorting information.
     * @return result represented through {@link ConferenceDay}.
     */
    public ConferenceDay getConferenceDayFor(int day, SortingInfo sortingInfo) {

        Sort sort = sortingInfo.getSort();
        SortDirection sortDirection = sortingInfo.getSortDirection();

        int[] numbers = new int[] { 1, 2, 3, 4, 5 };
        switch (day) {
        case 1:
            List<Slot> orderedFirstDaySlots = new ArrayList<Slot>(FIRST_DAY_SLOTS);
            Collections.sort(orderedFirstDaySlots, sort.getComparator(sortDirection));
            return new ConferenceDay(new LocalDate(2014, 9, 22), orderedFirstDaySlots, sortingInfo,
                    new PagingInfo(numbers, 1, true, false));
        case 2:
            List<Slot> orderedSecondDaySlots = new ArrayList<Slot>(SECOND_DAY_SLOTS);
            Collections.sort(orderedSecondDaySlots, sort.getComparator(sortDirection));
            return new ConferenceDay(new LocalDate(2014, 9, 23), orderedSecondDaySlots, sortingInfo,
                    new PagingInfo(numbers, 2, true, true));
        case 3:
            List<Slot> orderedThirdDaySlots = new ArrayList<Slot>(THIRD_DAY_SLOTS);
            Collections.sort(orderedThirdDaySlots, sort.getComparator(sortDirection));
            return new ConferenceDay(new LocalDate(2014, 9, 24), orderedThirdDaySlots, sortingInfo,
                    new PagingInfo(numbers, 3, true, true));
        case 4:
            throw new ConferenceException("Day 4 still in preparation");
        default:
            throw new IllegalStateException("Conference day " + day + " does not exist");
        }
    }

    static {
        // Day 1
        Set<Slot> firstDaySlots = new HashSet<Slot>();
        firstDaySlots.add(new Slot(new LocalTime(8, 30), new LocalTime(10, 30), "Rookie Session / AEM Certification",
                "Sebastian Schlick"));
        firstDaySlots
                .add(new Slot(new LocalTime(10, 30), new LocalTime(10, 45), "Opening Words", "Dominik S\u00fc\u00df"));
        firstDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11, 30), "Keynote: Apache Sling - Crystal Ball",
                "Mike M\u00fcller, Carsten Ziegeler"));
        firstDaySlots.add(new Slot(new LocalTime(11, 30), new LocalTime(11, 45), "Break", ""));
        firstDaySlots.add(
                new Slot(new LocalTime(11, 45), new LocalTime(12, 15), "Data replication in Sling", "Tommaso Teofili"));
        firstDaySlots.add(new Slot(new LocalTime(12, 15), new LocalTime(13, 15), "Lunch", ""));
        firstDaySlots.add(new Slot(new LocalTime(13, 15), new LocalTime(13, 45),
                "Integrating Open Source Search with CQ/AEM", "Gaston Gonzalez"));
        firstDaySlots.add(new Slot(new LocalTime(13, 45), new LocalTime(14, 0), "Break", ""));
        firstDaySlots.add(new Slot(new LocalTime(14, 0), new LocalTime(14, 30),
                "Using OSGi Subsystems with Apache Felix", "David Bosschaert"));
        firstDaySlots.add(new Slot(new LocalTime(14, 30), new LocalTime(14, 45), "Break", ""));
        firstDaySlots.add(new Slot(new LocalTime(14, 45), new LocalTime(15, 30),
                "Oak, the architecture of the new repository", "Michael D\u00fcrig"));
        firstDaySlots.add(new Slot(new LocalTime(15, 30), new LocalTime(15, 45), "Break", ""));
        firstDaySlots.add(new Slot(new LocalTime(15, 45), new LocalTime(16, 15),
                "The proper use of ResourceAccessSecurity", "Mike M\u00fcller"));
        firstDaySlots.add(new Slot(new LocalTime(16, 15), new LocalTime(16, 30), "Break", ""));
        firstDaySlots.add(new Slot(new LocalTime(16, 30), new LocalTime(17, 0),
                "New features of the sling health check", "Georg Henzler"));
        firstDaySlots.add(new Slot(new LocalTime(17, 0), new LocalTime(17, 15), "Break", ""));
        firstDaySlots.add(new Slot(new LocalTime(17, 15), new LocalTime(17, 45),
                "Apache Sling Generic Validation Framework", "Radu Cotescu"));
        FIRST_DAY_SLOTS = Collections.unmodifiableSet(firstDaySlots);

        // Day 2
        Set<Slot> secondDaySlots = new HashSet<Slot>();
        secondDaySlots.add(new Slot(new LocalTime(10, 0), new LocalTime(10, 45),
                "Apache Sling and devops - the next frontier?", "Bertrand Delacretaz"));
        secondDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11, 0), "Break", ""));
        secondDaySlots.add(new Slot(new LocalTime(11, 0), new LocalTime(11, 45),
                "The lazy AEM-developer (Sling Models+Sightly in Action, speaker)", "Feike Visser"));
        secondDaySlots.add(new Slot(new LocalTime(11, 45), new LocalTime(12, 0), "Break", ""));
        secondDaySlots.add(new Slot(new LocalTime(12, 0), new LocalTime(12, 30),
                "Mobile app development with Apache Cordova and AEM", "Bruce Lefebvre"));
        secondDaySlots.add(new Slot(new LocalTime(12, 30), new LocalTime(13, 30), "Lunch", ""));
        secondDaySlots
                .add(new Slot(new LocalTime(13, 30), new LocalTime(14, 15), "Sling IDE tooling", "Robert Munteanu"));
        secondDaySlots.add(new Slot(new LocalTime(14, 15), new LocalTime(14, 30), "Break", ""));
        secondDaySlots.add(
                new Slot(new LocalTime(14, 30), new LocalTime(15, 00), "Sling Resource Merger", "Carsten Ziegeler"));
        secondDaySlots.add(new Slot(new LocalTime(15, 0), new LocalTime(15, 15), "Break", ""));
        secondDaySlots.add(new Slot(new LocalTime(15, 15), new LocalTime(15, 45), "Integrating ElasticSearch with CQ5",
                "Vivek Sachdeva"));
        secondDaySlots.add(new Slot(new LocalTime(15, 45), new LocalTime(18, 0),
                "Playground Session (Hacking & Testing, speaker)", ""));
        secondDaySlots.add(new Slot(new LocalTime(18, 0), new LocalTime(23, 0),
                "Evening Event - Buffet, Hacking and Socialzing", ""));
        SECOND_DAY_SLOTS = Collections.unmodifiableSet(secondDaySlots);

        // Day 3
        Set<Slot> thirdDaySlots = new HashSet<Slot>();
        thirdDaySlots.add(new Slot(new LocalTime(10, 0), new LocalTime(10, 30),
                "Dynamic Components using Single-Page-Application Concepts", "Andon Sikavica, Bojana Popovska"));
        thirdDaySlots.add(new Slot(new LocalTime(10, 30), new LocalTime(10, 45), "Break", ""));
        thirdDaySlots.add(new Slot(new LocalTime(10, 45), new LocalTime(11, 45),
                "Getting Started with iBeacons and AEM", "Bart\u0142omiej Soin"));
        thirdDaySlots.add(new Slot(new LocalTime(11, 15), new LocalTime(11, 30), "Break", ""));
        thirdDaySlots.add(
                new Slot(new LocalTime(11, 30), new LocalTime(12, 0), "The Sling JCRBrowser", "Sandro B\u00f6hme"));
        thirdDaySlots.add(new Slot(new LocalTime(12, 0), new LocalTime(13, 0), "Lunch", ""));
        thirdDaySlots.add(new Slot(new LocalTime(13, 0), new LocalTime(13, 30),
                "OSGi Asynchronous Services: not just another RCP", "Michael D\u00fcrig"));
        thirdDaySlots.add(new Slot(new LocalTime(13, 30), new LocalTime(13, 45), "Break", ""));
        thirdDaySlots.add(new Slot(new LocalTime(13, 45), new LocalTime(14, 15),
                "Sling application architecture with Sling Models", "Stefan Seifert"));
        thirdDaySlots.add(new Slot(new LocalTime(14, 15), new LocalTime(14, 30), "Break", ""));
        thirdDaySlots.add(new Slot(new LocalTime(14, 30), new LocalTime(15, 0), "", ""));
        thirdDaySlots.add(new Slot(new LocalTime(15, 0), new LocalTime(16, 0), "Lightning Talks", ""));
        thirdDaySlots.add(new Slot(new LocalTime(16, 0), new LocalTime(16, 15), "Closing Words", ""));
        THIRD_DAY_SLOTS = Collections.unmodifiableSet(thirdDaySlots);
    }

    public String getCotizacion(String placa, String numeroDoc, String tipodocumento, String idptipodocumento) {
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "https://pemz544hoc.execute-api.us-east-2.amazonaws.com/prod/page_datos";
        // create request body
        JsonObject request = new JsonObject();
        request.addProperty("placa", placa);
        request.addProperty("numerodoc", numeroDoc);
        request.addProperty("tipodocumento", tipodocumento);
        request.addProperty("idptipodocumento", idptipodocumento);

        // request.addProperty("placa", "AXY340");
        // request.addProperty("numerodoc", "40290904");
        // request.addProperty("tipodocumento", "1");
        // request.addProperty("idptipodocumento", "2");
    
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("authorization", "eyJraWQiOiIwbE1zcm1NZFMwTzN4WG9DUFQrQ29NMnNOcFwvYnJ2aEtVQ01RcElROE5aST0iLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI0bjhnaG5sb285bm9tYzNndDY4YzJqdnFpYyIsInRva2VuX3VzZSI6ImFjY2VzcyIsInNjb3BlIjoiTGFuZGluZ1BhZ2VcL3B1YmxpY28iLCJhdXRoX3RpbWUiOjE1NDA4NTQwNDIsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTIuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0yX1hRWWgwaFR5WSIsImV4cCI6MTU0MDg1NzY0MiwiaWF0IjoxNTQwODU0MDQyLCJ2ZXJzaW9uIjoyLCJqdGkiOiIzMDhiNDhjNS1hNzY4LTRiYjAtYmI0NC0xMGJiYWE1NzkyYzIiLCJjbGllbnRfaWQiOiI0bjhnaG5sb285bm9tYzNndDY4YzJqdnFpYyJ9.iZ6f9L9dZdcYKFqbnu2QcIgn0mMR43jLcSZxCG5goJsjjtrVXkii2QS-I2q4JYBnH1F0cZxm16lp9-4IA_ZhFiMVfTH-DeyPVGhxBPpmLUwQ9e8yRZQHvr9Owwu5aQ6Qk4uZYB9_4kxaMaNDT7pV_PiafVqfzCwb330W0iQcyoNKGDnaG0c0T8YngZ0ce_OjrywNLwZcw_zM4YKgtuyW4FcK5WTvH2SaNQesv1QeI7lbYKM9uZrDafRhhjlCfAheyo1qXTQSx71dzNifRcjdx1OpdV0i7VwAIh50TPt6o21i6VlO3G12oPDNPrkRgc6WmTWKDlSaW8kPz9emh1b3Lg");
        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);
    
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        return result.getBody();
    }
}
