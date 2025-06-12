package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {

    private String name;
    private String phone;
    private String fax;
    private String rating;
}