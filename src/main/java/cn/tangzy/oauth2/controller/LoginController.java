package cn.tangzy.oauth2.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        Object username = request.getParameter("username");
        Object password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().getAuthentication();
        String uri = "";
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute("USER", authentication.getPrincipal());
        } else {
            String from = (String) request.getAttribute("username");
            uri = "/static/login.html";
        }
        String from = (String) request.getAttribute("from");
        if (StringUtils.isNotBlank(from)) {
            uri = uri + "/" + from;
        } else {
            if (StringUtils.isBlank(uri)) {
                uri = "/";
            }
        }
        return "redirect:" + uri;
    }

}
