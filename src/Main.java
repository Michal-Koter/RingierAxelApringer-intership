import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));

        List<String> input_distance = new ArrayList<>();

        String line = scanner.nextLine();

        String[] firstLine = line.split(" ");
        int citiesNum = Integer.parseInt(firstLine[0]);

        String startCity = firstLine[1];

        while ((line = scanner.nextLine()) != null && line.length() != 0) {
            input_distance.add(line);
        }

        List<Connection> connectionList = input_distance.stream()
                .map(Connection::new).toList();

        List<String> startCityAsList = new ArrayList<>() {{
            add(startCity);
        }};

        List<String> cities = List.of("Białystok", "Bydgoszcz", "Gdańsk", "Gorzów Wielkopolski", "Katowice", "Kielce", "Kraków", "Lublin",
                "Łódź", "Olsztyn", "Opole", "Poznań", "Rzeszów", "Szczecin", "Wrocław");
        Optimizer optimizer = new Optimizer(startCity, citiesNum, connectionList);

        int result = optimizer.runOpti(cities);

        System.out.println(result);
    }
}

