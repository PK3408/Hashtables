// Name: Pranav Kartha
// Class: CS 3305/Section 01
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: Visual Studio Code

import java.util.Scanner; //import scanner

public class hashFunctions{

    //method that prints hashtable
    public static void printTable(int[][] hashTable){

        System.out.println("Index    Key     probes");
        System.out.println("------------------------");
        //use a for loop to print array values
        for(int x = 0; x < hashTable.length; x++ ){

        System.out.println(" " + x + "       " + hashTable[x][0] + "      " + hashTable[x][1]);


        }
        System.out.println("------------------------");
    }

    //return total number of probes done
    public static int sumProbes(int [][] hashTable){

        int sum = 0; //store sum

        for(int x = 0; x < hashTable.length; x++){

            sum += hashTable[x][1]; //add value to sum

        }

        return sum;
    }

    //function that uses division method with linear probing
    public static void HF1(int[] keytable, int[][] hashTable){

        //use division method for each key
        for(int x = 0; x < keytable.length; x++){

        int position = ((keytable[x] % keytable.length));

        //use linear probing to store value, use a while loop

        //keep track of number of probes
        int probes = 0;
        while(hashTable[position][0] != 0){

            position = (position + 1) % hashTable.length ; //increment position until spot available
            
            probes++; //keep track of probes
        }

        //store values in hashTable
        hashTable[position][0] = keytable[x]; //store key
        hashTable[position][1] = probes; //store probes

        }

    }

    //function that uses division method with quadratic probing
    public static void HF2(int[] keytable, int[][] hashTable){

        //use division method for each key
        for(int x = 0; x < keytable.length; x++){

        int position = ((keytable[x] % keytable.length));

        //use quadratic probing to store value, use a while loop

        //keep track of number of probes
        int probes = 0;
        int increment = 1; //keep track of increment
        int initialposition = position; //keep track of initial position
        while(hashTable[position][0] != 0){

            position = (int) ((initialposition + Math.pow(increment,2)) % hashTable.length); //increment position until spot available
            increment++; //increment increment
            
            probes++; //keep track of probes
        }

        //store values in hashTable
        hashTable[position][0] = keytable[x]; //store key
        hashTable[position][1] = probes; //store probes

        }

    }

     //function that uses division method with double hashing
     public static void HF3(int[] keytable, int[][] hashTable){

        //use division method for each key
        for(int x = 0; x < keytable.length; x++){

        int position = ((keytable[x] % keytable.length));

        //find the double hash
        int doublehash = 30 - keytable[x] % 25;

        //use double hashing to store value, use a while loop

        //keep track of number of probes
        int probes = 0;
        int increment = 1; //keep track of increment
        int initialposition = position; //keep track of initial position
        while(hashTable[position][0] != 0){

            //check if over probing limit
            if(probes > 50){

                System.out.println("unable to hash key " + keytable[x]);
                break; //break out of loop

            }

            else{
            position = (int) ((initialposition + increment * doublehash) % hashTable.length); //increment position until spot available
            increment++; //increment increment
            
            probes++; //keep track of probes

            }
        }

        //check if over probe limit
        if(probes > 50){

            continue; //break out of iteration
        }
        else{

        //store values in hashTable
        hashTable[position][0] = keytable[x]; //store key
        hashTable[position][1] = probes; //store probes
        }

        }

    }

     //function that uses the folding method with double hashing
     public static void HF4(int[] keytable, int[][] hashTable){

        //use folding method for each key, find each digit
        for(int x = 0; x < keytable.length; x++){

        //find each digit
        int dig1 = keytable[x] % 10;
        int dig2 = (keytable[x] % 100) / 10;
        int dig3 = (keytable[x] % 1000) / 100;
        int dig4 = keytable[x] / 1000;


        /*  get position by adding all digits and digit 4 again. Folding method shown in the slides 
        required getting each digit and adding them to get position in hash table to get enough unique results 
        but still be less than the amount of places in hash table, digit 4 was added twice. Biggest possible value was 9999. 9 added 5 times was 45*/
        int position = dig1 + dig2 + dig3 + dig4 + dig4;

        //find the double hash
        int doublehash = 30 - keytable[x] % 25;

        //use double hashing to store value, use a while loop

        //keep track of number of probes
        int probes = 0;
        int increment = 1; //keep track of increment
        int initialposition = position; //keep track of initial position
        while(hashTable[position][0] != 0){

            //check if over probing limit
            if(probes > 50){

                System.out.println("unable to hash key " + keytable[x]);
                break; //break out of loop

            }

            else{
            position = (int) ((initialposition + increment * doublehash) % hashTable.length); //increment position until spot available
            increment++; //increment increment
            
            probes++; //keep track of probes

            }
        }

        //check if over probe limit
        if(probes > 50){

            continue; //break out of iteration
        }
        else{

        //store values in hashTable
        hashTable[position][0] = keytable[x]; //store key
        hashTable[position][1] = probes; //store probes
        }

        }

    }


    public static void main(String[] args){

    //create scanner class
    Scanner sc = new Scanner(System.in);

        //array of hash keys
    int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
 5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
 5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
 5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
 5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

 //define hashtable 

 int[][] Table = new int[50][2];

 //make a while loop to print out menu
 boolean isLooping = true;
 while(isLooping == true){

    //print out menu
    System.out.println();
    System.out.println("-----MAIN MENU--------------------------------------");
    System.out.println("1. Run HF1 (Division method with Linear Probing)");
    System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
    System.out.println("3. Run HF3 (Division method with Double Hashing)");
    System.out.println("4. Run HF4 (Student Designed HF)");
    System.out.println("5. Exit program");
    System.out.println();
    System.out.println("Enter option number:");
    System.out.println();

    int user_output = sc.nextInt();
    System.out.println();

    //use switch case to handle different inputs
    switch(user_output){

        case 1:

        //print out menu before probing
        System.out.println("menu before method: ");
        printTable(Table);
        System.out.println();
        System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
        System.out.println();
        HF1(keys,Table); //commit table function
        //print out table after probing
        System.out.println("Hash table resulted from HF1: ");
        System.out.println();
        //print out menu before probing
        printTable(Table);
        System.out.println();
        System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
        System.out.println();
        Table = new int[50][2]; //clear table

        break;
        case 2:

         //print out menu before probing
         System.out.println("menu before method: ");
         printTable(Table);
         System.out.println();
         System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
         System.out.println();
         HF2(keys,Table); //commit table function
         //print out table after probing
         System.out.println("Hash table resulted from HF2: ");
         System.out.println();
         //print out menu before probing
         printTable(Table);
         System.out.println();
         System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
         System.out.println();
         Table = new int[50][2]; //clear table

        break;
        case 3:

          //print out menu before probing
          System.out.println("menu before method: ");
          printTable(Table);
          System.out.println();
          System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
          System.out.println();
          HF3(keys,Table); //commit table function
          //print out table after probing
          System.out.println("Hash table resulted from HF3: ");
          System.out.println();
          //print out menu before probing
          printTable(Table);
          System.out.println();
          System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
          System.out.println();
          Table = new int[50][2]; //clear table

        break;
        case 4:

        //print out menu before probing
        System.out.println("menu before method: ");
        printTable(Table);
        System.out.println();
        System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
        System.out.println();
        HF4(keys,Table); //commit table function
        //print out table after probing
        System.out.println("Hash table resulted from HF4: ");
        System.out.println();
        //print out menu before probing
        printTable(Table);
        System.out.println();
        System.out.println("Sum of probe values = " + sumProbes(Table)); //print out sum of probes
        System.out.println();
        Table = new int[50][2]; //clear table
        break;
        case 5:
        //break out of loop
        isLooping = false;
        break;
        default:
        System.out.println("not a valid input, enter a number 1 - 5");

    }
 }



 
}
}