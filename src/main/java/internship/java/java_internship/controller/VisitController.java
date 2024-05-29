package internship.java.java_internship.controller;


import internship.java.java_internship.model.Visit;
import internship.java.java_internship.model.VisitRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class VisitController {


    private final VisitRepository visitRepository;

    public VisitController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    LocalTime startTime = LocalTime.parse("08:00:00");
    LocalTime endTime = LocalTime.parse("16:00:00");


    @GetMapping("/visits")
    public List<Visit> all() {
        return visitRepository.findAll();
    }


    @GetMapping("/visits/{id}")
    public Visit one(@PathVariable Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @PostMapping()
    public Visit addVisit(@RequestBody Visit newVisit) {
        List<Visit> visits = visitRepository.findAll();
        for (Visit visit : visits) {
            if (visit.getDateVisit().equals(newVisit.getDateVisit())) {
                return null;
            }
        }
        if(!newVisit.getDateVisit().toLocalTime().isBefore(startTime) &&
                !newVisit.getDateVisit().toLocalTime().isAfter(endTime)) {
            return null;
        }
        return visitRepository.save(newVisit);
    }

    @PutMapping
    public Visit editVisit(@RequestBody Visit newVisit, @PathVariable Long id) {
        return visitRepository.findById(id)
                .map(visit -> {
                    visit.setDateVisit(newVisit.getDateVisit());
                    visit.setOwner(newVisit.getOwner());
                    visit.setCatName(newVisit.getCatName());
                    visit.setCatAge(newVisit.getCatAge());
                    visit.setCatColor(newVisit.getCatColor());
                    return visitRepository.save(visit);
                })
                .orElseGet(() -> {
                    newVisit.setId(id);
                    return visitRepository.save(newVisit);
                });
    }

    @DeleteMapping("/visits")
    public void deleteVisit(@RequestBody Visit visit) {
        visitRepository.delete(visit);
    }
}
