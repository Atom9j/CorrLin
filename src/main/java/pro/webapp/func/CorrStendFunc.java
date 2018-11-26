package pro.webapp.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pro.webapp.model.CorrStends;
import pro.webapp.model.Stend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CorrStendFunc {

    @Autowired
    private ApplicationContext context;
    private static Map<Integer, Boolean> flags = new HashMap<>();

    public String getStendRootPath(String name) {
        CorrStends corrStends = (CorrStends) context.getBean("CorrStendInst");
        Stend std = corrStends.getWhere(name, corrStends);
        return std.getServerPath();
    }

    public List<Stend> whichStendWork(String resul) {

        CorrStends corrStends = (CorrStends) context.getBean("CorrStendInst");

        for (int i = 0; i < 13; i++) {
            flags.put(i, true);
        }

        List<Stend> stendList = new ArrayList<Stend>();
        Pattern p = Pattern.compile("([0-9]+) .* ");

        String[] resList = resul.split("\n");
        for (String s : resList) {
            Matcher m = p.matcher(s);
            int pid = 0;

            if (m.find()) {
                pid = Integer.valueOf(m.group(1));
            }

            if (s.matches(".*allhilal.*") && flags.get(0)) {
                corrStends.getStendAlhilal().setPid(pid);
                corrStends.getStendAlhilal().setState(true);
                flags.put(0, false);
            } else if (flags.get(0)) {
                corrStends.getStendAlhilal().setPid(0);
                corrStends.getStendAlhilal().setState(false);
            }

            if (s.matches(".*atf.*") && flags.get(1)) {
                corrStends.getStendAtf().setPid(pid);
                corrStends.getStendAtf().setState(true);
                flags.put(1, false);
            } else if (flags.get(1)) {
                corrStends.getStendAtf().setPid(0);
                corrStends.getStendAtf().setState(false);
            }

            if (s.matches(".*bank_of_china.*") && flags.get(2)) {
                corrStends.getStendBOC().setPid(pid);
                corrStends.getStendBOC().setState(true);
                flags.put(2, false);
            } else if (flags.get(2)) {
                corrStends.getStendBOC().setPid(0);
                corrStends.getStendBOC().setState(false);
            }

            if (s.matches(".*capital.*") && flags.get(3)) {
                corrStends.getStendCapital().setPid(pid);
                corrStends.getStendCapital().setState(true);
                flags.put(3, false);
            } else if (flags.get(3)) {
                corrStends.getStendCapital().setPid(0);
                corrStends.getStendCapital().setState(false);
            }

            if (s.matches(".*euraz.*") && flags.get(4)) {
                corrStends.getStendEuraz().setPid(pid);
                corrStends.getStendEuraz().setState(true);
                flags.put(4, false);
            } else if (flags.get(4)) {
                corrStends.getStendEuraz().setPid(0);
                corrStends.getStendEuraz().setState(false);
            }

            if (s.matches(".*nationalbank.*") && flags.get(5)) {
                corrStends.getStendNational().setPid(pid);
                corrStends.getStendNational().setState(true);
                flags.put(5, false);
            } else if (flags.get(5)) {
                corrStends.getStendNational().setPid(0);
                corrStends.getStendNational().setState(false);
            }

            if (s.matches(".*nbk.*") && flags.get(6)) {
                corrStends.getStendNBK().setPid(pid);
                corrStends.getStendNBK().setState(true);
                flags.put(6, false);
            } else if (flags.get(6)) {
                corrStends.getStendNBK().setPid(0);
                corrStends.getStendNBK().setState(false);
            }

            if (s.matches(".*nurbank.*") && flags.get(7)) {
                corrStends.getStendNurbank().setPid(pid);
                corrStends.getStendNurbank().setState(true);
                flags.put(7, false);
            } else if (flags.get(7)) {
                corrStends.getStendNurbank().setPid(0);
                corrStends.getStendNurbank().setState(false);
            }

            if (s.matches(".*rbs.*") && flags.get(8)) {
                corrStends.getStendRbs().setPid(pid);
                corrStends.getStendRbs().setState(true);
                flags.put(8, false);
            } else if (flags.get(8)) {
                corrStends.getStendRbs().setPid(0);
                corrStends.getStendRbs().setState(false);
            }

            if (s.matches(".*retail.*") && flags.get(9)) {
                corrStends.getStendRetail().setPid(pid);
                corrStends.getStendRetail().setState(true);
                flags.put(9, false);
            } else if (flags.get(9)) {
                corrStends.getStendRetail().setPid(0);
                corrStends.getStendRetail().setState(false);
            }

            if (s.matches(".*sber-mobile.*") && flags.get(10)) {
                corrStends.getStendSberMobile().setPid(pid);
                corrStends.getStendSberMobile().setState(true);
                flags.put(10, false);
            } else if (flags.get(10)) {
                corrStends.getStendSberMobile().setPid(0);
                corrStends.getStendSberMobile().setState(false);
            }

            if (s.matches(".*tengri.*") && flags.get(11)) {
                corrStends.getStendTengri().setPid(pid);
                corrStends.getStendTengri().setState(true);
                flags.put(11, false);
            } else if (flags.get(11)) {
                corrStends.getStendTengri().setPid(0);
                corrStends.getStendTengri().setState(false);
            }

            if (s.matches(".*tsb.*") && flags.get(12)) {
                corrStends.getStendTsb().setPid(pid);
                corrStends.getStendTsb().setState(true);
                flags.put(12, false);
            } else if (flags.get(12)) {
                corrStends.getStendTsb().setPid(0);
                corrStends.getStendTsb().setState(false);
            }
        }
        stendList.add(corrStends.getStendAlhilal());
        stendList.add(corrStends.getStendAtf());
        stendList.add(corrStends.getStendBOC());
        stendList.add(corrStends.getStendCapital());
        stendList.add(corrStends.getStendEuraz());
        stendList.add(corrStends.getStendNational());
        stendList.add(corrStends.getStendNBK());
        stendList.add(corrStends.getStendNurbank());
        stendList.add(corrStends.getStendRbs());
        stendList.add(corrStends.getStendRetail());
        stendList.add(corrStends.getStendSberMobile());
        stendList.add(corrStends.getStendTengri());
        stendList.add(corrStends.getStendTsb());

        return stendList;
    }


}
