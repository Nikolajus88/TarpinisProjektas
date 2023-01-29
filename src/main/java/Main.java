import entity.Company;
import entity.RepairingWorkshop;
import entity.TruckDriver;
import entity.Vehicle;
import repository.CompanyRepository;
import repository.DriverRepository;
import repository.RepairWorkshopRepository;
import repository.VehiclesRepository;
import service.CompanyService;
import utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Company nikVit = new Company();
        nikVit.setName("UAB NIK&VIT");
        nikVit.setCountry("Lithuania");
        nikVit.setBudget(1000000);

        TruckDriver antanasAntanaitis = new TruckDriver();
        antanasAntanaitis.setFistName("Antanas");
        antanasAntanaitis.setLastName("Antanaitis");
        antanasAntanaitis.setSalary(2300.00);

        TruckDriver jonasJonaitis = new TruckDriver();
        jonasJonaitis.setFistName("Jonas");
        jonasJonaitis.setLastName("Jonaitis");
        jonasJonaitis.setSalary(3200.00);

        RepairingWorkshop volvoServisas = new RepairingWorkshop();
        volvoServisas.setName("UAB VOLVO");
        volvoServisas.setAddress("Minsko plentas 9, Vilnius");

        RepairingWorkshop centrakoServisas = new RepairingWorkshop();
        centrakoServisas.setName("Centrako");
        centrakoServisas.setAddress("Taikos 135, Kaunas");

        Vehicle abc001 = new Vehicle();
        abc001.setBrand("DAF");
        abc001.setCompany(nikVit);
        abc001.setName("fridge");
        abc001.setRegNumber("ABC_001");
        abc001.setTruckDrivers(Arrays.asList(antanasAntanaitis,jonasJonaitis));
        abc001.setRepairingWorkshop(centrakoServisas);
        centrakoServisas.setVehicle(abc001);


        CompanyRepository companyRepository = new CompanyRepository();
        companyRepository.save(nikVit);

        DriverRepository driverRepository = new DriverRepository();
        driverRepository.addNewDriver("Ivanas", "Vlantaniukas", 3000);
        driverRepository.save(antanasAntanaitis);
        driverRepository.save(jonasJonaitis);
        driverRepository.findByLastName("Jonaitis");


        VehiclesRepository vehiclesRepository = new VehiclesRepository();
        vehiclesRepository.save(abc001);

        RepairWorkshopRepository repairWorkshopRepository = new RepairWorkshopRepository();
        repairWorkshopRepository.save(volvoServisas);
        repairWorkshopRepository.save(centrakoServisas);





        Company byName = companyRepository.findByName("UAB NIK&VIT");//find company by id
        System.out.println("Company found" + byName.getName() +" "+ byName.getCountry());
        List<Company> companies = new ArrayList<>();
        companies.add(nikVit);

        //new company
        Company newCompany1 = companyRepository.addNewCompany("DAS","Germany", 2000000);
        Company newCompany2 = companyRepository.addNewCompany("LAS","France",3000000);
        companies.add(newCompany1);
        companies.add(newCompany2);



       companyRepository.findAll().forEach(System.out::println);


        //company data change
        companyRepository.update("GAS", "Estonia", 3L);

        companyRepository.delete("LAS");

        CompanyService companyService = new CompanyService();
        System.out.println();
        System.out.println("This is average budget");
        System.out.println(companyService.getCompaniesAverageBudget(companies));


        session.getTransaction().commit();



//
//        //find by id
//        Long a = 1L;
//        Company company = session.find(Company.class, a);
//        System.out.println(company.getCountry());
//        System.out.println(company.getName());
        //delete company by id
//        session.beginTransaction();
//        session.delete(company);
//        session.getTransaction().commit();





    }

}
