package Movies;

public class TestMovie {
    public static void main(String[] args){
        Movie m1 = new Movie("a","a","a"
                ,"a","a","a","a","a");

        Movie m2 = new Movie("a","a","a"
                ,"a","a","a","a","a");

        System.out.println(m1.equals(m2));
    }
}
