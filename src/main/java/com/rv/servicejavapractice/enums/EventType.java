/**
 * 
 */
package com.rv.servicejavapractice.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ravi Thummar
 *
 */
public enum EventType {
//	event_one(1, "ONE"), event_two(2, "TWO");
//
//    private final int value;
//    private final String eventName;
//
//    private EventType(int EventType, String name) {
//        this.value = EventType;
//        this.eventName = name;
//    }
//
//    public String getEventName() {
//        return eventName;
//    }
//
//    public int getValue() {
//        return this.value;
//    }
//    
//    public String getEventName(int id) { return EventType.values()[id].getEventName(); }
	
	event_one(1, "ONE"), event_two(2, "TWO");

    private final int value;
    private final String eventName;

    private EventType(int EventType, String name) {
        this.value = EventType;
        this.eventName = name;
    }

    public String getEventName() {
        return eventName;
    }

    public int getValue() {
        return this.value;
    }

    static Map<Integer, EventType> map = new HashMap();

    static {
        for (EventType catalog : EventType.values()) {
            map.put(catalog.value, catalog);
        }
    }

    public static EventType getByCode(int code) {
        return map.get(code);
    }
    public static EventType getByPosition(int positionCode) {
        return EventType.values()[positionCode - 1];
    }

    public static void main(String[] args) {
        String name = EventType.getByCode(1).getEventName();
        System.out.println(EventType.getByPosition(1).getEventName());
        System.out.println(name);
    }
    
    
}
