
public class PairsOfCityTemperature implements Comparable<PairsOfCityTemperature> {

    private String city;
    private double temperature;

    public PairsOfCityTemperature(String _city, double _temperature) {
        this.city = _city;
        this.temperature = _temperature;
    }

    public String getCity() {
        return city;
    }

    @Override
    public int compareTo(PairsOfCityTemperature o) {
        return temperature < o.temperature ? 1 : temperature > o.temperature ? -1 : 0;    }


}
