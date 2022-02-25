import java.sql.*;
import java.util.Date;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class LoanBookDao {
	
public static boolean checkBorrowerNum(int cardid){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select count(*) AS quantity from BOOK_LOANS where Card_id=?");
		ps.setInt(1,cardid);
	    ResultSet rs=ps.executeQuery();
	    if(rs.next()){
			int count=rs.getInt("quantity");
			if (count<3) status=true;
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String Isbn,int cardid){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(Isbn);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into BOOK_LOANS(Isbn,card_id,Date_out,Due_date) values(?,?,?,?)");
		ps.setString(1,Isbn);
		ps.setInt(2,cardid);
		 
		Date today=new Date();
		Date due = new Date(today.getTime() + (1000 * 60 * 60 * 24*14));
		String date=today.toString();
		String duedate=due.toString();
		
		ps.setString(3,date);
		ps.setString(4,duedate);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String bookisbn){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps2=con.prepareStatement("update BOOKS set Valid=false WHERE Isbn=?;");
		
		ps2.setString(1,bookisbn);	
		status=ps2.executeUpdate();
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
