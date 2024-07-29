package threadsdemo.threadticktock;

import java.io.IOException;

public class TickTock {

    String state = "sticked";

    synchronized void tick(boolean running){

        if(!running){
            state = "ticked";
            notifyAll();
            return;
        }
        System.out.print("Tick -- ");
        state = "ticked";
        notifyAll();

        try {
            while(!state.equals("tocked")){
                wait();
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }

    synchronized void tock(boolean running){
        if(!running){
            state = "tocked";
            notifyAll();
            return;
        }

        System.out.print("Tock");
        System.out.println("\n");
        state = "tocked";
        notifyAll();

        try {
            while(!state.equals("ticked")){
                wait();
            }
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }

}
