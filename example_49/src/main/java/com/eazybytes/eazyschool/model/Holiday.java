package com.eazybytes.eazyschool.model;

import lombok.Data;
//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name="holidays")
public class Holiday extends BaseEntity {

    // fields
    @Id
    private  String  day;

    private  String reason;

    @Enumerated(EnumType.STRING)
    private  Type type;
    // enum = constant
    public enum Type {
        FESTIVAL, FEDERAL
    }

}
