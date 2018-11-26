package pro.webapp.service;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ExecShCommand {

    @Autowired
    ApplicationContext context;

    public String execShSinglCommand(String command) {
        StringBuilder res = new StringBuilder();
        try {
            Session session = (Session) context.getBean("SSHSession");
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            channel.setErrStream(System.err);

            InputStream is = channel.getInputStream();
            channel.connect();
            byte[] buff = new byte[1024];
            while (true) {
                while (is.available() > 0) {
                    int i = is.read(buff, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    res.append(new String(buff, 0, i));
                }
                if (channel.isClosed()) {
                    break;
                }
                Thread.sleep(500);

            }
            channel.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res.toString();
    }
}
