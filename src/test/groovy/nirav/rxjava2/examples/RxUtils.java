package nirav.rxjava2.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RxUtils {
    /**
     * Generate List of positive numbers
     * @param n
     * @return
     */
    public static List<Integer> postiveNumbers (Integer n){
        //List to hold positiveNumbers of size n
        List<Integer> postiveNumbers= new ArrayList<>(n);

        //Interate over n elements and add to list
        for(int i=1;i<=n;i++){
            postiveNumbers.add(i);
        }
        return postiveNumbers;
    }

    /**
     * List of positive numbers
     * @param n
     * @return
     */
    public static List<Shape> shapes(Integer n){
        //List to hold shapes of size n
        List<Shape> shapes= new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            shapes.add(new Shape(randomShape(),randomColor()));
        }
        return shapes;

    }
    /**
     * Geneate List of prime numbers
     * @param n
     * @return
     */
    public static List<Integer> primeNumbers (Integer n) {
        //List to hold primeNumbers of size n
        List<Integer> primeNumbers= new ArrayList<>(n);

        //
        boolean totalPrimeCollected=false;
        int i=1;
        int totalNumbers=0;
        //Interate over n elements and add to list
        while(!totalPrimeCollected){
            if(isPrime(i)){
                primeNumbers.add(i);
                totalNumbers++;
            }
            i++;
            if(totalNumbers==n){
                totalPrimeCollected=true;
            }
        }
        return primeNumbers;

    }

    /**
     * Find if number is prime
     * @param n
     * @return the result in boolean
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String  randomColor(){
        Random random= new Random();
        String []colors={"blue","green","red","yellow","pink"};
        return colors[random.nextInt(getRandomNumberInRange(1,4))];
    }

    private static String  randomShape(){
        Random random= new Random();
        String []shape={"square","triangle","circle","pentagon","hexagon","stars"};
        return shape[random.nextInt(getRandomNumberInRange(1,6))];
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
