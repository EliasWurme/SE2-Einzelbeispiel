package at.wurme.se2einzelbeispiel;

import java.util.ArrayList;
import java.util.Collections;

public class NumberSorter {

    public NumberSorter() {
    }


    public String sortInput(String input) {
        String output = "";
        String split[] = input.split("");

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            String str = split[i];
            int n = Integer.parseInt(str);
            if(!isPrim(n)) {
                list.add(n);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            output += list.get(i);
        }
        return output;
    }


    public boolean isPrim(int n) {
        boolean prim = false;
        if ((n == 2) || (n == 3) || (n == 5) || (n == 7)) {
            prim = true;
        }
        return prim;
    }
}
