
abstract class exampleAbstract{
    exampleAbstract()
    {
        System.out.println("This is example of abstract");
    }

    abstract void makeSound();

    public void eat1(){
        System.out.println("I can not eat");
    }
}
class Dog1 extends exampleAbstract{
    Dog1()
    {
        super();
        System.out.println("Calling from this");
    }

    public void makeSound()
    {
        System.out.println("bhow bhow");
    }

    public void walk1()
    {
        System.out.println("I can not walk");
    }
}

class Main1{
    public static void main(String[] args) {
        
        Dog1 d2 = new Dog1();

        d2.eat1();
        d2.walk1();
    }
}