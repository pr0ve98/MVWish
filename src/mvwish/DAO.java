package mvwish;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DAO extends DBconn {
	VO vo = null;

	// 회원 아이디로 검색(중복처리)
	public VO getMidSearch(String mid) {
		vo = new VO();
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
	public int setMVWJoin(VO vo) {
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

	// 전체 영화리스트
	public ArrayList<VO> movieView() {
		ArrayList<VO> vos = new ArrayList<VO>();
		try {
			sql = "SELECT * FROM mvwmovie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VO();
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

	// 전체 영화 리스트 JTable
	public Vector getMovieList() {
		Vector vData = new Vector<>();
		try {
			sql = "SELECT * FROM MVWmovie ORDER BY idx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("moviename"));
				vo.add(rs.getString("runningtime"));
				vo.add(rs.getString("genre"));
				vo.add(rs.getDouble("score"));
				vo.add(rs.getString("img"));
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
	public VO movieSearch(int idx) {
		vo = new VO();
		try {
			sql = "SELECT * FROM MVWmovie WHERE idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMovieName(rs.getString("moviename"));
				vo.setRunningTime(rs.getString("runningtime"));
				vo.setGenre(rs.getString("genre"));
				vo.setScore(rs.getDouble("score"));
				vo.setImg(rs.getString("img"));
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 영화 추가하기
	public int setMovieAdd(VO vo) {
		int res = 0;
		try {
			sql = "INSERT INTO MVWmovie VALUES (DEFAULT,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovieName());
			pstmt.setString(2, vo.getRunningTime());
			pstmt.setString(3, vo.getGenre());
			pstmt.setDouble(4, vo.getScore());
			pstmt.setString(5, vo.getImg());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 영화 삭제
	public int movieDelete(VO vo) {
		int res = 0;
		try {
			sql = "DELETE FROM MVWmovie WHERE idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getIdx());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int movieEdit(VO vo) {
		int res = 0;
		try {
			sql = "UPDATE MVWmovie SET moviename=?, runningtime=?, genre=?, score=?, img=? WHERE idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMovieName());
			pstmt.setString(2, vo.getRunningTime());
			pstmt.setString(3, vo.getGenre());
			pstmt.setDouble(4, vo.getScore());
			pstmt.setString(5, vo.getImg());
			pstmt.setInt(6, vo.getIdx());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public int userWishMovie(String mid, int movieIdx) {
		int res = 0;
		try {
			sql = "INSERT INTO MVWuserlike VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, movieIdx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public ArrayList<VO> movieWishView(String mid) {
		ArrayList<VO> vos = new ArrayList<VO>();
		try {
			sql = "SELECT * FROM MVWuserlike WHERE mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VO();
				vo.setWishIdx(rs.getInt("idx"));
				vo.setWishMid(rs.getString("mid"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	public int userWishMovieDelete(String mid, int movieIdx) {
		int res = 0;
		try {
			sql = "DELETE FROM MVWuserlike WHERE mid=? AND idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, movieIdx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public VO getWish(String mid, int movieIdx) {
		vo = new VO();
		try {
			sql = "SELECT * FROM MVWuserlike WHERE mid=? AND idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, movieIdx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setWishMid(rs.getString("mid"));
				vo.setWishIdx(rs.getInt("idx"));
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public ArrayList<VO> txtSearch(String txt) {
		ArrayList<VO> vos = new ArrayList<VO>();
		try {
			sql = "SELECT * FROM MVWmovie WHERE moviename LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txt+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VO();
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

	public ArrayList<VO> genreSearch(String genre) {
		ArrayList<VO> vos = new ArrayList<VO>();
		try {
			sql = "SELECT * FROM MVWmovie WHERE genre LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+genre+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new VO();
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
