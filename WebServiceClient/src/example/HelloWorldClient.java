package example;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          example.HelloWorld ws = new HelloWorldService().getHelloWorldPort();
          //invoke business method
          ws.vratiArtikle();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
