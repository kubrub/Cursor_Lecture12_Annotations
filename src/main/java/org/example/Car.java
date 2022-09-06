package org.example;

public class Car {
    @MyOwnAnnotations("manufacturer")
    private String make;

    @MyOwnAnnotations
    private String model;

    private int year;

    private String fuel;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public Car() {
    }

    public Car(String make, String model, int year, String fuel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", fuel='" + fuel + '\'' +
                '}';
    }
}
