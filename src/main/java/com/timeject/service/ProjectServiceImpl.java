package com.timeject.service;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;
import com.timeject.repository.ProjectRepository;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Project> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Inject
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<Project> findAll(){
        return projectRepository.findAll();
    }

    @Override
    public void update(Project project) throws NotFoundException {
        Optional<Project> projectOptional= projectRepository.findById(project.getId());
        if(!projectOptional.isPresent()){
            throw new NotFoundException("Entity not found to be updated");
        }
    }
}
