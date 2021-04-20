/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speed_traffick_pack;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Car_Queue {

    Car_Node head;
    Car_Node tail;
    Integer count;

    public Car_Queue() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Car car) {
        if (isEmpty()) {
            head = new Car_Node(car);
            tail = head;
        } else {
            Car_Node temporal = new Car_Node(car);
            tail.next = temporal;
            tail = temporal;
        }
        count++;        
    }
    
    public Car dequeue(){
        
        if(isEmpty()){            
            return null;
        }else if (count > 1){
            Car temporal = tail.car;
            Car_Node temp = head;
            for(int i = 0 ; temp.next.next != null ; i++){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            count--;
            return temporal;            
        }
        else{
            Car temporal = tail.car;
            clean();
            return temporal;            
        }
        
    }
    
    public Integer size(){
        return count;
    }
    
    private void clean(){
        head = null;
        tail = null;
        count = 0;
    }
    
    

}
