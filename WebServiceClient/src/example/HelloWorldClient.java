package example;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          example.HelloWorld ws = new HelloWorldService().getHelloWorldPort();
          ws.vratiArtikle();
          System.out.println("");
          System.out.println("Podaci primljeni na KLIJENTU:");
          System.out.println("-----------------------------");
          System.out.println("");
          System.out.println(ws.vratiArtikle());

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
