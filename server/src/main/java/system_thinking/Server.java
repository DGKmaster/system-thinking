package system_thinking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Server {
    @RequestMapping(value="/", method = RequestMethod.GET)
    @ResponseBody
    public String answer(@RequestParam(value = "answer", required = false) String response) {
        return !StringUtils.isEmpty(response) ? response : "";
    }
}
