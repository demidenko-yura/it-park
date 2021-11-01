package lesson10;

import java.text.DecimalFormat;

public abstract class Temperature implements Convertible {

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    protected final TemperatureType type;
    protected final double value;

    public Temperature(TemperatureType type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Температура " + FORMAT.format(value) + " " + type.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temperature that = (Temperature) o;
        return Double.compare(Math.round(that.value * 100.0) / 100.0, Math.round(value * 100.0) / 100.0) == 0 && type == that.type;
    }

}
