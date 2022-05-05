package ma.emsi.patientsmvc.entities;

import java.util.Date;

public class RendezVous {

    private Long id;
    private Date date;
    private boolean annule;
    private Patient patient;
    private Medecin medecin;
}
