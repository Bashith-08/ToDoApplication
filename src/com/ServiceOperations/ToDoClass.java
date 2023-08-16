package com.ServiceOperations;


public class ToDoClass {
	
	public int id;
    public String task;
    public String category;
    
	public ToDoClass(String task, String category) {
		super();
		this.task = task;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		
		return id +" | "+task+" | "+category;
	}
	
	
	

	

}
