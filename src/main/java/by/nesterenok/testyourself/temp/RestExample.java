package by.nesterenok.testyourself.temp;

import by.nesterenok.testyourself.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")

public class RestExample {

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> questionList(){

        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(1));
        questionList.add(new Question(2));

        return questionList;

    }
}
