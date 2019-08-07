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

public class GbComtypeTable extends GBEntity{

    private Integer gbComtypeId;

    private String typeCode;

    private String typeName;


}