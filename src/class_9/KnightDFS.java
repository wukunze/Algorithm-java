package class_9;
import java.sql.Struct;
import java.util.*;
import java.util.Stack;

public class KnightDFS {

    public static Stack<Point> stack=new Stack();

    public static int rode_case = 0;


    public static void main(String[] srgs){
        System.out.println("knight begin: ");

        int side_length = 5; //5
        //5 * 5 的边界  range = 4
        int range =   side_length - 1;



        KnightDFS.DFS(new Point(2,2, range) ,side_length);

        System.out.println("一共有" + rode_case + "种走法");

//        stack.push( new Point(1,2, range) );
//        stack.push( new Point(1,2, range) );
//        stack.push( new Point(55,66, range) );
//        stack.push( new Point(1,2, range) );
//        stack.push( new Point(1,2, range) );



//        System.out.println( KnightDFS.printStack() );

    }


    public static boolean pointInStack(Point point){
        for( Point p :stack){
            if(p.x == point.x && p.y == point.y)
                return true;
        }
        return false;
    }

    public static int getStackLength(){
        int len = 0;
        for( Point p :stack){
            len += 1;
        }
        return len;
    }

    public static void printStack(){
        for( Point p :stack){
            System.out.print( "(" + p.x + "," + p.y + ") "  );
        }
        System.out.println();
        System.out.println();
    }


    public static boolean DFS(Point point, int side_length){
        if( KnightDFS.pointInStack(point) ){
            return true;
        }
        stack.push(point);
        if(KnightDFS.getStackLength() == (side_length * side_length)  ){
            KnightDFS.printStack();
            rode_case += 1;
            stack.pop();
            return true;
        }
        for( int type = 1; type <=8 ; type++ ){
            Point next_point = point.nextPoint(type);
            if( next_point.if_in_range() ){
                DFS(next_point, side_length);
            }
        }
        stack.pop();
        return true;
    }

}

class Point{
    public int x,y; //点的坐标
    public int range; //点的边界
    public Point(int x, int y, int range){
        this.x = x;
        this.y = y;
        this.range = range;
    }

    public boolean if_in_range(){
        //当前这个点是否在边界内
        if(this.x < 0 || this.x > range)
            return false;
        if(this.y < 0 || this.y > range)
            return false;
        return true;
    }

    public Point nextPoint(int type){
        //当前这个点的下一个坐标是多少
        Point point = new Point(this.x, this.y, this.range);
        switch (type){
            case 1:
                point.x += 2; point.y += 1;
                break;
            case 2:
                point.x += 1; point.y += 2;
                break;
            case 3:
                point.x -= 1; point.y += 2;
                break;
            case 4:
                point.x -= 2; point.y += 1;
                break;
            case 5:
                point.x -= 2; point.y -= 1;
                break;
            case 6:
                point.x -= 1; point.y -= 2;
                break;
            case 7:
                point.x += 1; point.y -= 2;
                break;
            case 8:
                point.x += 2; point.y -= 1;
                break;
        }
        return point;
    }
}