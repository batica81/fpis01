package com.fpis.test.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StavkaPonudeEntityPK implements Serializable {
    private int rbr;
    private int brPonude;

    @Column(name = "Rbr")
    @Id
    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    @Column(name = "BrPonude")
    @Id
    public int getBrPonude() {
        return brPonude;
    }

    public void setBrPonude(int brPonude) {
        this.brPonude = brPonude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavkaPonudeEntityPK that = (StavkaPonudeEntityPK) o;
        return rbr == that.rbr &&
                brPonude == that.brPonude;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rbr, brPonude);
    }
}
