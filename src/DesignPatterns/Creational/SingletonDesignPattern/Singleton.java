package DesignPatterns.Creational.SingletonDesignPattern;

public class Singleton {
    private static Singleton instance;  // object declare as private and static
    private Singleton(){
        System.out.println("Singleton is instantiated");
    }  // constructor private

    public static Singleton getInstance(){  // getInstance check - instance null
        if(instance == null )
            instance = new Singleton();

            return instance;
    }

    public void doSomething(){
        System.out.println("Something is running");
    }
}
// refer gfg course  - there are many types of singleton class


// Double Checked Locking based Java implementation of
// singleton design pattern
//class Singleton
//{
//    private static volatile Singleton obj  = null;
//
//    private Singleton() {}
//
//    public static Singleton getInstance()
//    {
//        if (obj == null)
//        {
//            // To make thread safe
//            synchronized (Singleton.class)
//            {
//                // check again as multiple threads
//                // can reach above step
//                if (obj==null)
//                    obj = new Singleton();
//            }
//        }
//        return obj;
//    }
//}
//
//🔹 Common Implementations
//        1. Eager Initialization
//class Singleton {
//    private static final Singleton instance = new Singleton();
//    private Singleton() {}
//    public static Singleton getInstance() { return instance; }
//}
//
//
//✅ Simple, thread-safe.
//        ❌ Instance created even if never used.
//
//        2. Lazy Initialization (Not Thread-Safe)
//class Singleton {
//    private static Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) instance = new Singleton();
//        return instance;
//    }
//}
//
//
//❌ Breaks in multithreading (multiple instances).
//
//        3. Synchronized Method (Thread-Safe, Slow)
//class Singleton {
//    private static Singleton instance;
//    private Singleton() {}
//    public static synchronized Singleton getInstance() {
//        if (instance == null) instance = new Singleton();
//        return instance;
//    }
//}
//
//
//✅ Thread-safe.
//        ❌ Performance hit (sync every time).
//
//        4. Double-Checked Locking (Best with volatile)
//class Singleton {
//    private static volatile Singleton instance;
//    private Singleton() {}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//}
//
//
//✅ Thread-safe + fast.
//        ✅ Uses volatile to prevent reordering.
//        🔥 Most asked in interviews.
//
//        5. Bill Pugh (Inner Static Helper Class)
//class Singleton {
//    private Singleton() {}
//    private static class Holder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//    public static Singleton getInstance() {
//        return Holder.INSTANCE;
//    }
//}
//
//
//✅ Lazy, thread-safe, no sync overhead.
//        ✅ Cleanest Java implementation.
//        🔥 Best practice in modern Java.
