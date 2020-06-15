模板方法设计模式
    项目中比较常见 典型的类加载器ClassLoader
使用场景
    一般是为了统一子类的算法实现步骤，所使用的一种方式。它在父类中定义一系列算法的步骤，而将具体的实现都推迟到子类。
    最典型的形式就是一个接口，一个抽象父类，父类中会有一系列的抽象方法，而在子类中去一一实现这些方法。
    通常情况下，模板方法模式用于定义构建某个对象的步骤与顺序，或者定义一个算法的骨架。
    