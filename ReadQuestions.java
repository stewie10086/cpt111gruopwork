

import xjtlu.cpt111.assignment.quiz.model.Question;
import xjtlu.cpt111.assignment.quiz.util.IOUtilities;

import java.util.ArrayList;
import java.util.List;

public class ReadQuestions {
    private static List<Question> latestQuestions = new ArrayList<>();
    private static final String RESOURCES_PATH = "src/resources/";
    private static final String QUESTIONS_BANK_PATH = "src\\resources\\questionsBank";
    private static final String EMPTY_FOLDER = "resources/questionsBank/emptyFolder";
    public static ArrayList<Question> readQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        String filename = RESOURCES_PATH + "questions.xml";
        filename = QUESTIONS_BANK_PATH + "questions.xml";
        // filename = RESOURCES_PATH;
        filename = QUESTIONS_BANK_PATH;
        // filename = EMPTY_FOLDER;

        try {
            System.out.println("===\n=== read questions - started\n===");
            Question[] questions = IOUtilities.readQuestions(filename);
            if (null == questions || questions.length == 0) {
                System.out.println("Questions is empty!");
            } else {
                int numQuestions = 0;
                for (Question question : questions) {
                    System.out.println("Question #" + (++numQuestions) + " " + question.toString());
                    questionList.add(question);
                }
                latestQuestions = new ArrayList<>(questionList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("===\n=== read questions - complete\n===");
        }return new ArrayList<>(questionList);

    }
    public static void main(String[] args) {
        ArrayList<Question> questionList = new ArrayList<>();
        String filename = RESOURCES_PATH + "questions.xml";
        filename = QUESTIONS_BANK_PATH + "questions.xml";
        // filename = RESOURCES_PATH;
        filename = QUESTIONS_BANK_PATH;
        // filename = EMPTY_FOLDER;

        try {
            System.out.println("===\n=== read questions - started\n===");
            Question[] questions = IOUtilities.readQuestions(filename);
            if (null == questions || questions.length == 0) {
                System.out.println("Questions is empty!");
            } else {
                int numQuestions = 0;
                for (Question question : questions) {
                    System.out.println("Question #" + (++numQuestions) + " " + question.toString());
                    questionList.add(question);
                }
                latestQuestions = new ArrayList<>(questionList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("===\n=== read questions - complete\n===");
        }

    }


}
