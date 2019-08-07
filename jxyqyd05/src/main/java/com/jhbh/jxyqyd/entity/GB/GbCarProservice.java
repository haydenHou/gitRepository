package com.jhbh.jxyqyd.entity.GB;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GbCarProservice extends GBEntity{
    private Integer gbProserviceId;

    private String typeCode;

    private String typeName;


}