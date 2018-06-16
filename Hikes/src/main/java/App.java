

import dao.Sql2oHikeDao;
import dao.Sql2oVisitorDao;
import models.Hike;
import models.Visitor;
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
        Sql2oVisitorDao visitorDao = new Sql2oVisitorDao(sql2o);


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hike> hikes = hikeDao.getAll();
            model.put("hikes", hikes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hikes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newhike-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hikes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int hikeLength = Integer.parseInt(req.queryParams("hikeLength"));
            String state = req.queryParams("state");
            Hike newHike = new Hike(name, hikeLength, state);
            hikeDao.add(newHike);
            model.put("hike", newHike);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());



        get("/hikes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHikeToEdit = Integer.parseInt(req.params("id"));
            Hike editHike = hikeDao.findById(idOfHikeToEdit);
            model.put("editHike", editHike);
            return new ModelAndView(model, "newhike-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/hikes/:id/update", (req, res) -> {
            int idOfHikeToEdit = Integer.parseInt(req.params("id"));
            String name = req.queryParams("name");
            int hikeLength = Integer.parseInt(req.queryParams("hikeLength"));
            String state = req.queryParams("state");
            hikeDao.update(idOfHikeToEdit, name, hikeLength, state);
            res.redirect("/hikes/" + idOfHikeToEdit);
            halt();
            return null;
        }, new HandlebarsTemplateEngine());


        get("/hikes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            hikeDao.clearAllHikes();
            res.redirect("/");
            halt();
            return null;
        }, new HandlebarsTemplateEngine());

        get("/hikes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHikeToDelete = Integer.parseInt(req.params("id"));
            hikeDao.deleteById(idOfHikeToDelete);
            res.redirect("/");
            halt();
            return null;
        }, new HandlebarsTemplateEngine());


        get("/visitors/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Visitor> users = visitorDao.getAll();
            model.put("users", users);
            return new ModelAndView(model, "visitor-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/visitors/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            //List<Visitor> allVisitors = visitorDao.getAll();
            //model.put("visitors", allVisitors);
            String name = request.queryParams("name");
            Visitor newVisitor = new Visitor(name);
            visitorDao.add(newVisitor);
            model.put("visitor", newVisitor);
            return new ModelAndView(model, "success-visitor.hbs");
        }, new HandlebarsTemplateEngine());


        get("/visitors/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfVisitorToEdit = Integer.parseInt(req.params("id"));
            Visitor editVisitor = visitorDao.findById(idOfVisitorToEdit);
            model.put("editVisitor", editVisitor);
            return new ModelAndView(model, "visitor-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/visitors/:id/update", (req, res) -> {
            int idOfVisitorToEdit = Integer.parseInt(req.params("id"));
            String name = req.queryParams("name");
            visitorDao.update(idOfVisitorToEdit, name);
            res.redirect("/visitors/" + idOfVisitorToEdit);
            halt();
            return null;
        }, new HandlebarsTemplateEngine());


        get("/visitors/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            visitorDao.clearAllVisitors();
            res.redirect("/");
            halt();
            return null;
        }, new HandlebarsTemplateEngine());

        get("/visitors/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfVisitorToDelete = Integer.parseInt(req.params("id"));
            visitorDao.deleteById(idOfVisitorToDelete);
            res.redirect("/");
            halt();
            return null;
        }, new HandlebarsTemplateEngine());


        get("/visitors/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfVisitorToFind = Integer.parseInt(req.params("id"));
            Visitor foundVisitor = visitorDao.findById(idOfVisitorToFind);
            model.put("visitor", foundVisitor);
            return new ModelAndView(model, "visitor-detail.hbs");
        }, new HandlebarsTemplateEngine());


        get("/hikes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHikeToFind = Integer.parseInt(req.params("id"));
            Hike foundHike = hikeDao.findById(idOfHikeToFind);
            model.put("hike", foundHike);
            return new ModelAndView(model, "hike-detail.hbs");
        }, new HandlebarsTemplateEngine());





    }

}
