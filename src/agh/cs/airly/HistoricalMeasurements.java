package agh.cs.airly;

public class HistoricalMeasurements extends Measurements {

    public String fromDate;
    public String tillDate;


    public HistoricalMeasurements(String fromDate, String tillDate,double airQualityIndex,
                                 double pm1, double pm10, double pm25, double pressure, double humidity, double temp, double pollutionLevel) {

        super (airQualityIndex, pm1, pm10, pm25, pressure, humidity, temp, pollutionLevel);
        this.fromDate = fromDate;
        this.tillDate = tillDate;

    }

    public HistoricalMeasurements roundValues() {
        Measurements m = (Measurements) this;
        m= m.roundValue() ;
        this.setAirQualityIndex( m.getAirQualityIndex());
        this.setHumidity( m.getHumidity());
        this.setPm1( m.getPm1());
        this.setPm25( m.getPm25());
        this.setPm10( m.getPm10());
        this.setPollutionLevel( m.getPollutionLevel());
        this.setPressure( m.getPressure());
        this.setTemperature(m.getTemperature());
        return this;
    }


}
