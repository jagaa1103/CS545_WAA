package miu.domain;

import java.io.Serializable;

public class Calculator implements Serializable {
    private String sum;
    private String profit;

    private String add1;
    private String add2;
    private String multi1;
    private String multi2;

    public void calculate() {
        sum =  "" + (Integer.parseInt(add1) + Integer.parseInt(add2));
        profit = "" + (Integer.parseInt(multi1) * Integer.parseInt(multi2));
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getMulti1() {
        return multi1;
    }

    public void setMulti1(String multi1) {
        this.multi1 = multi1;
    }

    public String getMulti2() {
        return multi2;
    }

    public void setMulti2(String multi2) {
        this.multi2 = multi2;
    }
}
