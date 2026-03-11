package DatabaseProject;


import java.sql.*;
public class CombineDatabase {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/combine_military", "root", "DerNachtZug*87");
			
			System.out.println("Connection Found");
			
//			String query = "select * from combine_military.combine_units";
			String query = "select Unit_ID, Unit_Title, Unit_Rank, Unit_Max_Squad_Quantity, Sector_name from combine_units JOIN sector on Sector_ID=Unit_ID";
			Statement stm = connect.createStatement();
			ResultSet result = stm.executeQuery(query);
			
			ResultSetMetaData resultMeta = result.getMetaData();
			
			//MySQL indices start at 1...retarded, I know
			for(int i = 0; i < resultMeta.getColumnCount(); i++) {
				System.out.print(resultMeta.getColumnName(i+1) + "\t");
			}
			
			while(result.next()) {
//				System.out.print("\n" + result.getInt("Unit_ID") + "\t" + result.getString("Unit_Title") + 
//						(result.getString("Unit_Title").length()<=7?"\t\t" : "\t") + result.getInt("Unit_Rank") + "\t\t" + result.getInt("Unit_Max_Squad_Quantity") +
//						"\t\t\t" + result.getBoolean("Unit_Common"));
				System.out.print("\n" + result.getInt("Unit_ID") + "\t" + result.getString("Unit_Title") + 
						(result.getString("Unit_Title").length()<=7?"\t\t" : "\t") + result.getInt("Unit_Rank") + "\t\t" + result.getInt("Unit_Max_Squad_Quantity") +
						"\t\t\t" + result.getString("Sector_name"));
			}
			
		}catch(Exception ex) {
			System.out.println("Connection not found");
			ex.printStackTrace();
		}
		

	}

}
