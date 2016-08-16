package manka.igor.sonder;

/**
 * Created by Igor on 10.08.2016.
 */
public class Data {
    private String answer;
    public static String question = "Question";
    public static final Data[] answers = {
            new Data("Odpowiedz1"),
            new Data("Odpowiedz2"),
            new Data("Odpowiedz3")
    };
    public Data(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return this.answer;
    }
    public String toString(){
        return this.answer;
    }
    public String getQuestion(){
        return this.question;
    }
}
