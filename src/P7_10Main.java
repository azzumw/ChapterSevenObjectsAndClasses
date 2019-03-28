public class P7_10Main {
    public static void main(String [] args){
        Student student = new Student("Azzum");
        student.addQuiz(2);
        student.addQuiz(4);
        student.addQuiz(6);

        System.out.println("Quiz score: "+ student.getQuizScore());
        System.out.println("Avg: "+ student.avgScore());
        System.out.println("Number of Quizes: "+ student.getNumOfQuiz());

    }
}
