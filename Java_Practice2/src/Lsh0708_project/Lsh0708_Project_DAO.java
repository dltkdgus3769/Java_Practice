package Lsh0708_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Lsh0708_Project_DAO {

		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "scott";
		String passwd = "tiger";
		
		public Lsh0708_Project_DAO() {
			try {
				Class.forName(driver); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<Lsh0708_project_DTO> select() {
			ArrayList<Lsh0708_project_DTO> list = new ArrayList<Lsh0708_project_DTO>();

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String query = "SELECT id,name,department,birthdate,address,telNum,sex FROM employee";
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Lsh0708_project_DTO dto = new Lsh0708_project_DTO();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setDepartment(rs.getString("department"));
					dto.setBirthdate(rs.getString("birthdate"));
					dto.setAddress(rs.getString("address"));
					dto.setTelNum(rs.getString("telNum"));
					dto.setSex(rs.getString("sex"));
					System.out.println("DAO 결과: "+rs.getInt("id")+","+rs.getString("name")+","
							+rs.getString("department")+","+rs.getString("birthdate")+","+rs.getString("address")+","
							+rs.getString("telNum")+","+rs.getString("sex"));
					list.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}// select
		
		
		public ArrayList<Lsh0708_project_DTO> select(String dept){
			ArrayList<Lsh0708_project_DTO> list = new ArrayList<Lsh0708_project_DTO>();

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String query = "SELECT id,name,department,birthdate,address,telNum,sex FROM employee WHERE department=\'"+dept+"\'";
				System.out.println(query);
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Lsh0708_project_DTO dto = new Lsh0708_project_DTO();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setDepartment(rs.getString("department"));
					dto.setBirthdate(rs.getString("birthdate"));
					dto.setAddress(rs.getString("address"));
					dto.setTelNum(rs.getString("telNum"));
					dto.setSex(rs.getString("sex"));
					System.out.println("DAO 결과: "+rs.getInt("id")+","+rs.getString("name")+","
							+rs.getString("department")+","+rs.getString("birthdate")+","+rs.getString("address")+","
							+rs.getString("telNum")+","+rs.getString("sex"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;			
		};
		public ArrayList<Lsh0708_project_DTO> select(String dept, ArrayList<String> selectedItem){
			ArrayList<Lsh0708_project_DTO> list = new ArrayList<Lsh0708_project_DTO>();
			ArrayList<String> nullRemoveList = new ArrayList<String>();
			for(String item : selectedItem) {
				if(item != null) {
					nullRemoveList.add(item);
				}
			}
			StringBuilder stringBuilder = new StringBuilder();
	        for (int i = 0; i < nullRemoveList.size(); i++) {
	            stringBuilder.append(nullRemoveList.get(i));
	            // 마지막 요소가 아니면 ", " 추가
	            if (i < nullRemoveList.size() - 1) {
	                stringBuilder.append(", ");
	            }
	        }
	        //System.out.println("222222222222"+stringBuilder.toString());
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String query = "SELECT "+stringBuilder+ " FROM employee WHERE department=\'"+dept+"\'";
				System.out.println(query);
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Lsh0708_project_DTO dto = new Lsh0708_project_DTO();
					dto.setId(rs.getInt("id"));
//					dto.setName(rs.getString("name"));
					dto.setDepartment(rs.getString("department"));
					dto.setBirthdate(rs.getString("birthdate"));
					dto.setAddress(rs.getString("address"));
					dto.setTelNum(rs.getString("telNum"));
					dto.setSex(rs.getString("sex"));
//					System.out.println("DAO 결과: "+rs.getInt("id")+","+rs.getString("name")+","
//							+rs.getString("department")+","+rs.getString("birthdate")+","+rs.getString("address")+","
//							+rs.getString("telNum")+","+rs.getString("sex"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;			
		};
		
		public int insertDB(String name, String department, String birthdate, String address, String telNum, String sex) {
			Connection con = null;
			PreparedStatement pstmt = null;
			int result1 = 0;
			try {
				con = DriverManager.getConnection(url, userid, passwd);
				String sql = "INSERT INTO employee(id,name,department,birthdate,address,telNum,sex)" + "VALUES(id_seq.NEXTVAL,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, department);
				pstmt.setString(3, birthdate);
				pstmt.setString(4, address);
				pstmt.setString(5, telNum);
				pstmt.setString(6, sex);
				System.out.println(name+","+department+","+birthdate+","+address+","+telNum+","+sex);
				result1 = pstmt.executeUpdate();
				System.out.println(result1 + "개의 레코드가 저장");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}// finally
			return result1;
		} // insert 
		
}
