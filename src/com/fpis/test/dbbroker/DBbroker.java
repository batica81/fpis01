package com.fpis.test.dbbroker;

import com.fpis.test.model.ArtikalEntity;
import com.fpis.test.model.PonudaEntity;
import com.fpis.test.model.StavkaPonudeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
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
        try {
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.err.println("Greska prilikom commit operacije... -> " + e);
        }
    }

    public void ponistiDBTransakciju(){
        try {
            transaction.rollback();
            session.close();
        } catch (Exception e) {
            System.err.println("Greska prilikom rollback operacije... -> " + e);
        }
    }

    public List<ArtikalEntity> vratiArtikle(){
        return  (List<ArtikalEntity>) session.createQuery("from ArtikalEntity ").list();
    }

    public boolean zapamtiArtikal(ArtikalEntity artikal) {

        try {
            if (artikal.getStatus().equals("insert")) {
                session.persist(artikal);
            }
            else if (artikal.getStatus().equals("update")) {
                session.saveOrUpdate(artikal);
            }
            else if (artikal.getStatus().equals("delete")) {
                session.delete(artikal);
            }
            return true;
        }

        catch (Exception e) {
            System.err.println("Objekat ne moze da se zapamti u bazi... -> " + e);
        return false;
        }
    }

    public List<PonudaEntity> vratiPonude(){
        return  (List<PonudaEntity>) session.createQuery("from PonudaEntity ").list();
    }

    public boolean zapamtiPonudu(PonudaEntity ponuda){

        try {
            if (ponuda.getStatus().equals("insert")) {
                session.persist(ponuda);

                Collection<StavkaPonudeEntity> stavkePonude = ponuda.getStavkaPonudesByBrPonude();
                if(stavkePonude!=null){
                    for (Object spRaw:stavkePonude) {
                        StavkaPonudeEntity sp = (StavkaPonudeEntity) spRaw;
                        zapamtiStavkuPonude(sp);
                    }
                }
            }
            else if (ponuda.getStatus().equals("update")) {
                session.saveOrUpdate(ponuda);
                Collection<StavkaPonudeEntity> stavkePonude = ponuda.getStavkaPonudesByBrPonude();
                if(stavkePonude!=null){
                    for (Object spRaw:stavkePonude) {
                        StavkaPonudeEntity sp = (StavkaPonudeEntity) spRaw;
                        zapamtiStavkuPonude(sp);
                    }
                }
            }
            else if (ponuda.getStatus().equals("delete")) {
                session.delete(ponuda);
            }
            return true;
        }

        catch (Exception e) {
            System.err.println("Objekat ne moze da se zapamti u bazi... -> " + e);
            return false;
        }
    }

    public boolean zapamtiStavkuPonude(StavkaPonudeEntity sp) {

        try {
            if (sp.getStatus().equals("insert")) {
                session.persist(sp);
            }
            else if (sp.getStatus().equals("update")) {
                session.saveOrUpdate(sp);
            }
            else if (sp.getStatus().equals("delete")) {
                session.delete(sp);
            }
            return true;
        }

        catch (Exception e) {
            System.err.println("Objekat ne moze da se zapamti u bazi... -> " + e);
            return false;
        }
    }

}
