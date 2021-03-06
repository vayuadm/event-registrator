package com.hpe.ceribro.controllers.resources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class ALMData {

    private List<Domain> domains;

    private List<Module> modules;

}
