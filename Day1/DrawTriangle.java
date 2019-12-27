import java.util.*;

public class DrawTriangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        drawTriangleOne(sc);
        
        drawTriangleTwo(sc);
    }

    private static void drawTriangleOne(Scanner sc){
        int count = sc.nextInt();

        for(int i = 0; i <= count; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void drawTriangleTwo(Scanner sc){
        int count = sc.nextInt();

        int width = 1;

        if(count <= 1)
            width = count;
        else{
            for(int i = 1; i < count; i++){
                width += 2;
            }
        }

        int offset;
        int offset2;

        System.out.println(width);
        for(int i = 0; i < count; i++){
            offset = count - i - 1 ;
            offset2 = width - offset;
            for(int j = 0; j < width; j++){
                if(j < offset || j >= offset2)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}