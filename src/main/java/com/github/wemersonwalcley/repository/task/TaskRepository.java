package com.github.wemersonwalcley.repository.task;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevel;
import com.github.wemersonwalcley.enumerator.TaskResponsible;
import com.github.wemersonwalcley.enumerator.TaskSituation;


public class TaskRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public Task findById(Long id) {
		return entityManager.find(Task.class, id);
	}

	public List<Task> findAll(){
		TypedQuery<Task> query = entityManager.createQuery("SELECT e FROM Task e", Task.class);
		return query.getResultList();
	}
	
	public List<Task> findAllByFilter(String title){
		String jpql = "SELECT e FROM Task e WHERE e.title=:title";
		TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);
		query.setParameter("title", title);
		return query.getResultList();
	}
	
	public Task save(Task task) {
		return entityManager.merge(task);
	}
	
	public void delete(Task task) {
		task = findById(task.getId());
		entityManager.remove(task);
	}
	
	/*
	 * public List<Task> findAllByFilter(int id, String titulo, TaskResponsible
	 * responsible, TaskPriorityLevel priorityLevel, TaskSituation situation ){
	 * TypedQuery<Task> query =
	 * entityManager.createNamedQuery("SELECT e FROM Task e WHERE e.id=:id",
	 * Task.class); query.setParameter("id", id); return query.getResultList(); }
	 */

}
