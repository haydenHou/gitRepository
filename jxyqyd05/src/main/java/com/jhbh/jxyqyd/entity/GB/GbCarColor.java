package com.jhbh.jxyqyd.entity.GB;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GbCarColor extends GBEntity{

    private Integer gbCarcolorId;

    private String typeCode;

    private String typeName;




}