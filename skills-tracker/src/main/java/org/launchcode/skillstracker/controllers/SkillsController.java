package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping

public class SkillsController {


//    the @ResponseBody means you don't need the <html><body> tags
    @GetMapping("/")
    @ResponseBody
    public String skillsList() {
        String html = "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
        return html;
    }


//    "<form method='post'>" instead of <form action='skills'>

    @GetMapping("/form")
    @ResponseBody
    public String skillsForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'skills'>" +
                "<label>Name: </label>"+
                "<input type='text' name='name'>" +
                "<br></br>" +

                "<label for='language'>My favorite language:</label>"+
                "<br></br>" +
                "<select name='firstLanguageSelect'>" +
                "<option value='Java'> Java </option>"+
                "<option value='JavaScript'> JavaScript </option>"+
                "<option value='Python'> Python </option>"+
                "</select>"+
                "<br></br>" +

                "<p>My second favorite language:</p>"+
                "<select name='secondLanguageSelect'>" +
                "<option value='Java'> Java </option>"+
                "<option value='JavaScript'> JavaScript </option>"+
                "<option value='Python'> Python </option>"+
                "</select>"+
                "<br></br>" +

                "<p>My third favorite language:</p>"+
                "<select name='thirdLanguageSelect'>" +
                "<option value='Java'> Java </option>"+
                "<option value='JavaScript'> JavaScript </option>"+
                "<option value='Python'> Python </option>"+
                "</select>"+
                "<br></br>" +

                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


    @RequestMapping(value = "skills", method = {RequestMethod.GET, RequestMethod.POST})
//    @PostMapping("/form")
    @ResponseBody
    public String compileNameAndLanguages(@RequestParam String name,
                                          @RequestParam String firstLanguageSelect,
                                          @RequestParam String secondLanguageSelect,
                                          @RequestParam String thirdLanguageSelect) {
        String response =
//                "<html>" +
//                "<body>" +
//                "<p style='color:#0394fc'><font size='+15'>Name: " + name + "</font></p>" +
//                "<ol>" +
//                "<font size='+5'><li>" + firstLanguageSelect + "</li>" +
//                "<li>" + secondLanguageSelect + "</li>" +
//                "<li>" + thirdLanguageSelect + "</li></font>" +
//                "</ol>" +
//                "</body>" +
//                "</html>";

                        "<html>" +
                        "<body>" +
                                "<h1>Name: " + name + "</h1>" +
                                "<table> " +
                                "<tr></tr>" +
                                "<td>First Preference</td>" +
                                "<td>" + firstLanguageSelect + "</td>" +
                                "<tr></tr>"+
                                "<td>Second Preference</td>" +
                                "<td>" + secondLanguageSelect + "</td>" +
                                "<tr></tr>"+
                                "<td>Third Preference</td>" +
                                "<td>" + thirdLanguageSelect + "</td>" +
                                "<tr></tr>"+
                                "</table>"+
                        "</body>" +
                        "</html>";

        return response;
    }
}
