package mum.edu.model;

public class Coffee {

    private String name;
    private String roast;

    public Coffee(String name, String roast) {
        this.name = name;
        this.roast = roast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }
}
