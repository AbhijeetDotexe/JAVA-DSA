package com.company;
class OneDimensional{
    int[] arr = null;


    // Constructor to initialize the array and set their values to the minimum integer value in java
    public OneDimensional(int size){
        arr = new int[size];
        for(int i=0;i<arr.length;i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }


    // Insertion in a 1D Array
    public void Insertion(int location, int value){
        try {
            if(arr[location]==Integer.MIN_VALUE){
                arr[location]=value;
                System.out.println("Value Inserted Successfully");
            }else {
                System.out.println("This Cell is already Occupied, OOPS! ");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index to Access Array");
        }
    }


    //Traversing(Reading each element of an Array at least 1 time
    public void Traversal() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }catch (Exception e){
            System.out.println("Array No Longer Working");
        }
    }


    //Searching in an Array
    public void LSearch(int ValueToSearch){
        for(int i =0;i<arr.length;i++){
            if(arr[i]==ValueToSearch){
                System.out.println("Value Found At Index Of "+i);
                return;
            }
        }
        System.out.println(ValueToSearch +" is Not Present In The Array");
    }


    //Deleting element in an Array
    public void Deletion(int ValueToDeleteIndex){
        try {
            arr[ValueToDeleteIndex] = Integer.MIN_VALUE;
            System.out.println("Value At Index "+ValueToDeleteIndex+" Is Deleted Successfully");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The Value You Provided Is Not In The Range Of The Array, OOPS!");
        }
    }
}



// Main Function to call all the functions of the above class
public class SingleDimensionalArray {
    public static void main(String[] args) {
        OneDimensional Tarr = new OneDimensional(5);
        Tarr.Insertion(1,4);
        Tarr.Insertion(0,1);
        Tarr.Insertion(2,16);
        Tarr.Insertion(3,20);
        Tarr.Insertion(4,22);
        Tarr.Insertion(1,5);
        Tarr.Insertion(14,24);

        //Accessing elements of an Array
        var first = Tarr.arr[1];
        System.out.println(first);
        var Second = Tarr.arr[3];
        System.out.println(Second);




        Tarr.Traversal();
        System.out.println();
        Tarr.LSearch(4);
        Tarr.LSearch(24);
        Tarr.Deletion(3);
        System.out.println(Tarr.arr[3]);
    }
}
