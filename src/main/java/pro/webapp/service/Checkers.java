package pro.webapp.service;

import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class Checkers {

    @Autowired
    ApplicationContext context;

    @Scheduled(fixedRate = 5000)
    public void CheckConnection() {
        Session sshSession = (Session) context.getBean("SSHSession");
        if (sshSession.isConnected()) {
            System.out.println("Connection established!");
        } else {
            System.out.println("Connection FAILED!");
        }
    }
}
