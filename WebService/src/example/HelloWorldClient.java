package example;

public class HelloWorldClient {
  public static void main(String[] argv) {
    example.HelloWorld service = new HelloWorldService().getHelloWorldPort();
    //invoke business method
    service.sayHelloWorldFrom("yo");
  }
}
