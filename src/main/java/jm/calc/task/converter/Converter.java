package jm.calc.task.converter;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class RomanComparator implements Comparator<Integer> {

  @Override
  public int compare(final Integer o1, final Integer o2) {
    return o2.intValue() - o1.intValue();
  }
}

class ArabicComparator implements Comparator<Integer> {

  @Override
  public int compare(final Integer o1, final Integer o2) {
    return o1.intValue() - o2.intValue();
  }
}

public class Converter {

  private static Map<Integer, String> roman_map;

  Iterator<Map.Entry<Integer, String>> it;

  public Converter() {
  }

  private void InitialConverter(Comparator<Integer> comparator) {

    roman_map = new TreeMap<>(comparator);

    for (Roman r : Roman.values())
      roman_map.put(r.getVal(), r.toString());
  }

  public String toRoman(int val) {

    InitialConverter(new RomanComparator());

    it = roman_map.entrySet().iterator();

    StringBuilder result = new StringBuilder();

    while (it.hasNext()) {

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

    InitialConverter(new ArabicComparator());

    int result = 0;
    int size = val.length();

    int i = 0;
    do {
      String curr = String.valueOf(val.charAt(i));
      String next = String.valueOf((i < size - 1) ? val.charAt(i + 1) : null);

      Map.Entry<Integer, String> elem;

      if (next != null & getElem(curr.concat(next)) != null) {
        elem = getElem(curr.concat(next));
      } else {
        elem = getElem(curr);
        i--;
      }

      result = result + elem.getKey();

    } while ((i += 2) < size);

    return result;
  }

  private Map.Entry<Integer, String> getElem(final String curr_val) {

    it = roman_map.entrySet().iterator();

    while (it.hasNext()) {

      Map.Entry<Integer, String> elem = it.next();

      if (curr_val.equals(elem.getValue()))
        return elem;
    }
    return null;
  }
}