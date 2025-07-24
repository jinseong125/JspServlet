package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*")

public class CharacterEncodingFilter extends HttpFilter implements Filter {

  private String encoding;

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    response.setContentType("text/html; charset=" + encoding);
    chain.doFilter(request, response);
  }
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
    //----- web.xml의 <filter>태그를 이용해서 encoding값을 전달할 수 있습니다.
    encoding = fConfig.getInitParameter("encoding");
    System.out.println("=====CharacterEncodingFilter : " + encoding);
    if (encoding == null)
      encoding = "UTF-8";
  }

}
