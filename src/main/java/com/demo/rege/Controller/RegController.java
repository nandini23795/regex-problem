package com.demo.rege.Controller;

import com.demo.rege.Model.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@RestController
public class RegController {

    @PostMapping("/api/{regex}/{textBody}")
    public Response getResponse(@PathVariable("regex") String regex, @PathVariable("textBody") String textBody) {
        Response response = new Response();
        try {
            Pattern r = Pattern.compile(regex);
            Matcher m = r.matcher(textBody);
            if (m.find()) {
                response.setMatch(m.group(0));
            } else {
                response.setMatch(null);
            }
            response.setError(false);
        } catch (PatternSyntaxException exception) {
            response.setMatch(null);
            response.setError(true);
        }
        return response;
    }
}
