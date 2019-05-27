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
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
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
//        Optional<Project> projectOptional= projectRepository.findById(project.getId());
//        if(!projectOptional.isPresent()){
//            throw new NotFoundException("Entity not found to be updated");
//        }
    	System.out.println(project.getName() + project.getId() + project.getDescription());
        projectRepository.save(project);
    }

	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}
}
