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
public class Partition {
    int size = 0 ;
    double id = 0 ;
    int permanent = 0;
    
    Partition( int size, double id ){
        this.size = size ;
        this.id = id ;
        permanent = size ;
    }
    boolean load( Process p ){
        if( size >= p.get_size() ){
            size = size-p.get_size() ;
            System.out.println("Process has been loaded in Partition "+
                id+" available memory space "+size) ;
            return true ;
        }
        else
            return false ;   
    }
    void unload(Process p){
        size = p.get_size()+size ;
        System.out.println( " process "+p.get_id()+" has been completed ");
    }
}
