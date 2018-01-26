package agh.cs.airly;

public class Measurements {

    // measurements
    private double airQualityIndex;
    private double pm1;
    private double pm25;
    private double pm10;
    private double pressure;
    private double humidity;
    private double temperature;
    private double pollutionLevel;

    // units
    public final String pmUnit = " μg/m3";
    public final String presseureUnit = " hPa";
    public final String percent = " %";
    public final String temperatureUnit = " °C";


    public Measurements( double airQualityIndex, double pm1, double pm10, double pm25,
                         double pressure, double humidity, double temp, double pollutionLevel) {
        this.airQualityIndex = airQualityIndex;
        this.pm1 = pm1;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperature = temp;
        this.pollutionLevel = pollutionLevel;
    }

    public String getPollutionInformation () {
        if (this.airQualityIndex < 25) return "Very low";
        else if ( this.airQualityIndex < 50) return "Low";
        else if ( this.airQualityIndex < 75) return "Medium";
        else if (this.airQualityIndex < 100) return "Bad";
        else return "Very bad";
    }

    public Measurements roundValue() {

        int toHowManyPlaces = 10 ^2;  // 2 places

        this.pm25 = Math.round( pm25 * toHowManyPlaces) / toHowManyPlaces;
        this.pm10 = Math.round( pm10 * toHowManyPlaces) / toHowManyPlaces;
        this.pm1 = Math.round( pm1 * toHowManyPlaces) / toHowManyPlaces;
        this.pressure = Math.round( pressure * toHowManyPlaces) / toHowManyPlaces;
        this.temperature = Math.round( temperature * toHowManyPlaces) / toHowManyPlaces;
        this.pollutionLevel = Math.round( pollutionLevel * toHowManyPlaces) / toHowManyPlaces;
        this.humidity = Math.round( humidity * toHowManyPlaces) / toHowManyPlaces;
        this.airQualityIndex = Math.round( airQualityIndex * toHowManyPlaces) / toHowManyPlaces;

        return this;
    }

    // getters and setters
    public double getAirQualityIndex() { return airQualityIndex; }

    public void setAirQualityIndex( double airQualityIndex ) {
        this.airQualityIndex = airQualityIndex;
    }

    public double getHumidity() { return humidity; }

    public void setHumidity( double humidity){
        this.humidity = humidity;
    }

    public double getPm1() { return pm1; }

    public void  setPm1 ( double pm1 ) {
        this.pm1 = pm1;
    }

    public double getPm10() { return pm10; }

    public void setPm10 (double pm10) {
        this.pm10 = pm10;
    }

    public double getPm25() { return pm25; }

    public void setPm25( double pm25 ) {
        this.pm25 = pm25;
    }

    public double getPollutionLevel() { return pollutionLevel; }

    public void setPollutionLevel( double pollutionLevel) {
        this.pollutionLevel = pollutionLevel;
    }

    public double getTemperature() { return temperature; }

    public void setTemperature( double temp ) {
        this.temperature = temp;
    }

    public double getPressure() { return pressure; }

    public void setPressure( double pressure) {
        this.pressure = pressure;
    }
}