import java.util.*;


public class Optimizer {
    private int minTime = -1;
    private String startCity;
    private final List<Connection> connectionList;
    private final int citiesNum;

    public Optimizer(String city, int citiesNum, List<Connection> connectionList) {
        this.startCity = city;
        this.citiesNum = citiesNum;
        this.connectionList = connectionList;
    }

    public int runOpti(List<String> citiesToVisit) {
        List<Integer> times = new ArrayList<>();
        for (String destination : citiesToVisit) {
            System.out.println(destination);
            List<String> reducedVisitedCities = new ArrayList<>(citiesToVisit);
            int time = optiNew(reducedVisitedCities, destination);
            time += findConnection(destination, "Warszawa").getDistance();
            times.add(time);
        }
        return times.stream().min(Integer::compare).get();
    }

    public int optiNew(List<String> citiesToVisit, String destination) {
        if (citiesToVisit.size() == 1) {
            Connection connection = findConnection("Warszawa", destination);
            return connection.getDistance();
        } else {
            List<Integer> times = new ArrayList<>();
            List<String> reducedVisitedCities = new ArrayList<>(citiesToVisit);
            reducedVisitedCities.remove(destination);

            for (String city : reducedVisitedCities) {
                times.add(
                        optiNew(reducedVisitedCities, city) + findConnection(city, destination).getDistance()
                );
            }
            return times.stream().min(Integer::compare).get();
        }
    }

    private Connection findConnection(String currentCity, String destination) {
        return this.connectionList.stream()
                .filter(p -> p.getStartCity().equalsIgnoreCase(currentCity) || p.getEndCity().equalsIgnoreCase(currentCity))
                .filter(p -> p.getStartCity().equalsIgnoreCase(destination) || p.getEndCity().equalsIgnoreCase(destination))
                .toList()
                .getFirst();
    }

    public int getMinTime() {
        return minTime;
    }

    public String getStartCity() {
        return startCity;
    }

    public int getCitiesNum() {
        return citiesNum;
    }
}
