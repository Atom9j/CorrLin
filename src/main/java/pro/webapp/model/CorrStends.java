package pro.webapp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;


public class CorrStends {

    private Stend stendAlhilal;
    private Stend stendAtf;
    private Stend stendBOC;
    private Stend stendCapital;
    private Stend stendEuraz;
    private Stend stendNational;
    private Stend stendNBK;
    private Stend stendNurbank;
    private Stend stendRbs;
    private Stend stendRetail;
    private Stend stendSberMobile;
    private Stend stendTengri;
    private Stend stendTsb;


    public Stend getStendAlhilal() {
        return stendAlhilal;
    }

    public void setStendAlhilal(Stend stendAlhilal) {
        this.stendAlhilal = stendAlhilal;
    }

    public Stend getStendAtf() {
        return stendAtf;
    }

    public void setStendAtf(Stend stendAtf) {
        this.stendAtf = stendAtf;
    }

    public Stend getStendBOC() {
        return stendBOC;
    }

    public void setStendBOC(Stend stendBOC) {
        this.stendBOC = stendBOC;
    }

    public Stend getStendCapital() {
        return stendCapital;
    }

    public void setStendCapital(Stend stendCapital) {
        this.stendCapital = stendCapital;
    }

    public Stend getStendEuraz() {
        return stendEuraz;
    }

    public void setStendEuraz(Stend stendEuraz) {
        this.stendEuraz = stendEuraz;
    }

    public Stend getStendNational() {
        return stendNational;
    }

    public void setStendNational(Stend stendNational) {
        this.stendNational = stendNational;
    }

    public Stend getStendNBK() {
        return stendNBK;
    }

    public void setStendNBK(Stend stendNBK) {
        this.stendNBK = stendNBK;
    }

    public Stend getStendNurbank() {
        return stendNurbank;
    }

    public void setStendNurbank(Stend stendNurbank) {
        this.stendNurbank = stendNurbank;
    }

    public Stend getStendRbs() {
        return stendRbs;
    }

    public void setStendRbs(Stend stendRbs) {
        this.stendRbs = stendRbs;
    }

    public Stend getStendRetail() {
        return stendRetail;
    }

    public void setStendRetail(Stend stendRetail) {
        this.stendRetail = stendRetail;
    }

    public Stend getStendSberMobile() {
        return stendSberMobile;
    }

    public void setStendSberMobile(Stend stendSberMobile) {
        this.stendSberMobile = stendSberMobile;
    }

    public Stend getStendTengri() {
        return stendTengri;
    }

    public void setStendTengri(Stend stendTengri) {
        this.stendTengri = stendTengri;
    }

    public Stend getStendTsb() {
        return stendTsb;
    }

    public void setStendTsb(Stend stendTsb) {
        this.stendTsb = stendTsb;
    }

    public Stend getWhere(String name, CorrStends corrStends) {
        Gson gson = new Gson();
        String gObj = gson.toJson(corrStends, CorrStends.class);
        Map<String, Stend> map = gson.fromJson(gObj, new TypeToken<Map<String, Stend>>(){}.getType());
        return map.get(name);
    }
}

