package com.monkeyk.sos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenqiang on 16-7-26.
 */
@Controller
@RequestMapping("/m")
public class controller {
    @ResponseBody
    @RequestMapping(value = "/exists", method = RequestMethod.POST)
    public String exists() {
        return "test";
    }
}
