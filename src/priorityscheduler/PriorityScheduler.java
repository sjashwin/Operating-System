/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityscheduler;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author ashwin
 */
public class PriorityScheduler {
    static LinkedList<Process> waiting = null ;
    static LinkedList<Process> ready = null ;
    static int timer = 0 ;
    static int current = 0 ;
    /**
     * @param args the command line arguments
     */
    PriorityScheduler(){
        waiting = new LinkedList<>()  ;
        ready = new LinkedList<>() ;
        timer = 0 ;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new PriorityScheduler() ;
        waiting.add(new Process(12, 1, 1, 1)) ;
        waiting.add(new Process(13, 2, 2, 2)) ;
        waiting.add(new Process(12, 3, 3, 1)) ;
        waiting.add(new Process(1, 4, 4, 4)) ;
        waiting.add(new Process(20, 7, 5, 2)) ;
        waiting.add(new Process(13, 10, 6, 3)) ;
        waiting.add(new Process(15, 11, 7, 3)) ;
        waiting.add(new Process(17, 12, 8, 1)) ;
        while( true ){
            timer++ ;
            if( current<waiting.size() ){
                if( waiting.get(current).arrival_time == timer ){
                    ready.offer(waiting.get(current)) ;
                    ready.element().set_start_time(timer);
                    current++ ;
                }
            }
            Collections.sort( ready, new Sort() );
            //System.out.println( ready.element().process_id) ;
            ready.element().burst_time-- ;
            if( ready.element().burst_time <= 0 ){
                ready.element().set_finish_time(timer);
                ready.remove() ;
            }
            if( ready.isEmpty())
                break ;
        }
        System.out.println("id|priority|burst_time|start|end_time|waiting") ;
        for( Process i: waiting){
            System.out.println(i.process_id+"\t"+i.get_priority()+
                    "\t"+i.get_burst_time()+"\t"+i.arrival_time+"\t"+i.end_time+"\t"+
                    (i.end_time-i.arrival_time)) ;
        }
    }
}
