/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestremainingtime;

/**
 *
 * @author ashwin
 */
public class Process {
   int burst_time ;
   int waiting_time ;
   int arrival_time ;
   int start_time ;
   int finish_time ;
   Process(int burst_time, int arrival_time ){
       waiting_time = start_time = finish_time = 0 ;
       this.burst_time = burst_time ;
       this.arrival_time = arrival_time ;
   }
   int get_burst_time(){
       return burst_time ;
   }
}
