package class_2;
/*
作业：
x^6 - 6x^4 + x^3 + 12x + 根号3 = 0   求一个实解，精度10^-6
*/
public class homework {
    private static double function(double x)
	{
        return Math.pow(x, 6) - 6*Math.pow(x, 4) + Math.pow(x, 3) + 12*x + Math.sqrt(3);
	}
	public static void main(String[] args) {
		double x1,x2,y1,y2,x3,y3;
		x1=-1.0;x2=1.0;x3=0;
		y1=function(x1);
		y2=function(x2);
		y3=function(x3);
		if(y1*y2<0){
			do
			{
				x3=(x1+x2)/2;
				y3=function(x3);
				if(y1*y3<0)
				{
					x2=x3;
					y2=y3;
				}
				if(y2*y3<0)
				{
					x1=x3;
					y1=y3;
				}
			}while(Math.abs(y3)>=Math.pow(10,-6));
		}
		System.out.println(x3);
		System.out.println(y3);
	}
}
