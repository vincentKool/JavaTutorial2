package tutorial.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tutorial.SimplePOJOObject;


/**
 * Advanced Challenge (S02E01)
 */

@RestController
public class AdvancedController extends ApiController {

    @RequestMapping(value="/advanced", method= RequestMethod.GET)
    public SimplePOJOObject advanced() {
        SimplePOJOObject pojoObject = new SimplePOJOObject();
        pojoObject.setValue("abracadabra");
        return pojoObject; }

}