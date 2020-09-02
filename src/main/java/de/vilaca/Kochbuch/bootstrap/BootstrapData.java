package de.vilaca.Kochbuch.bootstrap;

import de.vilaca.Kochbuch.domain.Unit;
import de.vilaca.Kochbuch.repositories.UnitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UnitRepository unitRepository;

    public BootstrapData(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Anfang von run");
        Unit unitGramm = new Unit("Gramm");
        Unit unitLiter = new Unit("Liter");

        if (!unitRepository.getByName(unitGramm.getName()).iterator().hasNext()) {
            unitRepository.save(unitGramm);
        }
        if (!unitRepository.getByName(unitLiter.getName()).iterator().hasNext()) {
            unitRepository.save(unitLiter);
        }
        System.out.println("unit gespeichert");
        System.out.println("Number of units: " + unitRepository.count());
        Iterable<Unit> units = unitRepository.findAll();
        for (Unit u: units) {
            System.out.println("Unit: " + u.getId() + "\t\tName: " + u.getName());
        }
    }
}
