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
    
private int hours=0;

private int days=0;

private boolean inBed =false;

    Time()
    {

    }


    Time(int days,int hours)
{
this.days=days;
this.hours=hours;

}

Time(int hours, int days, boolean inBed)
{
this.days=days;
this.hours=hours;
this.inBed=inBed;
}

public void setDate(int days, int hours){
this.days=days;
this.hours=hours;

}

public int getDateOfHours(){
return hours;
    
}

public int getDateOfDays(){
return days;
    
}
public void swichDay(){
if(this.inBed==true){
    this.days+=1;
    this.hours=6;
    this.inBed=false;
 }
}

public void swichHour(){
   this.hours+=1;
    
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


