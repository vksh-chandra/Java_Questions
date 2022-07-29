class Animal {
    protected String name;
  
    protected void display() {
      System.out.println("I am an animal.");
    }
    public void eat()
    {
      System.out.println("I can eat");
    }
  }
  
  class Dog extends Animal {
  
    public void getInfo() {
      System.out.println("My name is " + name);
    }
    @Override
    public  void eat()
    {
      //super.eat();
      System.out.println("I eat dog food");
    }

  }

  class Cat extends Animal{
      public void walk()
      {
          System.out.println("I can walk ");
      }
  }
  
  class Main {
    public static void main(String[] args) {
  
      // create an object of the subclass
      Dog labrador = new Dog();
      Cat husk = new Cat();
      Animal stat = new Dog();

  
      // access protected field and method
      // using the object of subclass
      labrador.name = "Rocky";
      labrador.display();
      labrador.getInfo();
      
     //only method of super class can be accessed by this type of object decleration
      //stat.name = "Static";
      //stat.getInfo();
      
      stat.eat();

      

      husk.walk();
      husk.name = "Shamy";
      husk.display();
    }
  }