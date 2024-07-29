package threadsdemo.threadsafe;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NameList {

    private List<String> names = new LinkedList<>();

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if(names.size() > 0) {
            System.out.println(names.remove(0));
        }
    }
}

