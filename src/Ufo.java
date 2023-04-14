import GLOOP.*;
import java.lang.*;
public class Ufo{
    private GLTorus rumpf;
    private GLTastatur tastatur ;
    private GLKugel cockpit;
    private GLKegel fluegel1, fluegel2;
    //[...]

    public Ufo(){

        cockpit= new GLKugel(0,0,0,10);
        rumpf=new GLTorus(0,0,0,20,5);
        fluegel1=new GLKegel(0,0,0,5,2);
        fluegel2=new GLKegel(0,0,0,5,2);
    }

    public void bewegeOben(){
        if(this.gibZ()>(500)){
        }
        else{
            cockpit.verschiebe(0,0,1);
            fluegel1.verschiebe(0,0,1);
            fluegel2.verschiebe(0,0,1);
            rumpf.verschiebe(0,0,1);
        }
        }
    

    public void bewegeUnten(){       
        if(this.gibZ()<(-500)){
        }
        else{
            cockpit.verschiebe(0,0,-1);
            fluegel1.verschiebe(0,0,-1);
            fluegel2.verschiebe(0,0,-1);
            rumpf.verschiebe(0,0,-1);
        }
    } 

    public void bewegeLinks(){       
        if(this.gibX()<(-500)){
        }
        else{
            cockpit.verschiebe(-1,0,0);
            fluegel1.verschiebe(-1,0,0);
            fluegel2.verschiebe(-1,0,0);
            rumpf.verschiebe(-1,0,0);
        }
    }

    public void bewegeRechts(){       
        if(this.gibX()>(500)){
        }
        else{
            cockpit.verschiebe(1,0,0);
            fluegel1.verschiebe(1,0,0);
            fluegel2.verschiebe(1,0,0);
            rumpf.verschiebe(1,0,0);
        }
    } 

    public void bewegeVor(){       
        if(this.gibY()>(500)){
        }
        else{
            cockpit.verschiebe(0,1,0);
            fluegel1.verschiebe(0,1,0);
            fluegel2.verschiebe(0,1,0);
            rumpf.verschiebe(0,1,0);
        }
    } 

    public void bewegeHinten(){       
        if(this.gibY()>(500)){
        }
        else{
            cockpit.verschiebe(0,-1,0);
            fluegel1.verschiebe(0,-1,0);
            fluegel2.verschiebe(0,-1,0);
            rumpf.verschiebe(0,-1,0);
        }
    } 
    public void schieße(){       
        if(this.gibY()>(500)){
        }
        else{
            cockpit.verschiebe(0,-1,0);
            fluegel1.verschiebe(0,-1,0);
            fluegel2.verschiebe(0,-1,0);
            rumpf.verschiebe(0,-1,0);
        }
    } 

    public void explodiere(){
        //[...]
        double q=Math.random();
        for(int i=0;i<2000;i++){
            rumpf.verschiebe(-q,q,q);
            rumpf.drehe(-q,q,q);
            cockpit.verschiebe(-q,+q,q);
            cockpit.drehe(-q,+q,q);
            fluegel1.verschiebe(-q,q,-q);
            fluegel2.verschiebe(-q,q,-q);
            Sys.warte();
        }
        Sys.beenden();
    }

    public double gibX(){
        return cockpit.gibX();}

    public double gibY(){
        return cockpit.gibY();}

    public double gibZ(){
        return cockpit.gibZ();}

}
