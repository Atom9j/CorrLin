package pro.webapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.webapp.model.CorrStends;
import pro.webapp.model.Stend;

@Configuration
public class CorrStendInit {

    private static CorrStends cStd;

    @Bean(name = "CorrStendInst")
    public CorrStends getCorrStend() {
        if (cStd == null) {
            cStd = new CorrStends();
            cStd.setStendAlhilal(new Stend("AlHilal", "stendAlhilal", false, "/opt/tomcat_allhilal/", "http://10.6.11.17:8100/ru/html/login.html"));
            cStd.setStendAtf(new Stend("ATF Bank", "stendAtf", false, "/opt/tomcat-atf/", "http://10.6.11.17:8086/"));
            cStd.setStendBOC(new Stend("Bank Of China", "stendBOC", false, "/opt/tomcat-bank_of_china/", "http://10.6.11.17:8099/"));
            cStd.setStendCapital(new Stend("Capital", "stendCapital", false, "/opt/tomcat-capital/", "http://10.6.11.17:8083/"));
            cStd.setStendEuraz(new Stend("Eurasian Bank", "stendEuraz", false, "/opt/tomcat-euraz/", "http://10.6.11.17:8082/sbns-web/ru/html/login.html"));
            cStd.setStendNational(new Stend("National bank", "stendNational", false, "/opt/tomcat-nationalbank/", "http://10.6.11.17:8091/ru/html/login.html"));
            cStd.setStendNBK(new Stend("Halyk Bank", "stendNBK", false, "/opt/tomcat-nbk/", "http://10.6.11.17:8080/ru/html/login.html"));
            cStd.setStendNurbank(new Stend("Nurbank", "stendNurbank", false, "/opt/tomcat-nurbank/", "http://10.6.11.17:8081/sbns-web/"));
            cStd.setStendRbs(new Stend("RBS", "stendRbs", false, "/opt/tomcat-rbs/", "http://10.6.11.17:8088/"));
            cStd.setStendRetail(new Stend("Correqts Retail", "stendRetail", false, "/opt/tomcat-retail/", "http://10.6.11.17:8096/"));
            cStd.setStendSberMobile(new Stend("Sber-Bank", "stendSberMobile", false, "/opt/tomcat-sber-mobile/", "http://10.6.11.17:8084/ru/html/login.html"));
            cStd.setStendTengri(new Stend("Tengri Bank", "stendTengri", false, "/opt/tomcat-tengri/", "http://10.6.11.17:8090/ru/html/login.html"));
            cStd.setStendTsb(new Stend("TSB Bank", "stendTsb", false, "/opt/tomcat-tsb/", "http://10.6.11.17:8102/ru/html/login.html"));
        }
        return cStd;
    }
}
