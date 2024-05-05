package com.example.springboot.error.Spring.Error.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        LOGGER.info("LoadingTimeInterceptor: preHandle() ...going in " + controller.getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        //------se simula una demora-----//
        Random random = new Random();
        int delay = random.nextInt(500);//nos da un número aleatorio entre 0 y 500
        Thread.sleep(delay);
        //------------------------------//


        //---Case false personal----//
//        Map<String, String> json = new HashMap<>();
//        json.put("error", "no tiene acceso a esta página");
//        json.put("date", new Date().toString());
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(json);
//        response.setContentType("application/json");
//        response.setStatus(401);
//        response.getWriter().write(jsonString);
//        return false;
        //---------------------------//
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        LOGGER.info("Time: "+result+" millisecond");
        LOGGER.info("LoadingTimeInterceptor: preHandle() ...coming out " + ((HandlerMethod) handler).getMethod().getName());
    }

}
