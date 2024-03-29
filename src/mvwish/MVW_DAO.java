package mvwish;

import java.sql.SQLException;
import java.util.ArrayList;

public class MVW_DAO extends DBconn {
	MVW_VO vo = null;

	// 회원 아이디로 검색(중복처리)
	public MVW_VO getMidSearch(String mid) {
		vo = new MVW_VO();
		try {
			sql = "SELECT * FROM MVWuser WHERE mid=?";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setMid(rs.getString("mid"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 회원 등록
	public int setMVWJoin(MVW_VO vo) {
		int res = 0;
		try {
			sql = "INSERT INTO MVWuser VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getAge());
			pstmt.setString(5, vo.getGender());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<MVW_VO> movieInput() {
		ArrayList<MVW_VO> vos = new ArrayList<MVW_VO>();
		try {
			sql = "SELECT * FROM mvwmovie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MVW_VO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMovieName(rs.getString("moviename"));
				vo.setRunningTime(rs.getString("runningtime"));
				vo.setGenre(rs.getString("genre"));
				vo.setScore(rs.getDouble("score"));
				vo.setImg(rs.getString("img"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
}
