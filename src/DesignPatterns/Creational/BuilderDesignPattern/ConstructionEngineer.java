package DesignPatterns.Creational.BuilderDesignPattern;

public class ConstructionEngineer {  // optional class we can call method directly also .
    private HouseBuilder houseBuilder;

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
        return this.houseBuilder.getHouse();
    }
}

