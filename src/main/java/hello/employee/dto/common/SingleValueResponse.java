package hello.employee.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleValueResponse {

    private Object value;
}
