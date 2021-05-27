package com.mitocode.programstream;

import static com.mitocode.utils.DataUtils.getTasks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

public class Examples {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();
		List<String> readingTasks=allReadingTasks(tasks);
		readingTasks.forEach(System.out::println);
	}

	// TODO Ejemplo 1: Encuentra todas los t�tulos de tareas de lectura ordenadas por la fecha de creaci�n
	private static List<String> allReadingTasks(List<Task> tasks) {
		return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            sorted(Comparator.comparing(Task::getCreatedOn)).
	            map(Task::getTitle).
	            collect(Collectors.toList());
	}

}
