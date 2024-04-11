package Lection3.AbstractClassAndInterface;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void walk();
    protected abstract void saySmth();
    protected void jump(){
        System.out.println("jumps");
    }
    private void eat(){
        System.out.println("eats");
    }
}
