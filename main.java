import xjtlu.cpt111.assignment.quiz.model.Question;

import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args)  throws IOException  {
        ReadQuestions rq = new ReadQuestions();//loading the questions
        ArrayList<Question> questionsList=  rq.readQuestions();
        initiate initiate = new initiate();
        initiate.readFile();//Loading User data
        initiate.start();

    }
}
