import GLOOP.*;
import java.lang.*;

public class Asteroid
{
    private Ufo dasUfo;
    GLKugel asteroid, asteroid2, asteroid3;
    private Ufo meinUfo;
    private Clock clock;
     
    
    public Asteroid(Ufo pUfo){
        int x=(int)(Math.random()*3000-2900);
        int y=(int)(Math.random()*3000-2900);
        int z=(int)(Math.random()*3000-1500);
        int k=(int)(Math.random()*120);
        asteroid= new GLKugel(x,y,z,k);
        asteroid.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
        meinUfo= pUfo;

    }

    public void fallen(){
        asteroid.verschiebe(0,-2,0);
        asteroid.drehe(0.1,0.1,0.1);
        if(asteroid.gibY()<-300)this.zuruecksetzen();
        if(this.getroffen())meinUfo.explodiere();

    }

    private boolean getroffen(){
        
        double abstand=Math.sqrt(
                Math.pow(asteroid.gibY()-meinUfo.gibY(),2)+
                Math.pow(asteroid.gibX()-meinUfo.gibX(),2)+
                Math.pow(asteroid.gibZ()-meinUfo.gibZ(),2)
            );
            
            
        
        
        if(abstand<70 )return true;
        else return false;  
        
        
    }
    
    private void zuruecksetzen(){
        int x=(int)(Math.random()*3000-1500);
        int z=(int)(Math.random()*3000-1500);
        int p=(int) (Math.random()*3000-800);
        asteroid .setzePosition(x,p,z);
        asteroid.setzeSkalierung(1,Math.random()+0.3,Math.random()+0.3);
    }
    public void verschiebe(double a, double b, double c){
        asteroid.verschiebe(a,b,c);
        
    }

}