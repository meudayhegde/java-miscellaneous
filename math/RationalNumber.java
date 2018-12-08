/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author hegdeuday
 */
public class RationalNumber extends Number{
    
    public int NUM;
    public int DNOM;
        
    public RationalNumber(int a, int b){
        NUM=a;DNOM=b;
        simplified();
    }

    public RationalNumber(int a){
        NUM=a;DNOM=1;
    }

    public RationalNumber(String str){
        if(str.contains("/")){
            NUM=Integer.parseInt(str.split("/")[0]);
            DNOM=Integer.parseInt(str.split("/")[1]);
        }
        else{
            NUM=Integer.parseInt(str);
            DNOM=1;
        }
        simplified();
    }
    
    public RationalNumber plus(RationalNumber ri){
        int lcm=lcm(DNOM,ri.DNOM);
        return new RationalNumber(((NUM*lcm/DNOM)+(ri.NUM*lcm/ri.DNOM)),lcm);
    }

    public RationalNumber minus(RationalNumber ri){
        int lcm=lcm(DNOM,ri.DNOM);
        return new RationalNumber(((NUM*lcm/DNOM)-(ri.NUM*lcm/ri.DNOM)),lcm);
    }

    public RationalNumber multiply(RationalNumber ri){
        return new RationalNumber(NUM*ri.NUM,DNOM*ri.DNOM);
    }

    public RationalNumber div(RationalNumber ri){
        return new RationalNumber(NUM*ri.DNOM,DNOM*ri.NUM);
    }

    private void simplified(){
        if(DNOM<0){NUM*=-1;DNOM*=-1;}
        int min=(mod(NUM) < (DNOM)) ? mod(NUM) : mod(DNOM);
        for(int i=min;i>1;i--){
            if((mod(NUM)%i==0)&&(mod(DNOM)%i==0)){
                NUM/=i;DNOM/=i;simplified();
                break;
            }
        }
    }

    private int mod(int a){
        if(a>0)return a;
        else return -a;
    }

    public RationalNumber simplify(){
        simplified();
        return this;
    }

    public double toDouble(){
        return (double)NUM/DNOM;
    }

    private static int lcm(int a, int b){
        int lcm = (a > b) ? a : b;
        while(true){
            if( lcm % a == 0 && lcm % b == 0 ){
                return lcm;
            }
            ++lcm;
        }
    }

    @Override
    public String toString(){
        if(DNOM==1) return NUM+"";
        return NUM+"/"+DNOM;
    }
    
    @Override
    public int intValue() {
        return (int)NUM/DNOM;
    }

    @Override
    public long longValue() {
        return (long)NUM/DNOM;
    }

    @Override
    public float floatValue() {
        return (float)NUM/DNOM;
    }

    @Override
    public double doubleValue() {
        return (double)NUM/DNOM;
    }
}
