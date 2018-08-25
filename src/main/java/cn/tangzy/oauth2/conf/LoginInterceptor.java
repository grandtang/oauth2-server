package cn.tangzy.oauth2.conf;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER");
        if (user == null) {
            StringBuffer requestURL = request.getRequestURL();
            String redirectUrl = "/static/login.html";
            if (requestURL != null) {
                redirectUrl += "?from=" + URLEncoder.encode(requestURL.toString(), "UTF-8");
            }
            response.sendRedirect(redirectUrl);
            return false;
        }
        return true;
    }


}
