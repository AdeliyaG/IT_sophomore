import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        ServletContext sc = getServletContext();
        cfg.setServletContextForTemplateLoading(sc, "WEB-INF/templates/");

        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        int count = 5;
        Random random = new Random();

        Map root = new HashMap<>();
        root.put("head","The header");
        List items = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            items.add(random.nextInt(101));
        }
        root.put("items", items);

//
//        int sum = 0;
//        for (int i = 0; i < 5; i++) {
//
//        }
//        int avg = sum/count;

        Template t = cfg.getTemplate("test.ftlh");
        try {
            t.process(root, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
