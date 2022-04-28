import java.nio.ByteOrder;

public class ByteReverseInteger {
  public static int myByteReverse(int a) {
    int byte1 = 0x000000FF;
    int byte2 = 0x0000FF00;
    int byte3 = 0x00FF0000;
    int byte4 = 0xFF000000;
    byte1 &= a;
    byte1 <<= 24;
    byte2 &= a;
    byte2 <<= 8;
    byte3 &= a;
    byte3 >>>= 8;
    byte4 &= a;
    byte4 >>>= 24;
    int res = byte1 | byte2 | byte3 | byte4;
    return res;
  }

  public static String toBinary(int a) {
    return String.format("%32s", Integer.toBinaryString(a)).replaceAll(" ", "0");
  }

  public static void test(int a) {
    int res = myByteReverse(a);
    System.out.println("Number in decimal system: " + a);
    System.out.println("Number in binary system:  " + toBinary(a));
    System.out.println("Result in decimal system: " + res);
    System.out.println("Result in binary system:  " + toBinary(res));
    if (res == Integer.reverseBytes(a)) {
      System.out.println("Function works correctly!");
    } else {
      System.out.println("Something is wrong...");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("My system byte order: " + ByteOrder.nativeOrder());
    System.out.println();
    test(10);
    test(167772160);
    test(-1);
    test(183536782);
    test(-1903366134);
    test(-60359937);
    test(-366852);
    test(0);
    test(0x1FE3AE);
    test(0x522C);
  }
}
