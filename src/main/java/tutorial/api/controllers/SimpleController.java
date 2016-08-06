package tutorial.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Simple Challenge (S02E01)
 */

@RestController
public class SimpleController extends ApiController {

    @RequestMapping(value="/simple", method= RequestMethod.GET)
    public String simple() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        return dateFormat.format(date); }

}