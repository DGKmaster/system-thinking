package system_thinking;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class Server {
    Locations db;

    Server() {
        db = Locations.getInstance();
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    @ResponseBody
    public String answer(
        @RequestParam(value = "answer", required = false) String answer
        ) {
        return !StringUtils.isEmpty(answer) ? answer : "";
    }
}
