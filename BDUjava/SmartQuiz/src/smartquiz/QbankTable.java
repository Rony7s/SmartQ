//Rony Ahmmed BDu-EdTech
//for show question with option and option in a table this constroctir is very much need
package smartquiz;

public class QbankTable {
    private String question;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private String rightOption;
    
    public QbankTable( String Question, String Option_a, String Option_b, String Option_c, String Option_d, String RightOption){
    
        this.question = Question;
        this.option_a = Option_a;
        this.option_b = Option_b;
        this.option_c = Option_c;
        this.option_d = Option_d;
        this.rightOption = RightOption;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getOption_a(){
        return option_a;
    }
    
    public String getOption_b(){
        return option_b;
    }
    
    public String getOption_c(){
        return option_c;
    }
    
    public String getOption_d(){
        return option_d;
    }
    
    public String getRightOption(){
        return rightOption;
    }
    
}
