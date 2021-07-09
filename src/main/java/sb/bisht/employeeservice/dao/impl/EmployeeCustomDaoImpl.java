package sb.bisht.employeeservice.dao.impl;

import sb.bisht.employeeservice.dao.EmployeeCustomDao;
import sb.bisht.employeeservice.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeeCustomDaoImpl implements EmployeeCustomDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> searchEmployeeByCriteria(Map<String, String> mapCriteria) {
        StringBuilder whereClause = new StringBuilder("");
        Iterator<Map.Entry<String, String>> itr = mapCriteria.entrySet().iterator();
        whereClause.append(itr.hasNext() ? " WHERE " : " ");

        while (itr.hasNext()) {
            Map.Entry<String, String> entry = itr.next();
            if (entry.getKey().equals("name")) {
                whereClause.append(" (emp.firstName Like '" + entry.getValue() + "%' or emp.lastName LIKE '" + entry.getValue() + "%') ");
            } else {
                whereClause.append(" " + entry.getKey() + " = '" + entry.getValue() + "'");
            }

            whereClause.append(itr.hasNext() ? " and " : " ");
        }
        return entityManager.createQuery("SELECT emp FROM Employee emp " + whereClause.toString(), Employee.class).getResultList();
    }
}
