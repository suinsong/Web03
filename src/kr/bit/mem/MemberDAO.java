package kr.bit.mem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO { // JDBC

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public Connection getConnect() {
		String url = "jdbc:mysql://127.0.0.1:3306/mysql";
		String user = "root";
		String password = "!BitCom0228";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public int memInsert(MemberVO vo) {

		String sql = " insert into member(irum, age, email, intro) values(?,?,?,?) ";
		conn = getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getIrum());
			ps.setInt(2, vo.getAge());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getIntro());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	public int memUpdate(MemberVO vo) {

		String sql = " update member set age=?, email=?, intro=? where num=? ";
		conn = getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getIntro());
			ps.setInt(4, vo.getNum());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	public int memDel(int a) {

		String sql = " delete from member where num=? ";
		conn = getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a);
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	public MemberVO memView(int num) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member where num=?";
		conn = getConnect();
		MemberVO vo = null;
		try {

			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				num = rs.getInt("num");
				String irum = rs.getString("irum");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String intro = rs.getString("intro");

				vo = new MemberVO();
				vo.setNum(num);
				vo.setIrum(irum);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setIntro(intro);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public List<MemberVO> memList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member ";
		conn = getConnect();

		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String irum = rs.getString("irum");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String intro = rs.getString("intro");
				// ¹­°í(vo)--->´ã°í(list)

				MemberVO vo = new MemberVO();
				vo.setNum(num);
				vo.setIrum(irum);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setIntro(intro);
				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
