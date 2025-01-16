package com.example.Lab9_PJ_ex2_ex3;

import com.example.Lab9_PJ_ex2_ex3.entity.Masina;
import com.example.Lab9_PJ_ex2_ex3.repository.MasinaJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab9PjEx2Application implements CommandLineRunner {

	@Autowired
	MasinaJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(Lab9PjEx2Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Lab9PjEx2Application.class, args);
	}

	public void run(String... args) throws Exception {

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Adaugare masina: "+ repository.insert(new Masina("TM45TTT","Mercedes",2006,"portocaliu",44444)));

		logger.info("Adaugare masina -> {}", repository.insert(new Masina("TM46TTT","Mercedes",2006,"portocaliu",44444)));

		System.out.println();

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Stergere masina: ");
		repository.deleteByNr_inmatriculare("TM45TTT");

		System.out.println();

		System.out.println("Toate masinile: ");
		repository.findAll().forEach(System.out::println);

		logger.info("Toate masinile -> {}", repository.findAll());

		System.out.println();

		System.out.println("Cautare dupa nr_inmatriculare: "+repository.findByNr_inmatriculare("TM07ESY"));

		logger.info("Cautare dupa nr_inmatriculare -> {} ", repository.findByNr_inmatriculare("TM07ESY"));

		System.out.println();

		System.out.println("Nr masini cu o anumita marca: "+ repository.nr_masini_marca("Mercedes").size());

		logger.info("Nr masini cu o anumita marca -> {} ", repository.nr_masini_marca("Mercedes").size());

		System.out.println();

		System.out.println("Nr masini sub 100000 km: "+repository.sub_100_000km().size());

		logger.info("Nr masini sub 100000 km -> {} ", repository.sub_100_000km().size());

		System.out.println();

		System.out.println("Masini mai noi de 5 ani: ");
		repository.noi_de_peste_5_ani().forEach(System.out::println);

		logger.info("Masini mai noi de 5 ani -> {}",repository.noi_de_peste_5_ani());

	}

}
