/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvt;

/**
 *
 * @author ashwin
 */
public class Process {
    int id = 0 ;
    int burst_time = 0;
    int size = 0;
    int permanent = 0;
    Process( int id, int burst_time, int size ){
        this.id = id ;
        this.burst_time = burst_time ;
        this.size = size ;
        permanent = size ;
    }
    int burst_time(){
        return burst_time ;
    }
    int get_size(){
        return permanent ;
    }
    int get_id(){
        return id ;
    }
    void display(){
        System.out.print(id+burst_time+size) ;
    }
}
