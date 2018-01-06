package com.itcast.basic.designpatterntype.iterator;

import com.itcast.basic.designpatterntype.iterator.impl.NameRepository;
import com.itcast.basic.designpatterntype.iterator.service.Iterator;

public class IteratorSeriviceClient {

    public static void main(String[] args) {

        try {
            NameRepository namesRepository = new NameRepository(new String[]{"Robert", "John", "Julie", "Lora"});

            for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                System.out.println("Name : " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}