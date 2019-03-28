import java.util.ArrayList;

public class Student {
    private String name;
    private int quizScore;
    private int numOfQuiz;
    private ArrayList<Integer> quizList;

    public Student(String name){
        this.quizScore = 0;
        quizList = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQuizScore() {
        return quizScore;
    }

    public int avgScore(){
        return quizScore/quizList.size();
    }

    public void addQuiz(int score){
        quizList.add(score);
        quizScore+=score;
    }

    public int getNumOfQuiz(){
        return quizList.size();
    }
}
