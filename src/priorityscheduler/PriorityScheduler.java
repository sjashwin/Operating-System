/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityscheduler;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author ashwin
 */
public class PriorityScheduler {
    static LinkedList<Process> waiting = null ;
    static LinkedList<Process> ready = null ;
    static Scanner reader = null ;
    static int timer = 0 ;
    static int current = 0 ;
    static ListIterator<Process> iter = null ;
    static LinkedList<Process> clone = null ;
    /**
     * @param args the command line arguments
     */
    PriorityScheduler(){
        waiting = new LinkedList<>()  ;
        ready = new LinkedList<>() ;
        reader = new Scanner(System.in) ;
        clone = (LinkedList<Process>) waiting.clone() ;
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
            System.out.println( ready.element().process_id) ;
            ready.element().burst_time-- ;
            if( ready.element().burst_time <= 0 ){
                ready.element().set_finish_time(timer);
                ready.remove() ;
            }
            if( ready.isEmpty())
                break ;
        }
         
        /*for( Process current : process){
            System.out.println( current.priority ) ;
        }*/
    }
}
