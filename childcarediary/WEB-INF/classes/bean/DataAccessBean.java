package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class DataAccessBean {


	public Collection<DiaryInfo> findAllDiaryInfo() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			Collection<DiaryInfo> diaryList = new ArrayList<DiaryInfo>();

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nursery?characterEncoding=utf-8&serverTimezone=JST","root","root");
			ps = conn.prepareStatement("SELECT id, date, name, aim, contents FROM diary");
			rs = ps.executeQuery();

			while(rs.next()) {

				DiaryInfo diaryInfo = new DiaryInfo();

				diaryInfo.setId(rs.getString("id"));
				diaryInfo.setDate(rs.getString("date"));
				diaryInfo.setName(rs.getString("name"));
				diaryInfo.setAim(rs.getString("aim"));
				diaryInfo.setContents(rs.getString("contents"));

				diaryList.add(diaryInfo);

			}

			return diaryList;

		}

		catch (SQLException e) {

	        e.printStackTrace();
	        throw new SQLException(e);

		}

		finally {

			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();

			}

		}

    }


	public void registDiaryInfo(DiaryInfo diaryInfo) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nursery?characterEncoding=utf-8&serverTimezone=JST","root","root");
			ps = conn.prepareStatement("INSERT INTO diary(date, name, aim, contents)"
					+ " VALUES(?,?,?,?)");

			ps.setString(1, diaryInfo.getDate());
			ps.setString(2, diaryInfo.getName());
			ps.setString(3, diaryInfo.getAim());
			ps.setString(4, diaryInfo.getContents());

			ps.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
			throw new SQLException(e);

		}

		finally {

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}


	public void deleteDiaryInfo(String id) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nursery?characterEncoding=utf-8&serverTimezone=JST","root","root");
			ps = conn.prepareStatement("DELETE FROM diary WHERE id=?");

			ps.setString(1, id);

			ps.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
			throw new SQLException(e);

		}

		finally {

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}

		}

	}


	public void updateDiaryInfo(DiaryInfo diaryInfo) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nursery?characterEncoding=utf-8&serverTimezone=JST","root","root");
			ps = conn.prepareStatement("UPDATE diary SET date=?, name=?, aim=?, contents=? WHERE id=?");

			ps.setString(1, diaryInfo.getDate());
			ps.setString(2, diaryInfo.getName());
			ps.setString(3, diaryInfo.getAim());
			ps.setString(4, diaryInfo.getContents());
			ps.setString(5, diaryInfo.getId());

			ps.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
			throw new SQLException(e);

		}

		finally {

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}



}

