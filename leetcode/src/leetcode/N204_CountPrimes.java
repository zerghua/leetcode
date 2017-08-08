package leetcode;

/**
 * Created by Hua on 5/23/2016.

 Description:

 Count the number of prime numbers less than a non-negative number, n.


 Hint:

 Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?

 As we know the number must not be divisible by any number > n / 2, we can immediately cut the total iterations half by dividing only up to n / 2. Could we still do better?

 Let's write down all of 12's factors:

 2 × 6 = 12
 3 × 4 = 12
 4 × 3 = 12
 6 × 2 = 12

 As you can see, calculations of 4 × 3 and 6 × 2 are not necessary. Therefore, we only need to consider factors up to √n because, if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.

 Our total runtime has now improved to O(n1.5), which is slightly better. Is there a faster approach?

 public int countPrimes(int n) {
     int count = 0;
     for (int i = 1; i < n; i++) {
         if (isPrime(i)) count++;
         }
     return count;
 }

 private boolean isPrime(int num) {
     if (num <= 1) return false;
     // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
     // to avoid repeatedly calling an expensive function sqrt().
     for (int i = 2; i * i <= num; i++) {
         if (num % i == 0) return false;
     }
     return true;
 }


 */
public class N204_CountPrimes {
    // Amazon, Microsoft
    //28 ms
    //https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    public int countPrimes(int n) {
        if(n<2) return 0; // prime number start from 2
        boolean[] isPrime = new boolean[n+1];
        for(int i=2;i<=n;i++) isPrime[i] = true;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime[i]){
                for(int j=2;i*j<=n;j++) isPrime[i*j]=false;
            }
        }

        int ret=0;
        for(int i=2;i<n;i++)if(isPrime[i])ret++;
        return ret;
    }
}
