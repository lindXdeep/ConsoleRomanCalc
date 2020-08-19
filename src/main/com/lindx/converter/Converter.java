package main.com.lindx.converter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Converter {

    private static Map<Integer, String> roman_map = new TreeMap<>(new Comparator<Integer>(){

        @Override
        public int compare(final Integer o1, final Integer o2) {     
            return  o2.intValue() - o1.intValue();
        }
    });

    Iterator<Map.Entry<Integer, String> > it;

    public Converter() {

        for (Roman r : Roman.values())
            roman_map.put(r.getVal(), r.toString());    
    }

    public String toRoman(int val) {

        it = roman_map.entrySet().iterator();

        StringBuilder result = new StringBuilder();

        while(it.hasNext()){

            Map.Entry<Integer, String> elem = it.next();

            int m = elem.getKey();

            while (val >= m) {
                val -= m;
                result.append(elem.getValue());
            }
        }
        return result.toString();
    }

    public int toArabic(String val) {

        int result = 0;

        for (char ch : val.toCharArray()) {
            
            it = roman_map.entrySet().iterator();

            while (it.hasNext()) {

                Map.Entry<Integer, String> elem = it.next();
                
                String m = elem.getValue();

                if(String.valueOf(ch).equals(m)){
                    result += elem.getKey();
                }
            }
        }
        return result;
    }
}