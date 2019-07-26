package DBConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import DAOClasses.AnswerDAO;
import DAOClasses.QuestionDAO;
import EntityClassesPackage.Answers;
import EntityClassesPackage.Questions;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		QuestionDAO dao=new QuestionDAO();
//		HashMap<Integer,Questions> qmap=dao.getAllQuestions();
//		for(Entry<Integer, Questions> e:qmap.entrySet())
//        {
//        	
//        	System.out.println("<h3>"+e.getValue().getQuesDesc()+"<br/><br/></h3><h4>"+e.getValue().getEmployee().getEmp_name()+"          "
//        			+e.getValue().getEmployee().getEmp_Designation()+"     "+e.getValue().getDate()+"<br/><br/></h4>");
//	}
		AnswerDAO a=new AnswerDAO();
		ArrayList<Answers> list=a.getAnswers(2);
		
		if(list==null)
		{
			System.out.println("no answers");
		}
		else
		{
		for(Answers l:list)
		{
			System.out.println(l);
		}}

}
}
