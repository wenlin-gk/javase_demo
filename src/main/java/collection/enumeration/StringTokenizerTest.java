package collection.enumeration;

import java.util.StringTokenizer;

/**
 * @author 飞扬
 * @see StringTokenizer implements Enumeration<Object>
 */
public class StringTokenizerTest {
  public static void main(String[] args) {
    String emailStr = "wenlin_gk@163.com;wenlin_gk@qq.com;wenlin_gk@sohu.com";
    StringTokenizer token = new StringTokenizer(emailStr, ";");
    while (token.hasMoreElements()) {
      System.out.println(token.nextElement());
    }
  }
}
