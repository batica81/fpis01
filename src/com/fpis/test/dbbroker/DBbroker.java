package com.fpis.test.dbbroker;

import com.fpis.test.model.ArtikalEntity;
import com.fpis.test.model.PonudaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class DBbroker {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Session session;
    private Transaction transaction = null;

    public void pokreniDBTransakciju(){
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    public void potvrdiDBTransakciju(){
        this.transaction.commit();
        this.session.close();
    }

    public void ponistiDBTransakciju(){
        this.transaction.rollback();
        this.session.close();
    }

    public List<ArtikalEntity> vratiArtikle(){
        return  (List<ArtikalEntity>) this.session.createQuery("from ArtikalEntity ").list();
    }

    public boolean zapamtiArtikal(ArtikalEntity artikal) {

        try {

            if (artikal.getStatus().equals("insert")) {
                this.session.persist(artikal);
            }

            else if (artikal.getStatus().equals("update")) {
                this.session.saveOrUpdate(artikal);
            }

            else if (artikal.getStatus().equals("delete")) {
                this.session.delete(artikal);
            }

            return true;
        }

        catch (Exception e) {
            System.err.println("Objekat ne moze da se zapamti u bazi... -> " + e);
        return false;
        }
    }

    public List<PonudaEntity> vratiPonude(){
        return  (List<PonudaEntity>) this.session.createQuery("from PonudaEntity ").list();
    }

    public boolean zapamtiPonudu(PonudaEntity ponuda){

        try {

            if (ponuda.getStatus().equals("insert")) {
                this.session.persist(ponuda);
            }

            else if (ponuda.getStatus().equals("update")) {
                this.session.saveOrUpdate(ponuda);
            }

            else if (ponuda.getStatus().equals("delete")) {
                this.session.delete(ponuda);
            }

            return true;
        }

        catch (Exception e) {
            System.err.println("Objekat ne moze da se zapamti u bazi... -> " + e);
            return false;
        }
    }

}
