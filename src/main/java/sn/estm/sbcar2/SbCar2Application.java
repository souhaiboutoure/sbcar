package sn.estm.sbcar2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.estm.sbcar2.domain.Car;
import sn.estm.sbcar2.domain.Owner;
import sn.estm.sbcar2.repository.CarRepository;
import sn.estm.sbcar2.repository.OwnerRepository;

@SpringBootApplication
public class SbCar2Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(SbCar2Application.class);
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;
	public static void main(String[] args) {
		SpringApplication.run(SbCar2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<Owner> setOwner1 = new HashSet<>();
		Owner owner1 = new Owner("John", "Johnson");
		Set<Owner> setOwner2 = new HashSet<>();
		Owner owner2 = new Owner("Mary", "Robinson");
		setOwner1.add(owner1);
		setOwner2.add(owner2);
		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, setOwner1);
		Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, setOwner2);
		Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, setOwner2);
		Set<Car> setCar1 = new HashSet<>();
		setCar1.add(car1);
		Set<Car> setCar2 = new HashSet<>();
		setCar2.add(car2);
		setCar2.add(car3);
		owner1.setCars(setCar1);
		owner2.setCars(setCar2);
		ownerRepository.saveAll(setOwner1);
		ownerRepository.saveAll(setOwner2);
		carRepository.saveAll(setCar1);
		carRepository.saveAll(setCar2);
		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}
}
