package mvt;
import java.util.Scanner; 
import java.util.Iterator;
import java.util.Queue ;
import java.util.LinkedList ;
/**
 *
 * @author ashwin
 */
public class MVT extends Thread{
    static Queue<Partition> partition = null;
    static Iterator iter = null ;
    static Scanner reader = null ;
    static int choice = 0 ;
    /**
     * @param args the command line arguments
     */
    MVT(){
        partition = new LinkedList<>() ;
        iter = partition.iterator() ;
        reader = new Scanner(System.in) ;
    }
    static void create_partition(){
        partition.add(new Partition(20000, Math.round(Math.random()*1000))) ;
        partition.add(new Partition(23000, Math.round(Math.random()*1000))) ;
    }
    static void load_process(Process p){
        for( Partition current_partition : partition){
            if(current_partition.load(p)){
                new Execute(p, current_partition).start();
                return ;
            }
        }
        System.out.println("No memory available");
    }
    static void display(){
        System.out.println("Partition Available_memory Total_Memory") ;
        for (Partition current_partition : partition){
            System.out.println(current_partition.id+"\t"
                    +current_partition.size+"\t"
                    +current_partition.permanent) ;
        }
    }
    @Override
    public void run(){
        while( true ){
            System.out.println("----\n"
                    + "Enter a choice : \n1.Add process\n2.Display Partition\n3.exit\n"
            +"----------------") ;
            choice = reader.nextInt() ;
            switch(choice){
            case 1 :{
                System.out.println("Enter process id, burst time and size");
                MVT.load_process(new Process(reader.nextInt(), reader.nextInt(), reader.nextInt())) ;
                
                break ;
            }
            case 2 :{
                MVT.display();
                break ;
            }
            case 3:
                System.exit(0) ;
            default :
            System.out.println("-------------\n"
                    + "Enter a choice : \n 1.Add process\n2.Display Partition\n3.Exit"+
                    "\n--------------------------") ;
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        MVT mvt = new MVT();
        MVT.create_partition() ;
        mvt.start();
    }
}
