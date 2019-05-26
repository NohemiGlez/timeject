package com.timeject.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeject.model.ProjectType;
import com.timeject.service.ProjectTypeService;
@Controller
@RequestMapping(value="/project/type")
public class ProjectTypeController {

	private final ProjectTypeService projectTypeService;

	@Inject
	public ProjectTypeController(ProjectTypeService projectTypeService) {
        this.projectTypeService= projectTypeService;
    }

	@GetMapping( value={"","/"})
	public @ResponseBody String[] getTypes() {
		String[] types = {ProjectType.Type.A.name(), ProjectType.Type.B.name(), ProjectType.Type.C.name()};
		return types;
	}

}
