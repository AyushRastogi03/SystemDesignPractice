package SingletonDesignPattern;

/*
Singleton Pattern is probably the most widely used design pattern.
It is a simple pattern, easy to understand and to use. Sometimes it is
used in excess and in scenarios where it is not required. In such cases,
the disadvantages of using it outweigh the advantages it brings. For this reason,
 the singleton pattern is sometimes considered an antipattern or pattern singleton.

 The Singleton method or Singleton Design pattern is one of the simplest
 design patterns. It ensures a class only has one instance, and provides a global point of access to it.
 */
public class MainClass {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        single.doSomething();
    }
}
