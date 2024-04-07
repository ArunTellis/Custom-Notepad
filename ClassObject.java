public class Box {
    private double length;
    double height;
    double width;

//    int weight;

    static void greeting() {
        System.out.println("Hey, I am in Box class. Greetings!");
    }

    public double getLength() { //since its a private instance variable we cannot directly access it we need to create the public method which also known as getter to access the value of the length varaible
        return length;
    }

    Box () { //this the default constructor where if any parameters arent passes during object creation this will be called
        this.height = -1;
        this.length = -1;
        this.width = -1;
    }

    // cube
    Box (double side) { //
        super(); //we could also call the super() keyword to the parent class as well since all the classes are extended by Object class
//        Every class inherits the object class
        this.width = side;
        this.length = side;
        this.height = side;
    }

    Box(double length, double height, double width) { //this is the constructor  having the 3 parameters
        System.out.println("Box class constructor");
        this.length = length;
        this.height = height;
        this.width = width;
    }

    Box(Box old) { //we can also pass the object as the parameter to the constructor
        this.height = old.height;
        this.length = old.length;
        this.width = old.width;
    }

//    Box(BoxWeight old) { //we can also pass the other object as the parameter to the but since length in Box  is private and cannot be inherited by the subClass
//        this.height = old.height;
//        this.length = old.length;
//        this.width = old.width;
//    }

}

class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight = -1;
//        this.width=-1; can be set since its a public access
//        this.length=-1; //cannot access it since its private to the parent class i.e is Box
    }

    //    @Override
    static void greeting() { //since its a static method it cannot be overridden since no objects can access it
        System.out.println("Hey, I am in BoxWeight class. Greetings!");
    }

    BoxWeight (BoxWeight other) {
        super(other);
        weight = other.weight;
    }

    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double length, double height, double width, double weight) {
        // used to initialise values present in parent class
        // call the parent class constructor
        //we might get doubt that even though the length variable is private to Box even though we aren't getting error why so?
//        answer is simple that is the BoxWeight class is not initialising the length variable since it's a super class constructor is called it will be initialised by the constructor of the Box class.

        super(length, height, width); //this works since parent is initialised before the child
        System.out.println(super.height);
//        super will just point to the parent class just above the child class even though the object class was there since Box is above the BoxWeight class it will be accessing the Box class
//        Here even though BoxWeight is inheriting the object class why it's referencing to the Box class


//        super();// if we don't pass any parameter to the super constructor then the default constructor of the parent is called
//        System.out.println(super.height);

//        System.out.println(super.width);

//        this.weight = weight;
//        super(length, height, width);// we cannot do this since before the child class the parent class should be initialised
//        we will get the following error "Call to 'super()' must be first statement in constructor body"

//        System.out.println(this.weight); // here we are calling the current class member
//        System.out.println(super.weight); // here we are explicitly calling the parent member weight
//        we could also use the super keyword to explicitly call the parent class members for example
//        If let's assume the parent class i.e, Box has also member variable called weight
//                we can call that member variable with the help of super keyword

        this.weight = weight;
    }

}

class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4, 7.9, 9.9);
        double newLength= box1.getLength();
        System.out.println(newLength);
//        System.out.println(box1.weight); we cannot access the child class methods or variables from the parent class since parent class dont have any idea about how the child class has been implemented
//        accessing of the methods and variables will happen in upward motion i.e, child class can access the parent class members if they are not private we cant do the reverse
        //calling the constructor by passing the object of the same class
        Box box2 = new Box(box1);
        System.out.println(box1.width + " " + box1.height);

        BoxWeight box3 = new BoxWeight();
        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);
        System.out.println(box3.height + " " + box3.weight);


//        Box box5 = new BoxWeight(2, 3, 4, 8); //always the accessing of the thin
//        System.out.println(box5.weight); //We cannot access it we will get following error "Cannot resolve symbol 'weight'"

//The reason:- "It is the type of the reference variable  and not the type of the object which determines what members can be accessed."
// Here the reference variable type is Box whereas it is referencing to the type BoxWeight
//        so all the members that are present in the Box class can be accessed by the variable box5


//        BoxWeight box6 = new Box(2, 3, 4); //here the constructor called is of parent class so we cant initialise the weight of the BoxWeight class
//        System.out.println(box6);

//        Reason:-
//         1. there are many variables in both parent and child classes
//         2. we are given access to variables that are in the ref type i.e. BoxWeight
//         3. hence, we should have access to weight variable
//         4. this also means, that the ones we are trying to access should be initialised
//         5. but here we are calling the constructor of the parent class which means that we are unable to initialise the weight variable
//         6. because downward motion doesn't have the idea on downward classes i.e, parent class don't know
//         about the child classes so it don't know about the members of child class here it is weight


//        Box.greeting();

        BoxWeight box = new BoxWeight();
        BoxWeight.greeting(); // you can inherit but you cannot override
    }
}


//    Box obj1 = new Box();
//    lhs(reference i.e. obj1) is looked by compiler & rhs (object i.e. new Box()) is looked by jvm
// The key to Java’s safety is that you cannot manipulate references as you can actual pointers.
//        Thus, you cannot cause an object reference to point to an arbitrary memory location or manipulate it like an integer.
