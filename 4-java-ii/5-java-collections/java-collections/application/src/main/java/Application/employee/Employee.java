package Application.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Employee(String name, LocalDate birthDate, BigDecimal salary, String departament) {

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public BigDecimal getSalary(){
        return salary;
    }

    public String getDepartament(){
        return departament;
    }
}
