package example;
import com.fpis.test.dbbroker.DBbroker;
import com.fpis.test.model.ArtikalEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.SQLException;
import java.util.List;


@WebService()
public class HelloWorld {
  @WebMethod
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    System.out.println("Not a meaningful thing.");
    return result;
  }

  public String vratiArtikle() {


      DBbroker dbb = new DBbroker();
      dbb.pokreniDBTransakciju();
      List<ArtikalEntity> listaArtikala = dbb.vratiArtikle();
      String csvResult = "sifraartikla,NAZIVARTIKLA,JEDINICAMERE,OPISARTIKLA,cena\n";

      try {

          csvResult += "";

          for (Object artikalRaw:listaArtikala) {

              ArtikalEntity artikal = (ArtikalEntity) artikalRaw;

              csvResult += artikal.getSifraartikla() + ", ";
              csvResult += artikal.getNazivartikla() + ", ";
              csvResult += artikal.getJedinicamere() + ", ";
              csvResult += artikal.getOpisartikla() + ", ";
              csvResult += artikal.getCena() + "\n";
          }

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("");
      System.out.println("Podaci poslati sa SERVERA:");
      System.out.println("--------------------------");
      System.out.println("");
      System.out.println(csvResult);
      return csvResult;
  }



  public static void main(String[] argv) {
    Object implementor = new HelloWorld ();
    String address = "http://localhost:9000/HelloWorld";
    Endpoint.publish(address, implementor);
  }
}
