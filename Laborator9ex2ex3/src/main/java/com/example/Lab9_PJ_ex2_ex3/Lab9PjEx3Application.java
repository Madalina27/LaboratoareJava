package com.example.Lab9_PJ_ex2_ex3;

import com.example.Lab9_PJ_ex2_ex3.entity.Masina;
import com.example.Lab9_PJ_ex2_ex3.repository.MasinaSpringDataJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Lab9PjEx3Application implements CommandLineRunner {

	@Autowired
	MasinaSpringDataJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(Lab9PjEx3Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Lab9PjEx3Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Adaugare masina: "+ repository.save(new Masina("TM45TTT","Mercedes",2006,"portocaliu",44444)));

		logger.info("Adaugare masina -> {}", repository.save(new Masina("TM46TTT","Mercedes",2006,"portocaliu",44444)));

		System.out.println();

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Stergere masina: ");
		repository.deleteById("TM45TTT");

		System.out.println();

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Cautare dupa nr_inmatriculare: "+repository.findById("TM07ESY"));

		logger.info("Cautare dupa nr_inmatriculare -> {} ", repository.findById("TM07ESY"));

		System.out.println();

		System.out.println("Nr masini cu o anumita marca: "+ repository.countByMarca("Mercedes"));

		logger.info("Nr masini cu o anumita marca -> {} ", repository.countByMarca("Mercedes"));

		System.out.println();

		System.out.println("Nr masini sub 100000 km: "+repository.countByNr_kilometriIsLessThan100000());

		logger.info("Nr masini sub 100000 km -> {} ", repository.countByNr_kilometriIsLessThan100000());

		System.out.println();

		System.out.println("Masini mai noi de 5 ani: ");
		repository.noi_de_peste_5_ani(LocalDateTime.now().getYear()).forEach(System.out::println);

		logger.info("Masini mai noi de 5 ani -> {}",repository.noi_de_peste_5_ani(LocalDateTime.now().getYear()));

	}

}
