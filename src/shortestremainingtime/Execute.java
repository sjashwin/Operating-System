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
public class Execute{
    Process p = null ;
    Execute(Process p){
        this.p = p ;
    }
    public void execute(){
        p.burst_time -- ;
    }
}
