package ma.emsi.patientsmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RendezVousController {
    @GetMapping("/rendezvous")
    public String rendezvous(){return "rendezvous";}
}
