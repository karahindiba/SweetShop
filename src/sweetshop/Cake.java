/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetshop;

public class Cake extends ProductStorage {
    private final int DISCOUNT = 20;
    private final String type = "CAKE";
 
    @Override
    public String getType() {
        return type;
    }

    public Cake(String name, double weight, int cost) { 
        super(name, weight, cost);
 
    }
 
    public int getDISCOUNT() {
        return DISCOUNT;
    }
 
 
    @Override
    public int getCostWithDiscount() {
        return (int) (getCost() - getCost() * getDISCOUNT() / 100);
    }
}
