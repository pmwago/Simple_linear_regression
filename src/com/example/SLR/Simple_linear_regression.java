package com.example.SLR;
import java.util.*;

public class Simple_linear_regression {
    public static void main(String[] args) {
        int n;
        double averageX,averageY ,sumX = 0,sumY = 0,r,b,c,Sx,Sy;
        double sumProduct = 0,denom = 0,sumXminusMeanSquared = 0,sumYminusMeanSquared = 0;

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the value of n ");
        n=scan.nextInt();
        double[] X=new double[n];
        double[] Y=new double[n];
        double[] XminusMean=new double[n];
        double[] YminusMean=new double[n];
        double[] product=new double[n];
        double[] XminusMeanSquared=new double[n];
        double[] YminusMeanSquared=new double[n];

        System.out.println("Enter the values of X and Y");
        for(int i=0;i<n;i++){
            X[i]=scan.nextDouble();
            Y[i]= scan.nextDouble();

            sumX+=X[i];
            sumY+=Y[i];
        }
        averageX=sumX/n;
        averageY=sumY/n;

        for (int k=0;k<n;k++){
            XminusMean[k]=X[k]-averageX;
            YminusMean[k]=Y[k]-averageY;
            product[k]=XminusMean[k]*YminusMean[k];

            sumProduct+=product[k];

            XminusMeanSquared[k]=Math.pow(XminusMean[k], 2);
            YminusMeanSquared[k]=Math.pow(YminusMean[k], 2);

            sumXminusMeanSquared+=XminusMeanSquared[k];
            sumYminusMeanSquared+=YminusMeanSquared[k];

            denom=Math.sqrt(sumXminusMeanSquared*sumYminusMeanSquared);
        }
        r=sumProduct/denom;
        Sx=Math.sqrt(sumXminusMeanSquared/(n-1));
        Sy=Math.sqrt(sumYminusMeanSquared/(n-1));
        b=(r*Sy)/Sx;
        c=averageY-(b*averageX);

        System.out.println("y = "+b+"x  +  "+c);

    }

}
