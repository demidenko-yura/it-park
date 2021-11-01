package lesson10;

public enum TemperatureType {
    CELSIUS("°C"),
    KELVIN("K"),
    FAHRENHEIT("°F");

    private final String value;

    public String getValue() {
        return value;
    }

    TemperatureType(String value) {
        this.value = value;
    }
}
