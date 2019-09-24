package Logic;

import Model.Answer;
import Model.Options;
import Model.Question;

public interface QAImplementation {

    Question generateQuestion(String level);
    Answer generateAnswer(Question question);
    Options generateOptions(Answer answer);
}
