import java.util.*;

// General Shape class 

class Shape {
double area;
void computeArea() { System.out.println("Compute Area?"); };
void displayShape() { System.out.println("Display Shape?"); };
static void sortShapes(Shape[] shape, int n) { 
    for(int i=0;i<n-1;i++){
        int flag=0;
        for(int j=0;j<n-1-i;j++){
            if(shape[j].area> shape[j+1].area){
                Shape temp = shape[j];
                shape[j] = shape[j+1];
                shape[j+1] = temp;
                flag =1;
            }
        }
        if(flag==0){
            break;
        }
    }
}

}

// Subclass Circle

class Circle extends Shape {

double r;
Circle(double r) { this.r = r; }
 
 // Overridden methods
 void computeArea() { super.area = Math.PI * r * r; }
 void displayShape(Shape[] s, int n) { System.out.printf("Circle(%.2f) Area: %.2f\n", r, super.area); 
    Arrays.sort(s);

}

}

// Subclass Rectangle
class Rectangle extends Shape {

 double l, b;
 Rectangle(double l, double b) { this.l = l; this.b = b; }
 
 // Overridden methods
 void computeArea() { super.area = l * b; }
 void displayShape() { System.out.printf("Rectangle(%.2f,%.2f) Area: %.2f\n", l, b, super.area); }

}

// Subclass Triangle
class Triangle extends Shape {

 double h, b;
 Triangle(double h, double b) { this.h = h; this.b = b; }
 
 // Overridden methods
 void computeArea() { super.area = 0.5 * h * b; }
 void displayShape() { System.out.printf("Triangle(%.2f,%.2f) Area: %.2f\n", h, b, super.area); }

}

// Main class
class Sheets {
// createShape method
    static Shape createShape(int type, Scanner sin) {
        Shape obj;   
        double a, b;
       
        // Create specific shape object based on type
        switch(type) {
            case 1:        // Circle
                                double d=0;
                                if ( sin.hasNextDouble() )
                                    d = sin.nextDouble();
                                else
                                    System.out.println("No input!!!");
                obj = new Circle( d );
                obj.computeArea();
                break;
               
            case 2:        // Rectangle
                obj = new Rectangle( sin.nextDouble(), sin.nextDouble() );
                obj.computeArea();
                break;
       
            case 3:     // Triangle
                obj = new Triangle( sin.nextDouble(), sin.nextDouble() );
                obj.computeArea();
                break;
               
            default:
                System.out.println("Ignored wrong type");
                obj = null;
                break;
           }
       
            return obj;
        }
 
 // main method
 public static void main( String args[] ) {


  Shape Shapes[] = new Shape[50];
  int n, i=0, sheetType;
  Shape s;
  
  Scanner sc = new Scanner(System.in);
  while (sc.hasNextInt()) {
   sheetType = sc.nextInt();  // Input sheet type (1: Circle, 2: Rectangle, 3: Traiangle)
   s = createShape(sheetType, sc);  // Create Shape object
   if (s != null) Shapes[i++] = s; // Populate into Shapes array
  }

  n = i-1;       // No. of sheets
 
 Shape.sortShapes(Shapes, i); 

  for (i=0; i<=n; i++) {
   System.out.print(i+": ");
   Shapes[i].displayShape();
  }
 
 } // end of main()

} // end of Sheets class