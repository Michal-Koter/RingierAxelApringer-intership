public class Connection {
    private String startCity;
    private String endCity;
    private int distance;

    public Connection(String text) {
        String[] data = text.split(" ");

        if (data[0].equals("Gorzów")) {
            this.startCity = data[0] + " " + data[1];
            this.endCity = data[2];
            this.distance = Integer.parseInt(data[3]);
        } else if (data[1].equals("Gorzów")) {
            this.startCity = data[0];
            this.endCity = data[1] + " " + data[2];
            this.distance = Integer.parseInt(data[3]);
        } else {
            this.startCity = data[0];
            this.endCity = data[1];
            this.distance = Integer.parseInt(data[2]);
        }
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public int getDistance() {
        return distance;
    }
}
