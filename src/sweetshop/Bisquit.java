/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetshop;

public class Bisquit extends ProductStorage {
    private final int DISCOUNT = 30;
    private final String type = "BISQUIT";
 
    @Override
    public String getType() {
        return type;
    }
 
    public Bisquit(String name, double weight, int cost) {
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