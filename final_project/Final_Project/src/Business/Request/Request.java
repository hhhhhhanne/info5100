/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

/**
 *
 * @author Chance
 */
public abstract class Request {
    private int id;
    private static int count;
    private RequestType type;
    
    public Request(RequestType type) {
        count ++;
        this.id = count;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public RequestType getType() {
        return type;
    }
    
    public enum RequestType{
        FoodRequest("FoodRequest"), SupplierRequest("SupplierRequest"), UserRequest("UserRequest");
        
        private String value;
        private RequestType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
    
}
