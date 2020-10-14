package com.demo.rege.Controller;

import com.demo.rege.Model.Response;
import com.demo.rege.controller.InterruptibleCharSequence;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class RegController {
	
	@PostMapping("/api/{regex}/{textBody}")
    public Response getResponse(@PathVariable("regex") String regex, @PathVariable("textBody") String textBody) {
        Response response = new Response();
        try {
            Pattern r = Pattern.compile(regex); 
            Runnable runnable = new Runnable() {
   	         @Override
   	         public void run()
   	         {
   	            Matcher interruptableMatcher = r.matcher(new InterruptibleCharSequence(textBody));
   	            if(interruptableMatcher.find()) {
   	            	response.setMatch(interruptableMatcher.group(0)); 
   	            }  
				else {
   	            	response.setMatch(null);
   	            }
   	         }
   	      };

   	      Thread thread = new Thread(runnable);
   	      thread.start();

   	      Thread.sleep(500);
   	      thread.interrupt();
   	      response.setError(false);
        } catch (InterruptedException exception ) {
            response.setMatch(null);
            response.setError(true);
        }
        return response;
    }
}
