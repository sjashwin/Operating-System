/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityscheduler;

import java.util.Comparator;

/**
 *
 * @author ashwin
 */
public class Sort implements Comparator<Process> {

    @Override
    public int compare(Process o1, Process o2) {
        
        return ( o1.get_priority() < o2.get_priority() ) ?1 : -1 ;
    }
    
}
