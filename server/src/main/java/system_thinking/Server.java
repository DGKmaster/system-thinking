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
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "money", required = false) String money,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "myCoordD", required = false) String myCoordD,
                         @RequestParam(value = "myCoordS", required = false) String myCoordS,
                         @RequestParam(value = "sortby", required = false) String sortby,
                         @RequestParam(value = "page", required = false) String page
                         ) {
        return db.fetchJson( Integer.valueOf(time), Integer.valueOf(money), type, Float.valueOf(myCoordD), Float.valueOf(myCoordS), sortby, Integer.valueOf(page));
    }
}
