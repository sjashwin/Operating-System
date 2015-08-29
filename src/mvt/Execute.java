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
public class Execute extends Thread{
    static int timer = 0 ;
    Process p = null ;
    Partition partition = null ;
    Execute(Process p, Partition partition){
        this.p = p ;
        this.partition = partition ;
       
    }
    @Override
    public void run(){
        while( true ){
            try{
                Thread.sleep(1000);
                if( p.burst_time() >= 0){
                    p.burst_time -- ;
                }
                else{
                    partition.unload(p); 
                    break ;
                }
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
