package pro.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexPage {

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage(Model model) {
        return "index";
    }
}
