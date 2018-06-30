package Domain;

import java.util.List;

public class Animal {
    private String name;
    private double weight;
    private List<String> nicknameS;

    public Animal(String name, double weight, List<String> nicknameS) {
        this.name = name;
        this.weight = weight;
        this.nicknameS = nicknameS;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getNicknameS() {
        return nicknameS;
    }

    public void setNicknameS(List<String> nicknameS) {
        this.nicknameS = nicknameS;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", nicknameS=" + nicknameS +
                '}';
    }
}
