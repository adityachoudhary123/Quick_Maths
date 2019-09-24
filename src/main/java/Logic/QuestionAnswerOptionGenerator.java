package Logic;


import java.util.Random;


import Model.Answer;
import Model.Options;
import Model.Question;

public class QuestionAnswerOptionGenerator implements QAImplementation {

    Random random = null;
    Question question = null;
    Answer answer = null;
    Options options = null;


    public QuestionAnswerOptionGenerator() {
        random = new Random();
        question = new Question();
        answer = new Answer();
        options = new Options();
    }

    public Question generateQuestion(String level) {
        int numb1, numb2, op;
        String operator = "+";

        if (level.equals("EASY"))
        {
            numb1 = random.nextInt(100) + 1;
            numb2 = random.nextInt(100) + 1;
            op = random.nextInt(1);
        }
        else if (level.equals("MODERATE"))
        {
            numb1 = random.nextInt(250) + 1;
            numb2 = random.nextInt(250) + 1;
            op = random.nextInt(2);
        }
        else if (level.equals("HARD"))
        {
            op = random.nextInt(3);
            int bound = 0;
            if (op == 0 || op == 1) {
                bound = 500;
            } else if (op == 2) {
                bound = 25;
            }
            numb1 = random.nextInt(bound) + 1;
            numb2 = random.nextInt(bound) + 1;

        }
        else {
            op = random.nextInt(3);
            int bound = 0;
            int incr = 0;
            if (op == 0 || op == 1) {
                bound = 1000;
                incr = 500;
            } else if (op == 2) {
                bound = 20;
                incr = 10;
            }
            numb1 = random.nextInt(bound) + incr;
            numb2 = random.nextInt(bound) + incr;
        }

        if (op == 0) {
            operator = "+";
        } else if (op == 1) {
            operator = "-";
        } else if (op == 2) {
            operator = "X";
        }

        question.setNumbDispOne(numb1);
        question.setNumbDispTwo(numb2);
        question.setOperator(operator);

        return question;

    }
    public Answer generateAnswer(Question question) {
        int numb1 = question.getNumbDispOne();
        int numb2 = question.getNumbDispTwo();
        String op = question.getOperator();
        int ans = 0;

        if (op.equals("+")) {
            ans = numb1 + numb2;
        } else if (op.equals("-")) {
            ans = numb1 - numb2;
        } else if (op.equals("X")) {
            ans = numb1 * numb2;
        }

        answer.setAnswer(ans);
        return answer;
    }
    public Options generateOptions(Answer answer) {
        int ans = answer.getAnswer();

        int rand = random.nextInt(3);

        if (rand == 0) {
            options.setOptOne(ans);
            options.setOptTwo(ans + 10);
            options.setOptThree(ans - 10);
        } else if (rand == 1) {
            options.setOptOne(ans + 10);
            options.setOptTwo(ans);
            options.setOptThree(ans - 10);
        } else if (rand == 2) {
            options.setOptOne(ans - 10);
            options.setOptTwo(ans + 10);
            options.setOptThree(ans);
        }
        return options;
    }
}
