/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwastes;

/**
 *
 * @author mathi
 */
public class Time {

private int minutes=0;

private int hours=0;

private int days=0;

private boolean inBed =false;

Time()
{

}


Time(int days,int hours, int minutes)
{
this.days=days;
this.hours=hours;
this.minutes=minutes;
}

Time(int hours, int days, int minutes,boolean inBed)
{
this.days=days;
this.hours=hours;
this.minutes=minutes;
this.inBed=inBed;
}

public void setDate(int days, int hours, int minutes){
this.days=days;
this.hours=hours;
this.minutes=minutes;
}

public int getDateOfHours(){
return hours;
    
}

public int getDateOfDays(){
return days;
    
}

public int getDateOfMinutes(){
return minutes;
    
}

public void swichDay(){
if(this.hours==20| this.minutes==0 || this.inBed==true){
    this.days+=1;
    this.hours=6;
    this.inBed=false;
 }
}

public void swichHour(){
if(this.minutes==50){
    this.hours+=1;
    this.minutes=0;
    
 }
 
} 

public void swicTenMinutes(){
    this.minutes+=10;
    
 }
public boolean getInBed()
{
 return inBed;   
}
        

public void SetInBed()
{
this.inBed=true;    
} 
/*if(time.getDateOfMinutes()==50){
            time.swichHour();
            }
        
            else {
            time.swicTenMinutes();
            }    
*/



} 


