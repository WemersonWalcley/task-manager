import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.github.wemersonwalcley.entity.Task;

public class MainApplication {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TaskManagerPU");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<Task> taskList = entityManager.createQuery("from Task", Task.class).getResultList();
		
		System.out.println(taskList);
		
	}

}
