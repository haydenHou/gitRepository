package com.jhbh.jxyqyd.entity.GB;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GbCarDamage extends GBEntity{
    private Integer gbDamageId;

    private String typeCode;

    private String typeName;


}