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
    public Project findById(Long id) throws NotFoundException{
        return projectRepository.findById(id).orElseThrow(()->new NotFoundException("Project not found"));
    }

    @Override
    public Optional<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
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
