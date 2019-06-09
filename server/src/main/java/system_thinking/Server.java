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
                         @RequestParam(value = "time", required = false) String userTimeLimit,
                         @RequestParam(value = "money", required = false) String userMoney,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "mycoordD", required = false) String myCoordD,
                         @RequestParam(value = "mycoordS", required = false) String myCoordS,
                         @RequestParam(value = "sortby", required = false) String sortby
                         ) {
        return db.fetchRoutes( Integer.valueOf(userTimeLimit), Integer.valueOf(userMoney), type, Float.valueOf(myCoordD), Float.valueOf(myCoordS), sortby);
    }
}
