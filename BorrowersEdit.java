
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BorrowersEdit {
	
	public static boolean validate(String Ssn){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from BORROWERS where Ssn=?");
	
			ps.setString(1,Ssn);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int save(String Ssn,String Fname,String Lname,String Address,String city,String State,String Phone){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into BORROWERS(Ssn,Fname,Lname,Address,City,State,Phone) values(?,?,?,?,?,?,?)");
			ps.setString(1,Ssn);
			ps.setString(2,Fname);
			ps.setString(3, Lname);
			ps.setString(4,Address);
			ps.setString(5,city);
			ps.setString(6, State);		
			ps.setString(7,Phone);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from BORROWERS where Card_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}



}
