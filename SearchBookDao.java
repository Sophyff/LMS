import java.sql.*;


import javax.swing.table.DefaultTableModel;

public class SearchBookDao {
	
	
	public static ResultSet SearchBookAll(String SearchText) throws SQLException {

	    try {
	    	Connection con=DB.getConnection();
	    	PreparedStatement ps=con.prepareStatement("SELECT BOOKS.Isbn,Title,AUTHORS.Author_id,Name FROM BOOKS JOIN BOOK_AUTHORS ON BOOKS.Isbn=BOOK_AUTHORS.Isbn "
					+ "JOIN AUTHORS ON AUTHORS.Author_id=BOOK_AUTHORS.Author_id Limit 3" + 
					"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
//			ps.setString(1,SearchText);
//			ps.setString(2,SearchText);
//			ps.setString(3,SearchText);
			
			ResultSet rs=ps.executeQuery();
	        return rs;
		}catch(Exception e){
			System.out.println(e);
		    return null;
		}
	       

	}
	
	public static DefaultTableModel createTable(ResultSet rs) throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();
	    int columnCount = metaData.getColumnCount();

	    //ColumnsNames
	    String data[][]=null;
		String column[]=null;
	    ResultSetMetaData rsmd=rs.getMetaData();
		int cols=rsmd.getColumnCount();
		column=new String[cols];
		for(int i=1;i<=cols;i++){
			column[i-1]=rsmd.getColumnName(i);
		}
		
		rs.last();
		int rows=rs.getRow();
		rs.beforeFirst();

		data=new String[rows][cols];
		int count=0;
		while(rs.next()){
			for(int i=1;i<=cols;i++){
				data[count][i-1]=rs.getString(i);
			}
			count++;
		}

	    return new DefaultTableModel(data, column);
	}
	
	

}
