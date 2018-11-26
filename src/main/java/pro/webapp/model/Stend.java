package pro.webapp.model;

public class Stend {

    private int pid;
    private String name;
    private String sysName;
    private boolean state;
    private String serverPath;
    private String stendLink;

    public Stend() {
    }

    public Stend(String name, String sysName, boolean state, String serverPath, String stendLink) {
        this.name = name;
        this.sysName = sysName;
        this.state = state;
        this.serverPath = serverPath;
        this.stendLink = stendLink;
    }

    public Stend(int pid, String name, boolean state) {
        this.pid = pid;
        this.name = name;
        this.state = state;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getStendLink() {
        return stendLink;
    }

    public void setStendLink(String stendLink) {
        this.stendLink = stendLink;
    }
}
