package pro.webapp.conf;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Configuration
public class AppInit {

    @Bean(name = "SSHSession")
    public Session getSSHSession() {
        System.out.println("Start init connection...");
        String host = "10.6.11.17";
        String user = "DBO";
        String password = "hk)*478Ykj";

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("PreferredAuthentications", "password");

        JSch jSch = new JSch();
        Session session = null;
        try {
            session = jSch.getSession(user, host, 22);

        session.setPassword(password);
        session.setConfig(config);
        session.connect(50000);
        System.out.println("Connected...");
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return session;
    }
}
