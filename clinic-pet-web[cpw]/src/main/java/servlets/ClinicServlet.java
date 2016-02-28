package servlets;

import pets.Animal;
import pets.Dog;
import pets.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Alekcandr on 2/27/2016.
 */
public class ClinicServlet extends HttpServlet {
    final List<Pet> pets = new CopyOnWriteArrayList<Pet>();
    private String nameForFind;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(


                "<!DOCTYPE html" +
                "html" +
                "head" +
                "   <title style='margin-bottom: 15px'><h2> Clinic Pets </h2></title>" +
                "</head>" +
                        "<body>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Name : <input type='text' name='name'>"+
                        "         Owner : <input type='text' name='owner'>"+
                        "         Age : <input type='text' name='age'>"+
                        "         <input type='submit' value='add new Pet'>"+
                        "     <form>"+
                        this.viewPets() +
                        "<br>" +
                        "<br>" +
                        "     <form action='"+req.getContextPath()+"/' method='post'>" +
                        "         Name : <input type='text' name='find'>"+
                        "         <input type='submit' value='findByPetName'>"+
                        "     <form>"+
                        this.findPets(nameForFind) +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("name").isEmpty() && !req.getParameter("age").isEmpty() && !req.getParameter("owner").isEmpty())
            this.pets.add(new Dog(new Animal(req.getParameter("name"), req.getParameter("owner"), req.getParameter("age"))));
        if (!req.getParameter("find").isEmpty())
            this.nameForFind = req.getParameter("find");
        doGet(req, resp);
    }

    private String viewPets(){
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>Pets</h3>");
        sb.append("<table style='border : 1px solid black'>");
        for(Pet pets: this.pets){
            sb.append("<tr><td style='border : 1px solid black'>").append(pets.toString()).append("</td></tr>");

        }
        sb.append("</table>");
        return sb.toString();
    }

    private String findPets(String nameOfPet) {
        StringBuilder sb = new StringBuilder();
        boolean founded = false;
        if (!pets.isEmpty() && nameOfPet != null) {
            sb.append("<p>Pets found:</p>");
            sb.append("<table style='border : 1px solid black'>");
            for (Pet pet : this.pets) {

                if (nameOfPet.equals(pet.getName())) {
                    sb.append("<tr><td style='border : 1px solid black'>").append(pet.toString()).append("</td></tr>");
                    founded = true;
                }
            }
            sb.append("</table>");
        }
        if(!founded){
            sb.delete(0,sb.capacity());
            sb.append("<p>Not found</p>");
        }

        return sb.toString();
    }

}
