package com.cy.interceptor;

import com.cy.consts.MallConst;
import com.cy.exception.UserLonginException;
import com.cy.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Create by 猪小帅
 * @date 2022/3/23 20:40
 * @mood happy
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    /**
     * true 表示继续流程， false 表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            log.info("user=null");
            throw new UserLonginException();
//            response.getWriter().println("error");
//            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }
}
