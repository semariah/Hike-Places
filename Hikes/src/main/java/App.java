

import dao.Sql2oHikeDao;
import models.Hike;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;


import static spark.Spark.staticFileLocation;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/hike.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHikeDao hikeDao = new Sql2oHikeDao(sql2o);
        //Sql2oUserDao userDao = new Sql2oUserDao(sql2o);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hike> hikes = hikeDao.getAll();
            model.put("hikes", hikes);
            //List<Member> members = memberDao.getAll();
            //model.put("members", members);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
