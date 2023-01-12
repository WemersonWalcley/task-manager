package com.github.wemersonwalcley.repository.task;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevelEnum;
import com.github.wemersonwalcley.enumerator.TaskResponsibleEnum;

public class TaskRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;
	
	public TaskRepository() {}
	
	public TaskRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Task findById(Long id) {
		return entityManager.find(Task.class, id);
	}

	public List<Task> findAll(){
		return entityManager.createQuery("FROM Task c WHERE c.taskSituationEnum = com.github.wemersonwalcley.enumerator.TaskSituationEnum.IN_PROGRESS ORDER BY c.id DESC", Task.class).getResultList();
	}
	
	public List<Task> findAllByFilter(String title, TaskResponsibleEnum responsibleFilter, TaskPriorityLevelEnum priorityFilter, Long id){
		String jpql = "FROM Task WHERE taskSituationEnum = com.github.wemersonwalcley.enumerator.TaskSituationEnum.IN_PROGRESS AND (title = :title OR taskResponsibleEnum = :responsibleFilter OR taskPriorityLevelEnum = :priorityFilter OR id = :id)";
		TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);
		query.setParameter("title", title);
		query.setParameter("responsibleFilter", responsibleFilter);
		query.setParameter("priorityFilter", priorityFilter);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public Task save(Task task) {
		return entityManager.merge(task);
	}
	
	public void delete(Task task) {
		task = findById(task.getId());
		entityManager.remove(task);
	}

}
