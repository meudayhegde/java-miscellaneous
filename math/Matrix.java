/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.Scanner;

/**
 *
 * @author hegdeuday
 */
public class Matrix{
    
    public RationalNumber[][] ratMat;
    
    public Matrix(RationalNumber[][] ratMat){
        this.ratMat=ratMat;
    }
	
	@Override
    public String toString(){
        StringBuilder builder=new StringBuilder("");
            for(RationalNumber[] num:ratMat){
                for(RationalNumber ratNum:num){
                    builder.append(ratNum+"\t");
		}
		builder.append("\n");
            }
	return builder.toString();
    }

    public Matrix plus(Matrix mat)throws MatrixException{
		return new Matrix(add(ratMat,mat.ratMat));
    }

    public Matrix multiply(Matrix mat)throws MatrixException{
        return new Matrix(multiply(ratMat,mat.ratMat));
    }

    public Matrix minus(Matrix mat)throws MatrixException{
        return new Matrix(subtract(ratMat,mat.ratMat));
    }
    
    public Matrix devide(Matrix mat)throws MatrixException,DeterminentException{
        return new Matrix(devide(ratMat,mat.ratMat));
    }
    
    public Matrix inverse()throws MatrixException,DeterminentException{
        return new Matrix(inverse(ratMat));
    }

    public RationalNumber determinent()throws DeterminentException{
        return determinent(ratMat);
    }
    
    public static RationalNumber[][] add(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)throws MatrixException{
        if(ratMat.length!=ratMatB.length || ratMat[0].length!=ratMatB[0].length) throw new MatrixException("Rows and column size mismatch..!!");
    	RationalNumber[][] newMat=new RationalNumber[ratMat[0].length][ratMat.length];
		for(int i=0;i<ratMat[0].length;i++)
            for(int j=0;j<ratMat.length;j++)
                newMat[i][j]=ratMat[i][j].plus(ratMatB[i][j]);
        return newMat;
    }
    
    public static RationalNumber[][] subtract(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)throws MatrixException{
        if(ratMat.length!=ratMatB.length || ratMat[0].length!=ratMatB[0].length) throw new MatrixException("Rows and column size mismatch..!!");
    	RationalNumber[][] newMat=new RationalNumber[ratMat[0].length][ratMat.length];
		for(int i=0;i<ratMat[0].length;i++)
            for(int j=0;j<ratMat.length;j++)
                newMat[i][j]=ratMat[i][j].minus(ratMatB[i][j]);
        return newMat;
    }
    
    public static RationalNumber[][] multiply(RationalNumber[][] ratMat,RationalNumber[][] ratMatB)throws MatrixException{
        if(ratMat[0].length!=ratMatB.length) throw new MatrixException("Incompatible matrices for multiplication..!!");
        RationalNumber[][] newMat=new RationalNumber[ratMat.length][ratMatB[0].length];
        for(int i=0;i<ratMat.length;i++)
            for(int j=0;j<ratMatB[0].length;j++){
                newMat[i][j]=new RationalNumber(0);
                for(int k=0;k<ratMat[0].length;k++)
                    newMat[i][j]=newMat[i][j].plus(ratMat[i][k].multiply(ratMatB[k][j]));
            }
        return newMat;
    }
    
    public static RationalNumber[][] devide(RationalNumber[][] ratMat,RationalNumber[][] ratMatB) throws DeterminentException, MatrixException{
        return multiply(ratMat,inverse(ratMatB));
    }
    
    public static RationalNumber[][] inverse(RationalNumber[][] ratMat) throws DeterminentException{
        if(ratMat.length!=ratMat[0].length)throw new DeterminentException();
        RationalNumber[][] newMat=new RationalNumber[ratMat.length][ratMat[0].length];
        RationalNumber[][] tmpMat=new RationalNumber[ratMat.length-1][ratMat[0].length-1];
        RationalNumber det=determinent(ratMat);
        for(int i=0;i<ratMat.length;i++)
            for(int j=0;j<ratMat[0].length;j++){
                for(int k=0,row=0,col=0;k<ratMat.length;k++)
                    for(int l=0;l<ratMat[0].length;l++)
                        if(k!=i && l!=j){
                            tmpMat[row][col++]=ratMat[k][l];
                            if(col==tmpMat[0].length){row++;col=0;}
                        }
                newMat[j][i]=determinent(tmpMat).multiply(new RationalNumber((int)Math.pow(-1, i+j))).div(det);
            }
        return newMat;
    }
    
    public static RationalNumber determinent(RationalNumber[][] ratMat)throws DeterminentException{
        if(ratMat.length!=ratMat[0].length)throw new DeterminentException();
        else if(ratMat.length==1){
            return ratMat[0][0];
        }
        else if(ratMat.length==2){
            return ratMat[0][0].multiply(ratMat[1][1]).minus(ratMat[1][0].multiply(ratMat[0][1]));
        }
        else{
            RationalNumber[][] newRatMat=new RationalNumber[ratMat.length-1][ratMat[0].length-1];
            for(int i=1;i<ratMat.length;i++){
                for(int j=1;j<ratMat[0].length;j++){
                    newRatMat[i-1][j-1]=ratMat[i][j].minus(ratMat[i][0].multiply(ratMat[0][j]).div(ratMat[0][0]));
                }
            }
            return determinent(newRatMat).multiply(ratMat[0][0]);
        }
    }

    public static void main(String args[]) throws MatrixException,DeterminentException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array order");
        int n=sc.nextInt();
        RationalNumber[][] rn=new RationalNumber[n][n];
        System.out.println("Enter matrix values");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rn[i][j]=new RationalNumber(sc.nextInt());
            }
        }
        System.out.println("Determinent : "+new Matrix(rn).determinent());
        System.out.println("Inverse :\n"+new Matrix(rn).inverse());
      
    }
}

class DeterminentException extends Exception{}
class MatrixException extends Exception{
    public MatrixException(String msg){
        super(msg);
    }
}
