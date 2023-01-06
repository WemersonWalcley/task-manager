package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.repository.task.TaskRepository;

import util.Transactional;

public class TaskServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TaskRepository taskRepository;
	
	@Transactional
	public void create(Task task) {
		taskRepository.save(task);
	}
	
	@Transactional
	public void delete(Task task) {
		taskRepository.delete(task);
	}

}
