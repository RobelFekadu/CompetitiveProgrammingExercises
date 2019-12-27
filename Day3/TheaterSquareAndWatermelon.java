import java.util.*;

public class TheaterSquareAndWatermelon{

    public static void main(String[] args) {
        Watermelon();
        TheaterSquare();
    }
    
    private static void Watermelon(){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if(count % 2 == 0 && count > 2)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void TheaterSquare(){
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        long d = 1;
        if(a % c == 0)
            d = d * (a/c);
        else
            d = d * ((a/c) + 1);
        if(b % c == 0)
            d = d * (b/c);
        else
            d = d * ((b/c) + 1);
        System.out.println(d);
    }
}