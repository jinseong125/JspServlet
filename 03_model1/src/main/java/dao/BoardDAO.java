package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.dto.BoardDTO;
import model.dto.UserDTO;

/*
 * DAO (Data Access Object)
 * 
 * 1. 데이터베이스와의 연결, 데이터 조회/삽입/수정/삭제(CRUD) 등 데이터 접근 작업을 수행하는 객체입니다.
 * 2. 비즈니스 로직과 데이터 베이스 로직을 분리하여 코드 구조화, 유지보수, 코드 재사용성 등을 얻을 수 있습니다.
 * 3. 인터페이스를 통해 DAO 객체를 생성하면 구현체를 자유롭게 변경할 수 있습니다.
 */

public class BoardDAO {

  //----- Singleton Pattern
  private BoardDAO() {}
  private static BoardDAO dao = new BoardDAO();
  public static BoardDAO getInstance() {
    return dao;
  }

  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  private String sql;

  //----- 조회 (목록)
  public List<BoardDTO> getBoards() {
    List<BoardDTO> boards = new ArrayList<>();
    try {
      con = DBUtils.getConnection();
      sql = "SELECT bid, uid, title, content, created_at, modified_at FROM tbl_board";
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        BoardDTO board = new BoardDTO();
        board.setBid(rs.getInt(1));
        UserDTO user = new UserDTO();
        user.setUid(rs.getInt(2));
        board.setUser(user);
        board.setTitle(rs.getString(3));
        board.setContent(rs.getString(4));
        board.setCreatedAt(rs.getTimestamp(5));
        board.setModifiedAt(rs.getTimestamp(6));
        boards.add(board);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return boards;
  }

  //----- 조회 (단일 항목)
  public BoardDTO getBoardById(int bid) {
    BoardDTO board = null;
    try {
      con = DBUtils.getConnection();
      sql = "SELECT bid, uid, title, content, created_at, modified_at FROM tbl_board WHERE bid = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, bid); // 쿼리문의 1번째 Placehorder에 bid 넣기
      rs = ps.executeQuery();
      if (rs.next()) {
        board = new BoardDTO();
        board.setBid(rs.getInt(1));
        UserDTO user = new UserDTO();
        user.setUid(rs.getInt(2));
        board.setUser(user);
        board.setTitle(rs.getString(3));
        board.setContent(rs.getString(4));
        board.setCreatedAt(rs.getTimestamp(5));
        board.setModifiedAt(rs.getTimestamp(6));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return board;
  }

  //----- 삽입 (삽입된 행의 개수 반환)
  public int insertBoard(BoardDTO board) {
    int count = 0;
    try {
      con = DBUtils.getConnection();
      sql = "INSERT INTO tbl_board(uid, title, content) VALUES(?, ?, ?)";
      ps = con.prepareStatement(sql);
      ps.setInt(1, board.getUser().getUid());
      ps.setString(2, board.getTitle());
      ps.setString(3, board.getContent());
      count = ps.executeUpdate(); // 반드시 실행!
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return count;
  }

  //----- 삭제 (삭제된 행의 개수 반환)
  public int deleteBoard(int bid) {
    int count = 0;
    try {
      con = DBUtils.getConnection();
      sql = "DELETE FROM tbl_board WHERE bid = ?";
      ps = con.prepareStatement(sql);
      ps.setInt(1, bid); 
      count = ps.executeUpdate(); 
    } catch (Exception e) {
      e.printStackTrace(); 
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return count;
  }

  //----- (선택) 수정 (수정된 행의 개수 반환)
  public int updateBoard(BoardDTO board) {
    int count = 0;
    try {
      con = DBUtils.getConnection();
      sql = "UPDATE tbl_board SET title = ?, content = ?, modified_at = CURRENT_TIMESTAMP WHERE bid = ?";
      ps = con.prepareStatement(sql);
      ps.setString(1, board.getTitle());
      ps.setString(2, board.getContent());
      ps.setInt(3, board.getBid());
      count = ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBUtils.close(con, ps, rs);
    }
    return count;
  }
}
