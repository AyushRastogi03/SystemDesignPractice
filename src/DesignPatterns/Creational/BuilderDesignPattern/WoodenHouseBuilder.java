package DesignPatterns.Creational.BuilderDesignPattern;

public class WoodenHouseBuilder implements HouseBuilder {
    private House house;

    public WoodenHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Wood, laminate, and beams");
        System.out.println("WoodenHouseBuilder: Foundation complete.");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wood and laminate");
        System.out.println("WoodenHouseBuilder: Structure complete.");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wooden roof with shingles");
        System.out.println("WoodenHouseBuilder: Roof complete.");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Wood paneling");
        System.out.println("WoodenHouseBuilder: Interior complete.");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}