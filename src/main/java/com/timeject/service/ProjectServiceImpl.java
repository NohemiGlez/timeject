package com.timeject.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.timeject.exception.NotFoundException;
import com.timeject.model.Project;
import com.timeject.model.ProjectType;
import com.timeject.repository.ProjectRepository;
import com.timeject.repository.ProjectTypeRepository;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    
//    @Inject
    private ProjectTypeRepository projectTypeRepository;

    @Override
    public Project findById(Long id) throws NotFoundException{
        return projectRepository.findById(id).orElseThrow(()->new NotFoundException("Project not found"));
    }

    @Override
    public Optional<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(Project project) {
    	Long projectTypeId = project.getType().getId();
    	projectTypeRepository.deleteById(projectTypeId);
        projectRepository.delete(project);
    }

    @Inject
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<Project> findAll(){
        return projectRepository.findAllByOrderByIdDesc();
    }

    @Override
    public void update(Project project) throws NotFoundException {
        Optional<Project> projectOptional= projectRepository.findById(project.getId());
        if(!projectOptional.isPresent()){
            throw new NotFoundException("Entity not found to be updated");
        }
    }

	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}
}
