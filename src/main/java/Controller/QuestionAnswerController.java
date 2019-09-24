package Controller;

import Logic.QAImplementation;
import Logic.QuestionAnswerOptionGenerator;
import Model.Answer;
import Model.Options;
import Model.Question;

public class QuestionAnswerController
{
    QAImplementation generate = null;
    Question question = null;
    Answer answer = null;
    Options options = null;
    public QuestionAnswerController() {
        generate = new QuestionAnswerOptionGenerator();
    }

    public Question getQuestionForDisplay(String level)
    {
        question = generate.generateQuestion(level);
        answer = generate.generateAnswer(question);
        return  question;
    }

    public Boolean getAnswerForCheck(String userAnswer)
    {
        String tempAns = Integer.toString(answer.getAnswer());
        if(userAnswer.equals(tempAns))
        {
            return true;
        }
        return false;

    }

    public Options getOptionsForDisplay()
    {
        options = generate.generateOptions(answer);
        return  options;
    }

}
