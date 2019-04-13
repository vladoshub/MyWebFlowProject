package ru.mmtr.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.mmtr.vocabulary.Library;
import ru.mmtr.vocabulary.ListOfVocabulary;
import ru.mmtr.vocabulary.ServiceWorker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class JavaServlet extends HttpServlet {
    private String name;
    private Library library;
    private ListOfVocabulary vocabulary;
    private ServiceWorker serviceWorker;
    String nameVoc;
    List<String> list;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
        library = (Library) ac.getBean("Library");
        serviceWorker = (ServiceWorker) ac.getBean("ServiceWorker");
    }

    public void initVoc(HttpServletRequest req) throws ServletException {

        if("1".equals(req.getParameter("param"))) {
            vocabulary = ListOfVocabulary.Latins_Rus;
            nameVoc="rus-lat1.jsp";

        }
        else {
            vocabulary = ListOfVocabulary.Number;
            nameVoc="rus-lat1.jsp";
        }
       String s = req.getParameter("param");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initVoc(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(nameVoc);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        name = req.getParameter("req");
        switch (name) {
            case "1":
                serviceWorker.del(library);
                req.setAttribute("req0", "deleted is ok");
                break;
            case "2":
                list=serviceWorker.seacrh(library);
                if(list.size()>0)
                    req.setAttribute("req0", list);
                else
                    req.setAttribute("req", "List is null");
                break;
            case "3":
                serviceWorker.add(library, vocabulary);
                req.setAttribute("req0", "added is ok");
                break;
            case "4":
               list=serviceWorker.printAll(library);
               if(list.size()>0)
                   req.setAttribute("req0", list);
               else
                   req.setAttribute("req", "List is null");
                break;
            default:
                req.setAttribute("req", "error input");
                break;
        }
        list.clear();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(nameVoc);
        requestDispatcher.forward(req, resp);
    }

}
