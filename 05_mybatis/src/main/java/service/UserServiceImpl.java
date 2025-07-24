package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import common.ActionForward;
import dao.UserDao;
import model.dto.UserDTO;

public class UserServiceImpl implements UserService {

  private UserDao userDao = UserDao.getInstance();

  @Override
  public ActionForward login(HttpServletRequest request) {
    // email, password 받기
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // UserDTO 생성
    UserDTO user = new UserDTO();
    user.setEmail(email);
    user.setPassword(password);

    // 사용자 조회
    UserDTO foundUser = userDao.getUser(user);

    // 로그인 처리
    String view;
    boolean isRedirect = false;
    if (foundUser != null) {
      // 로그인 성공
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", foundUser);
      view = request.getContextPath() + "/main";
      isRedirect = true;
    } else {
      // 로그인 실패
      request.setAttribute("error", "아이디나 비밀번호를 확인하세요.");
      view = "/view/user/login.jsp";
    }

    return new ActionForward(view, isRedirect);
  }

  @Override
  public ActionForward logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false); // 기존 세션만
    if (session != null) {
      session.removeAttribute("loginUser");
      // 또는 session.invalidate(); // 필요에 따라 세션 전체 파기
    }
    String view = request.getContextPath() + "/main";
    boolean isRedirect = true;
    return new ActionForward(view, isRedirect);
  }
}
