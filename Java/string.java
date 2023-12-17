// String pool is a seperate memory structure inside the heap
// why -> All the similar values point to same string in the pool
// Helps in optimization 
// but change in one does not means change in other, will make a new one

// Strings are immutable - does not change

// use equals method for value check 
// use == for to check both value and refrence variable 

public class Strings {
    public static void main(String[] args) {
        // Pretty Printing
        float a = 453.1234f;
        System.out.printf("Formatted number is %.2f", a); // printf will round off 

        // String methods
        System.out.println("a" + "b"); // ab
        System.out.println('a' + 'b'); // 195 // use ascii values
        System.out.println('a' + 3); // 100

       // StringBuilder we can change but not strings 
       StringBuilder builder = new StringBuilder();
       for(int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            builder.append(ch);
       }

       System.out.println(builder.toString())

       String name = "Kanish Bodhwani";

       System.out.println(Arrays.toString(name.toCharArray()));
       System.out.println(name.toString()); 
       System.out.println(name.indexOf('a'));  
       System.out.println("    Kanish   ".strip());  
       System.out.println(name.split(" ")); // ["Kanish", "Bodhwani"]
    }
}