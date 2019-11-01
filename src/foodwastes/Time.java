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



    Time()
    {

    }


    Time(int days,int hours)
{
this.days=days;
this.hours=hours;

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
    public void swichDayWithBed(){
    {
    this.days+=1;
    this.hours=6;
    }
}

    public void swichDayOutsideOfBedroom(){
{
    
    this.days+=1;
    this.hours=16;
 }
}
    
    public void swichHour(){
    if(this.hours==0){
    System.out.println("you need to sleep");
    }   else if(this.hours==23) {
        this.hours-=23;        
    }   else {
          this.hours+=1;            
            
            }
    }
    public void checkForDaysQuitGame(){
    if(this.days>=8){            
    System.exit(0);   
 
}
    }
   

    
} 
/*if(time.getDateOfMinutes()==50){
            time.swichHour();
            }
        
            else {
            time.swicTenMinutes();
            }    
*/

 

