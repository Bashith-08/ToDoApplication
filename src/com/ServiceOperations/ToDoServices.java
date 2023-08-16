package com.ServiceOperations;

import java.util.HashMap;



public class ToDoServices {
	
	
	HashMap<Integer, ToDoClass> hashMap = new HashMap<Integer, ToDoClass>();
    

	HashMap<Integer, ToDoClass> markedHashMap = new HashMap<Integer, ToDoClass>();
	
	int i=0;
	
	public HashMap<Integer, ToDoClass> addEntry(int id, ToDoClass todoObj) {
        hashMap.put(id, todoObj);
        return hashMap;
    }
    
    public HashMap<Integer, ToDoClass> deleteEntry(int id) {
        hashMap.remove(id);
        return hashMap;
    }
    
    public HashMap<Integer, ToDoClass> updateEntry(int id, ToDoClass todoObj) {
        hashMap.put(id, todoObj);
        return hashMap;
    }
    
    public HashMap<Integer, ToDoClass> markAsComplete(int id) {
    	ToDoClass todoObj = hashMap.remove(id);
    	i++;
        markedHashMap.put(i, todoObj);
        return hashMap;
    }
    
    public HashMap<Integer, ToDoClass> displayCompletedTasks() {
    	
        return markedHashMap;
    }
    
    public HashMap<Integer, ToDoClass> clearAllTasks() {
        hashMap.clear();
        return hashMap;
    }
    
    

}
