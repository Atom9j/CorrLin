package pro.webapp.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pro.webapp.db.dao.StendDao;
import pro.webapp.func.CorrStendFunc;
import pro.webapp.model.Stend;
import pro.webapp.service.ExecShCommand;

import java.util.List;

@Controller
@RequestMapping("/manage/**")
public class IndexManagePage {

    @Autowired
    private ExecShCommand execShCommand;

    @Autowired
    CorrStendFunc corrStendFunc;

    @Autowired
    private StendDao stendDao;

    @RequestMapping(method = RequestMethod.GET)
    public String indexManagePage(Model model) {
        String resRemoteExec = execShCommand.execShSinglCommand("pgrep -fl tomcat");
        List<Stend> corrListStends = corrStendFunc.whichStendWork(resRemoteExec);
        model.addAttribute("resultOfExec", corrListStends);

        for (pro.webapp.db.model.Stend st : stendDao.stendList()) {
            System.out.println("STEND LIST: " + st.getName() + " : " + st.getServerPath());
        }
        return "manage/index";
    }


    @RequestMapping(value = "/exeCustomCommand", method = RequestMethod.POST)
    public String indexManageExecCustomCommand(@ModelAttribute("command") String command, Model model) {
        //String resRemoteExec = execShCommand.execShSinglCommand(command);
        return "manage/index";
    }

    @RequestMapping(value = "/killProcStend", method = RequestMethod.POST)
    public String killStendProc(@ModelAttribute("pid") Integer pid, Model model) {
        System.out.println("PID FOR KIL: " + pid);
        execShCommand.execShSinglCommand("kill -9 " + pid);
        return "redirect:/manage";
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String startStend(@ModelAttribute("sysName") String sysName, Model model) {
        String rootPath = corrStendFunc.getStendRootPath(sysName);
        execShCommand.execShSinglCommand(rootPath + "bin/startup.sh");
        System.out.println("command: " + rootPath + "bin/startup.sh");
        return "redirect:/manage";
    }
}
