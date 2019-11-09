/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetshop;

public abstract class ProductStorage {
    private String name;
    private double weight;
    private int cost;
    private final String type = "null";
 
    public String getType() {
        return type; 
    }
 
    public ProductStorage(String name, double weight, int cost) {
        this.name = name; 
        this.weight = weight;
        this.cost = cost;
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
 
    public void setWeight(int weight) {
        this.weight = weight;
    }
 
    public int getCost() { 
        return cost;
    }
 
    public void setCost(int cost) {
        this.cost = cost;
    }
  
    @Override 
    public String toString() {
        return "ProductStorage{" +
                "Имя заказчика='" + name + '\'' +
                ", вес=" + weight +
                ", стоимость=" + cost +
                '}';
    }
 
    public abstract int getCostWithDiscount();
}