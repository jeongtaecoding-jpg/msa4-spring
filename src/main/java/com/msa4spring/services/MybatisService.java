package com.msa4spring.services;

import com.msa4spring.entities.Employee;
import com.msa4spring.mappers.EmployeeMapper;
import com.msa4spring.requests.EmployeesStoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 통신 과정(employees/index 기준) 간단하게 요약 (excepionhandler가 이 모든 과정을 감싸고 있으며 에러 발생 시 excepionhandler가 대신 res를 보내줌)

//           ->  request  -> 1. controller(ResponseDTO 호출) -> 2.  Service  -> 3. Mybatis Mapper  ->
// 클라이언트                                                                                           DB와 통신
//           <- response 객체 <-          response           <-              <-                   <-


@Service
@RequiredArgsConstructor
public class MybatisService {
    private final EmployeeMapper employeeMapper;

    public List<Employee> getEmployees() {
        return employeeMapper.getEmployees();
    }

    @Transactional
    public Employee store(EmployeesStoreRequest employeesStoreRequest) {
        Employee employee = new Employee();
        employee.setBirth(employeesStoreRequest.birth());
        employee.setGender(employeesStoreRequest.gender());
        employee.setName(employeesStoreRequest.name());

        employeeMapper.store(employee);

        return employeeMapper.findByPk(employee.getEmpId());
    }

}



