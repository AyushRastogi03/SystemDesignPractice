package DesignPatterns.Structural.ProxyDesignPattern;

public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
    }

    private void loadImageFromDisk(){
        System.out.println("Loading image : " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying Image - " + fileName);
    }
}
