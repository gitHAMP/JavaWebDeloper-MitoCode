package com.mitocode.programstream;

import static com.mitocode.utils.DataUtils.getTasks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Examples {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();
		List<String> readingTasks=allReadingTasks(tasks);
		readingTasks.forEach(System.out::println);
		
		List<Task> distinctTasks = allDistinctTasks(tasks);
		distinctTasks.forEach(System.out::println);
		
		List<String> topNTasks=topN(tasks,3,1);
		topNTasks.forEach(System.out::println);
		
		long count=countAllReadingTasks(tasks);
		System.out.println(count);
	}

	// TODO Ejemplo 1: Encuentra todas los t�tulos de tareas de lectura ordenadas por la fecha de creaci�n
	private static List<String> allReadingTasks(List<Task> tasks) {
		 return tasks.stream().
		            filter(task -> task.getType() == TaskType.READING).
		            sorted(comparing(Task::getCreatedOn).reversed()).
		            map(Task::getTitle).
		            collect(Collectors.toList());
	}
	
	//TODO Ejemplo 2: Encuentra tareas distintas
	public static List<Task> allDistinctTasks(List<Task> tasks) {
	    return tasks.stream().distinct().collect(toList());
	}
	
	//TODO Ejemplo 3: Encuentra la 5 primeras tareas de lectura ordenadas por fecha de creaci�n
	// La p�gina comienza en 0. As� que la segunda p�gina (`page`) ser� 1 y la p�gina n ser� n-1.
	public static List<String> topN(List<Task> tasks, int n, int page){
	    return  tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(comparing(Task::getCreatedOn).reversed()).
                map(Task::getTitle).
                skip(page * n). //obtenemos los productos a partir del page*n (inclusive)
                limit(n).
                collect(toList());
	}
	
	//TODO: Ejemplo 4: Cuenta todas las tareas de lectura
	public static long countAllReadingTasks(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            count();
	}

}
