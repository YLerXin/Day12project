package vttp.batchb.ssf.day12project.Controller;

import org.springframework.stereotype.Controller;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.random.*;

@Controller
@RequestMapping("/generate")
public class GenController {
    
    @GetMapping
    public String generate(
        @RequestParam MultiValueMap<String,String> form, Model model){
        
        String name = form.getFirst("name");
        String count = form.getFirst("count");

        String list = form.getFirst("list");
  
        if(list != null && name !=null){
            model.addAttribute("name",name);
            List<String> numbers = Arrays.asList(list.split(","));
            model.addAttribute("numbers",numbers);
            String counttemp = String.valueOf(numbers.size());
            model.addAttribute("count",counttemp);

            List<String> picnum = new ArrayList<>();
            for(int i =0;i<numbers.size();i++){
                picnum.add("number"+numbers.get(i)+".jpg");
            }
            model.addAttribute("picNum",picnum);

            return "generate";
        }

        else if(name != null && count != null){
            model.addAttribute("name",name);
            model.addAttribute("count",count);

            Random rand = new Random();
            List<String> randnum = new ArrayList<>();
            for(int i=0;i<Integer.parseInt(count);i++){
            randnum.add("number"+String.valueOf(rand.nextInt(31)+".jpg"));
            }
            model.addAttribute("randnum",randnum);





            return "generate";
        }

        else if(list != null){
            List<String> numbers = Arrays.asList(list.split(","));
            model.addAttribute("numbers",numbers);

            List<String> picnum = new ArrayList<>();
            for(int i =0;i<numbers.size();i++){
                picnum.add("number"+numbers.get(i)+".jpg");
            }
            model.addAttribute("picNum",picnum);


            return "list";
        }else{
            return "error";
        }


    }



}
