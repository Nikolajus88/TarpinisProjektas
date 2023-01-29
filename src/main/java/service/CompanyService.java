package service;

import entity.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class CompanyService {
    public  Double getCompaniesAverageBudget(List<Company> companies){
        double totalBudget = 0;
        for (Company company:companies) {
           totalBudget += company.getBudget();
        }
        return totalBudget / companies.size();
    }

}
