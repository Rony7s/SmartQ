//Rony Ahmmed BDU-ICTE
import java.util.Scanner;
public class Quiz{
    public static void quiz(){
        Scanner sc = new Scanner(System.in);

//Question option and answer setting start
String[][] Q = {
{"Capital","Rajshahi","Dhaka","Chittagong","Khulna","2"},
{"Alphabet","R","one","Two","Three","1"},
{"Number","one","1","A","X","2"},
{"Name","xoxo","toto","Tapos","mango","3"}
};
            
        char ans[]= new char[10]; // ans user choice 
        float marks =0.0f; // total win marks
        float r = 1.0f, w = 0.25f; // r for per right answer and w for per wrong answer
        int n = 4; // how many questions have 
        //showing Question and option  and input user choice
        System.out.println("Right option(1-4) number Enter");
        for(int i=0; i<n; i++){   
            System.out.printf("Q(%2d): %s%n[1]%s%n[2]%s%n[3]%s%n[4]%s%n", i+1, Q[i][0], Q[i][1], Q[i][2], Q[i][3], Q[i][4]);

            ans[i] = sc.next().charAt(0); //take user choice
            char r_ans = Q[i][5].charAt(0); //r_ans right answer in a char from string

            if(ans[i]== r_ans){
                 marks +=r;
            }else{
                marks-=w;
            }           
        }
        System.out.println("Marks "+marks);
    

    for(int i=0; i<4;i++){
        System.out.printf("%c", ans[i]);
    }

    }
}
