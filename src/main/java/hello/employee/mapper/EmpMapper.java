package hello.employee.mapper;

import hello.employee.dto.EmpRequest;
import hello.employee.dto.EmpResponse;
import hello.employee.entity.Emp;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;


@Mapper(config = SimpleMapperConfig.class)
public interface EmpMapper {

    Emp toEmp(EmpRequest request);

    Emp toEmpCreate(EmpRequest request);

    @Named("toEmpResponse")
    EmpResponse toEmpResponse(Emp emp);

    @IterableMapping(qualifiedByName = "toEmpResponse")
    List<EmpResponse> toEmpResponseList(List<Emp> empList);

}

