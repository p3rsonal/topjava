package ru.javawebinar.topjava.web;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.repository.impl.LocalMemoryUserMealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

public class MealController extends HttpServlet {

    private UserMealRepository mealRepository;
    private static String INSERT_OR_EDIT = "/meal.jsp";
    private static String LIST_MEAL = "/meals.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mealRepository = new LocalMemoryUserMealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action == null) {
            forward = LIST_MEAL;
            request.setAttribute("userMeals", MealsUtil.getMealsWithExcess(mealRepository.getAll()));
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            mealRepository.delete(id);
            forward = LIST_MEAL;
            request.setAttribute("userMeals", MealsUtil.getMealsWithExcess(mealRepository.getAll()));
        } else {
            forward = INSERT_OR_EDIT;
            final UserMeal userMeal = action.equalsIgnoreCase("edit") ?
                mealRepository.get(Integer.parseInt(request.getParameter("id"))) :
                new UserMeal(LocalDateTime.now(), "", 1000);
            request.setAttribute("userMeal", userMeal);
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        UserMeal userMeal = new UserMeal(
            id.isEmpty() ? null : Integer.valueOf(id),
            LocalDateTime.parse(request.getParameter("dateTime")),
            request.getParameter("description"),
            Integer.parseInt(request.getParameter("calories")));
        mealRepository.save(userMeal);
        RequestDispatcher view = request.getRequestDispatcher(LIST_MEAL);
        request.setAttribute("userMeals", MealsUtil.getMealsWithExcess(mealRepository.getAll()));
        view.forward(request, response);
    }
}
