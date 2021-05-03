package datapackage;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    public String name;
    public double mass;
    public double height;
    public Person(String name) {
        this.name = name;
    }
    public Person() {
    }
    public double getBmi() {
        return mass / (height / 100.0 * height / 100.0);
    }
    public String toString() {
        return name + ", bmi = " + getBmi();
    }
}