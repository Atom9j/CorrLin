package pro;



public class Main {


    public static void main(String[] args) {



    }

    /*public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String host = "10.6.11.17";
        String user = "DBO";
        String password = "hk)*478Ykj";
        String command = "pgrep -fl tomcat";

        try {
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            config.put("PreferredAuthentications", "password");

            JSch jSch = new JSch();
            Session session = jSch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            session.connect(5000);
            System.out.println("Connected...");

            Scanner reader = new Scanner(System.in);
            //String inputString = reader.nextLine();
            //System.out.println("Was read: " + inputString);


            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            //channel.setCommand(inputString);
            channel.setErrStream(System.err);

            InputStream is = channel.getInputStream();
            channel.connect();

            byte[] buff = new byte[1024];
            while(true) {

                while(is.available() > 0) {
                    int i = is.read(buff, 0, 1024);
                    if(i < 0) {
                        break;
                    }
                    sb.append(new String(buff, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("Exit Status: " + channel.getExitStatus());
                    break;
                }
                Thread.sleep(500);
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE!!!");
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        CorrStendFunc crStd = new CorrStendFunc();
        System.out.println(crStd.whichStendWork(sb.toString()));
        System.out.println(crStd.whichStendWork(sb.toString()));
    }
*/


}
