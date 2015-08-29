/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityscheduler;

/**
 *
 * @author ashwin
 */
public class Process {
    int burst_time = 0 ;
    int start_time = 0 ;
    int end_time = 0 ;
    int priority = 0 ;
    int process_id = 0 ;
    int arrival_time = 0 ;
    Process( int burst_time, int arrival_time, int process_id, int priority){
        this.burst_time = burst_time ;
        this.arrival_time = arrival_time ;
        this.process_id = process_id ;
        this.priority = priority ;
    }
    int get_priority(){
        return priority ;
    }
    void set_start_time(int time){
        start_time = time ;
    }
    void set_finish_time( int time ){
       end_time = time ;
    }
}
