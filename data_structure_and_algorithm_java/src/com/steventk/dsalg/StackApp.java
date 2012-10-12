package com.steventk.dsalg;

public class StackApp {

}

class StackX<T>{
	private int maxSize;
	private T[] stackArray; 
	private int top;
	
	public StackX(int maxSize){
		this.maxSize = maxSize;
		this.top = -1;
	}
	
	public void push(T element){
		this.stackArray[++top] = element;
	}
	
	public T pop() {
		return this.stackArray[top--];
	}
	
	public T peek() {
		return this.stackArray[top];
	}
	
	public boolean isFull() {
		return top == this.maxSize - 1;
	}
	
	
	public boolean isEmpty() {
		return top == -1;
	}
}
