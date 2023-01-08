package com.github.wemersonwalcley.repository.task;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevelEnum;
import com.github.wemersonwalcley.enumerator.TaskResponsibleEnum;
import com.github.wemersonwalcley.enumerator.TaskSituationEnum;

public class PersistenceModel {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskManagerPU");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		//Declarando os repositórios
		TaskRepository taskRepository = new TaskRepository(entityManager);
		
		//Criando task1
		Task task1 = new Task();
		task1.setTitle("Projeto ESIG");
		task1.setDescription("Gerendiacor de tarefas");
		task1.setDeadline(new Date());
		task1.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.HIGH);
		task1.setTaskResponsibleEnum(TaskResponsibleEnum.WEMERSON);
		task1.setTaskSituationEnum(TaskSituationEnum.IN_PROGRESS);
		
		//Criando task2
		Task task2 = new Task();
		task2.setTitle("Projeto Pessoal");
		task2.setDescription("descrição de projeto exemplo");
		task2.setDeadline(new Date());
		task2.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.MEDIUM);
		task2.setTaskResponsibleEnum(TaskResponsibleEnum.RICARDO);
		task2.setTaskSituationEnum(TaskSituationEnum.IN_PROGRESS);
		
		//Criando task2
		Task task3 = new Task();
		task3.setTitle("Projeto TCC");
		task3.setDescription("descrição de projeto TCC");
		task3.setDeadline(new Date());
		task3.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.HIGH);
		task3.setTaskResponsibleEnum(TaskResponsibleEnum.WEMERSON);
		task3.setTaskSituationEnum(TaskSituationEnum.IN_PROGRESS);
		
		//Criando task2
		Task task4 = new Task();
		task4.setTitle("Projeto TCC-PT-1");
		task4.setDescription("TCC parte 1");
		task4.setDeadline(new Date());
		task4.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.HIGH);
		task4.setTaskResponsibleEnum(TaskResponsibleEnum.RICARDO);
		task4.setTaskSituationEnum(TaskSituationEnum.IN_PROGRESS);
		
		//Criando task2
		Task task5 = new Task();
		task5.setTitle("Projeto TCC PT 1");
		task5.setDescription("descrição de projeto TCC PT 1");
		task5.setDeadline(new Date());
		task5.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.LOW);
		task5.setTaskResponsibleEnum(TaskResponsibleEnum.WEMERSON);
		task5.setTaskSituationEnum(TaskSituationEnum.COMPLETED);
		
		//Criando task2
		Task task6 = new Task();
		task6.setTitle("Projeto Portifólio");
		task6.setDescription("descrição de projeto portifólio");
		task6.setDeadline(new Date());
		task6.setTaskPriorityLevelEnum(TaskPriorityLevelEnum.LOW);
		task6.setTaskResponsibleEnum(TaskResponsibleEnum.WALLAS);
		task6.setTaskSituationEnum(TaskSituationEnum.DELETED);
		
		//Salvando TASK
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);
		taskRepository.save(task5);
		taskRepository.save(task6);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		}

}
