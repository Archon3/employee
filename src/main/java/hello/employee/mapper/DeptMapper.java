package hello.employee.mapper;

import hello.employee.dto.DeptRequest;
import hello.employee.dto.DeptResponse;
import hello.employee.entity.Dept;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = SimpleMapperConfig.class)
public interface DeptMapper {

    Dept toDept(DeptRequest request);

    Dept toDeptCreate(DeptRequest request);

    @Named("toDeptResponse")
    DeptResponse toDeptResponse(Dept dept);

    @IterableMapping(qualifiedByName = "toDeptResponse")
    List<DeptResponse> toDeptResponseList(List<Dept> deptList);

}
