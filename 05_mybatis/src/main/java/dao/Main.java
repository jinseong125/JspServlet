package dao;

import java.util.Map;

import model.dto.BoardDTO;

public class Main {

  public static void main(String[] args) {

    BoardDao dao = BoardDao.getInstance();


    Map<String, Object> map = Map.of("target", "content", "query", "입니다"); for
    (BoardDTO foundBoard : dao.findBoardsUsingQuery(map)) { System.out.println(foundBoard);
    } System.out.println();

    int bid = 1; System.out.println(dao.getBoardById(bid)); System.out.println();

    System.out.println(dao.getBoardCount()); System.out.println();

    String sort = "DESC"; 
    for (BoardDTO board : dao.getBoards(sort)) {
      System.out.println(board); }

    System.out.println();

    /*
     * Map<String, Object> map2 = Map.of("beginDate", "2025-07-23", "endDate",
     * "2025-07-24"); for (BoardDTO foundBoard : dao.findBoardsUsingDate(map2)) {
     * System.out.println(foundBoard); } System.out.println();
     */
    
    /*Map<String, Object> map2 = Map.of(
        "target","title",
        "query", "상어",
        "beginDate","2025-07-23", 
        "endDate", "2025-07-24");
    for (BoardDTO foundBoard : dao.findBoardsUsingDate(map2)) {
      System.out.println(foundBoard);
    }
    System.out.println(); */
      
    Map<String, Object> map2 = Map.of(
        "target","",
        "query", "나는",
        "beginDate","2025-07-23", 
        "endDate", "2025-07-24");
    for (BoardDTO foundBoard : dao.findBoards2(map2)) {
      System.out.println(foundBoard);
    }
  }

}