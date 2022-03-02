package com.tsi.rhys.meyer.demoTest;

import com.tsi.rhys.meyer.DatabaseProject.Actor.Actor;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActorTest {

    private Actor actor = new Actor();

    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Actor", actor instanceof Actor);
    }

    @Test
    public void test_getFirstName(){
        actor.setFirst_name("Test");
        assertEquals("Test", actor.getFirst_name());
    }

    @Test
    public void test_actorInstantiation(){
//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());
        actor = new Actor(1,"Tested","Name");
        assertEquals("Tested", actor.getFirst_name());
        assertEquals("Name", actor.getLast_name());
        assertEquals(1,actor.getActor_id());
//        assertEquals(ts,actor.getLast_update());
    }

    @Test
    public void test_actorInstantiation2(){
        actor = new Actor("Test","Name");
        assertEquals("Test", actor.getFirst_name());
        assertEquals("Name", actor.getLast_name());
    }
//????
    @Test
    public void test_getLastName(){
        actor.setLast_name("Name");
        assertEquals("Name", actor.getLast_name());
    }

    @Test
    public void test_getID(){
        actor.setActor_id(100);
        assertEquals(100,actor.getActor_id());
    }


//    @Test
//    public void test_setTimeStamp(){
//        Date date = new Date();
//        Timestamp ts = new Timestamp(date.getTime());
//        actor.setLast_update(ts);
//        assertEquals(ts,actor.getLast_update());
//
//    }
}
