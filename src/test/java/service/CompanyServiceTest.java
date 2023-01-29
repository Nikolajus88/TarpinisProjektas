package service;

import entity.Company;
import org.hibernate.Session;
import org.junit.Test;
import utils.HibernateUtil;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CompanyServiceTest {

    @Test
        public void testGetCompaniesAverageBudget() {
        CompanyService companyService = new CompanyService();
            // Create test data
            Company company1 = new Company(1L, "Google", "ES", 1000000,null);
            Company company2 = new Company(2L, "Facebook", "ES", 2000000, null);
            Company company3 = new Company(3L, "Amazon", "ES",  3000000, null);
            List<Company> companies = Arrays.asList(company1, company2, company3);
            // Test the method
            int expectedAverage = ((company1.getBudget() + company2.getBudget() + company3.getBudget()) / 3);
            Double actualAverage = companyService.getCompaniesAverageBudget(companies);
            assertEquals(expectedAverage, actualAverage, 0.001);

        }

}