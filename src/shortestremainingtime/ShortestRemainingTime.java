/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestremainingtime;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 *
 * @author ashwin
 */
public class ShortestRemainingTime {

    /**
     * @param args the command line arguments
     */
    static LinkedList<Process> ready ;
    static LinkedList<Process> run ;
    static int timer ; 
    static int current ;
    ShortestRemainingTime(){
        ready = run = new LinkedList<>() ;
        timer = current = 0 ;
    }
    static void sort(){
        Process[] process = new Process[ready.size()] ;
        process =  ready.toArray(process) ;
        
        for( Process current : process){
            System.out.println(current.burst_time  );
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ShortestRemainingTime srt = new ShortestRemainingTime() ;
        ready.add(new Process(10,1)) ;
        ready.add(new Process(20,2)) ;
        ready.add(new Process(3,3)) ;
        while( true ){
            if( current < ready.size()){
                if( ready.get(current).arrival_time == timer ){
                    run.offer(ready.get(current)) ;
                    current++ ;
                }
            }
            Collections.sort(run, new Sort());
            run.element().burst_time-- ;
            if(run.element().burst_time <= 0){
                run.remove() ;
            }
            if( run.isEmpty())
                break ;
        }
    }
}
