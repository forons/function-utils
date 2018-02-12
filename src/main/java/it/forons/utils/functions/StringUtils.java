package it.forons.utils.functions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtils {

  /**
   * Used only for Java Beans
   */
  public StringUtils() {
    super();
  }

  public static boolean isEmptyOrNull(String str) {
    return isEmptyOrNull(str, false);
  }

  public static boolean isEmptyOrNull(String str, boolean isTrimmed) {
    return str == null || str.isEmpty() || (isTrimmed && str.trim().isEmpty());
  }

  public static String fromLastIndexOf(String str, char charToFind) {
    return fromLastIndexOf(str, charToFind, true);
  }

  public static String fromLastIndexOf(String str, char charToFind, boolean isIncluded) {
    if (str == null) {
      return null;
    }
    int from = isIncluded ? str.lastIndexOf(charToFind) : str.lastIndexOf(charToFind) + 1;
    return str.substring(from);
  }

  public static String fromLastIndexOf(String str, String stringToFind) {
    return fromLastIndexOf(str, stringToFind, true);
  }

  public static String fromLastIndexOf(String str, String stringToFind, boolean isIncluded) {
    if (str == null) {
      return null;
    }
    int from = isIncluded ? str.lastIndexOf(stringToFind) : str.lastIndexOf(stringToFind) + 1;
    return str.substring(from);
  }

  public static boolean isPalyndrom(String str) {
    return str != null && new StringBuilder(str).reverse().toString().equals(str);
  }

  public static boolean areAnagrams(String str1, String str2) {
    return areAnagrams(str1, str2, false);
  }

  public static boolean areAnagrams(String str1, String str2, boolean isCaseSensitive) {
    char[] chars1 = isCaseSensitive ? str1.toCharArray() : str1.toLowerCase().toCharArray();
    char[] chars2 = isCaseSensitive ? str2.toCharArray() : str2.toLowerCase().toCharArray();

    if (chars1.length != chars2.length) {
      return false;
    }

    Map<Character, Integer> elements = new HashMap<>();
    for (int i = 0; i < chars1.length; i++) {
      elements.put(chars1[i], elements.getOrDefault(chars1[i], 0) + 1);
      elements.put(chars2[i], elements.getOrDefault(chars2[i], 0) - 1);
    }

    for (Map.Entry<Character, Integer> elem : elements.entrySet()) {
      if (elem.getValue() != 0) {
        return false;
      }
    }
    return true;
  }

  public static String mkString(List<String> strings, CharSequence delimiter) {
    return strings.stream().collect(Collectors.joining(delimiter));
  }

  public static String mkString(String[] strings, CharSequence delimiter) {
    return Arrays.asList(strings).stream().collect(Collectors.joining(delimiter));
  }

}
