package dwmh.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Location {
    String address;
    String city;
    String state;
    int zipCode;
    BigDecimal rate;
    BigDecimal weekendRate;

    public Location(String address, String city, String state, int zipCode, BigDecimal rate, BigDecimal weekendRate) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.rate = rate;
        this.weekendRate = weekendRate;
    }

    public Location() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(BigDecimal weekendRate) {
        this.weekendRate = weekendRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return zipCode == location.zipCode && Objects.equals(address, location.address) && Objects.equals(city, location.city) && Objects.equals(state, location.state) && Objects.equals(rate, location.rate) && Objects.equals(weekendRate, location.weekendRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, city, state, zipCode, rate, weekendRate);
    }
}
