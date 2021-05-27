package com.mitocode.programstream;

import java.util.List;
import java.util.stream.Collectors;

import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

import static com.mitocode.utils.DataUtils.getTasks; 

public class Example1_Stream {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();

        List<String> readingTasks = tasks.stream()
                .filter(task -> task.getType() == TaskType.READING)
                .sorted((t1, t2) -> t1.getTitle().length() - t2.getTitle().length())
                .map(Task::getTitle)
                .collect(Collectors.toList());

        readingTasks.forEach(System.out::println);

	}

}
