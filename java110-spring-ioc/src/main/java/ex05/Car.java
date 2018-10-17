package ex05;

import java.sql.Date;

public class Car {
    
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date creaetedDate;
    private Engine engine;
    
    public Car() {
        System.out.println("Car() 호출됨!");
    }

    public Car(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String,int) 호출됨!");
    }

    public Car(int cc, String maker) {
        this.maker = maker;
        this.cc = cc;
        System.out.println("Car(int,String) 호출됨!");
    }

    public Car(String model, int cc,Engine engine) {
        this.engine = engine;
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String,int,Engine) 호출됨!");
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreaetedDate() {
        return creaetedDate;
    }

    public void setCreaetedDate(Date creaetedDate) {
        this.creaetedDate = creaetedDate;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", creaetedDate="
                + creaetedDate + ", engine=" + engine + "]";
    }
}
