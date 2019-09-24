package Logic;

public class CalculateScore implements CalculateScoreImpl{


    public int calculateScore(int countR, int countW)
    {
        int score = 0;
        if((countR+countW) > 20)
        {
            score = (countR*100)/(countR+countW);
        }
        else
        {
            score = (countR*100)/20;
        }

        return score;
    }

}
